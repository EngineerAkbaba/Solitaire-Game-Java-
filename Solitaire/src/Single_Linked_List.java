import java.awt.Color;
import java.util.Random;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class Single_Linked_List
{
	enigma.console.Console cn = Enigma.getConsole();
	
	// Define head for the single linked list
	private SLL_Node head;
	
	// Adding new element without any condition
	public void add(Cards dataToAdd)
	{
		if (head == null) // if the list is empty
		{
			head = new SLL_Node(dataToAdd);
		}
		else
		{
			SLL_Node newNode = new SLL_Node(dataToAdd);
			newNode.setLink(head);
			head = newNode;
		}
	}
	
	// Searching for an element
	public boolean Search (Object dataToSearch)
	{
		if (head != null) // if the list is empty
		{
			SLL_Node temp = head;
			do
			{
				if (head.getData() == dataToSearch) // if the data that we want to find has been found
				{
					return true;
				}
				temp = temp.getLink();
			} while (temp != null);
		}
		return false;
	}
	
	// Printing the Linked List on the screen
	public void display()
	{
		int counter = 0;
		if (head == null) // if the list is empty
		{
			System.out.println("Linked List is Empty");
		}
		else
		{
			SLL_Node temp = head;
			// Defining the colors of the cards
			TextAttributes card_color1 = null; // for heart and diamond
			TextAttributes card_color2 = null; // for spade and club
			while (temp != null)
			{
				// Defining a counter value for space in all 13 lines 1
				if(counter % 13 == 0)
				{
					System.out.println();
				}
				// Defining the color red for hearts-diamonds and darkGray for spades-clubs and printing they on the screen
				if (temp.getData().getCard_suit() == "\u2665" || temp.getData().getCard_suit() == "\u2666")
				{
					card_color1 = new TextAttributes(Color.red);
					cn.getTextWindow().output("      " + temp.getData().getCard_suit() + temp.getData().getCard_number(), card_color1);
				}
				else if (temp.getData().getCard_suit() == "\u2663" || temp.getData().getCard_suit() == "\u2660")
				{
					card_color2 = new TextAttributes(Color.darkGray);
					cn.getTextWindow().output("      " + temp.getData().getCard_suit() + temp.getData().getCard_number(), card_color2);
				}
				temp = temp.getLink();
				counter++;
			}
		}
	}
	
	// Creating deck for cards
	public Single_Linked_List deck ()
	{
		Single_Linked_List s = new Single_Linked_List();
		String temp_card_suit = " ";
		String temp_card_number = " ";
		for (int i = 0; i < 4; i++) // this loop is for card suits
		{
			if (i == 0)
			{
				temp_card_suit = "\u2665"; // Heart (Kalp)
			}
			else if (i == 1)
			{
				temp_card_suit = "\u2666"; // Diamond (Karo)
			}
			else if (i == 2)
			{
				temp_card_suit = "\u2660"; // Spade (Maça)
			}
			else if (i == 3)
			{
				temp_card_suit = "\u2663"; // Club (Sinek)
			}
			for (int j = 1; j <= 13; j++) // this for is for card numbers
			{
				if (j == 1)
				{
					temp_card_number = "A";
				}
				else if (j == 11)
				{
					temp_card_number = "J";
				}
				else if (j == 12)
				{
					temp_card_number = "Q";
				}
				else if (j == 13)
				{
					temp_card_number = "K";
				}
				else
				{
					temp_card_number = Integer.toString(j);
				}
				// Adding the cards to the single linked list
				Cards c = new Cards();
				c.setCard_suit(temp_card_suit);
				c.setCard_number(temp_card_number);
				s.add(c);
			}
		}
		return s;
	}
	
	// Defining a delete method to shuffle the cards
	public SLL_Node delete_for_shuffle (int number)
	{
		SLL_Node front = head;
		int count = 0;
		SLL_Node temp = head;
		while (temp != null)
		{
			if (number == 0)
			{
				head = head.getLink();
				return temp;
			}
			else if (number == count)
			{
				front.link = temp.link;
				return temp;
			}
			else
			{
				front = temp;
				temp=temp.link;
			}
			count++;
		}
		return null;
	}
	
	// Shuffling the cards
	public void shuffle (Single_Linked_List s)
	{
		Random rnd = new Random();
		for (int i = 0; i < 52; i++)
		{
			int number = rnd.nextInt(52);
			SLL_Node new_node = new SLL_Node(delete_for_shuffle(number).getData());
			Cards cs = new Cards();
			cs.setCard_suit(new_node.getData().getCard_suit());
			cs.setCard_number(new_node.getData().getCard_number());
			s.add(cs);
		}
	}
	
}

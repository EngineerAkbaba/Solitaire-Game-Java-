import java.awt.Color;
import java.util.Random;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class Multi_Linked_List
{
	enigma.console.Console cn = Enigma.getConsole();
	
	// Fields
	Category_MLL_Node head;
	String tempcategory = " ";
	
	// Adding P1 , P2, ... P7 categories without any sort condition
	public void add_category (Object dataToAdd)
	{
		if (head ==null) // if the list is empty
		{
			Category_MLL_Node newnode = new Category_MLL_Node(dataToAdd);
			head = newnode;
		}
		else
		{
			Category_MLL_Node temp = head;
			while (temp.getRight_link() != null)
			{
				temp = temp.getRight_link();
			}
			Category_MLL_Node newnode = new Category_MLL_Node(dataToAdd);
			temp.setRight_link(newnode);
		}
	}
	
	// Defining a method for creating all cards and categories
	public void add_item (String category, Cards c)
	{
		if (head == null) // if there is no any category
		{
			System.out.println("Please add a category before adding card items");
		}
		else
		{
			Category_MLL_Node temp = head;
			while (temp != null) // traverse the categories to find the category that we want to add card item to it
			{
				if (category.equals(temp.getCategory())) // if the category that we're looking for has been found
				{
					// add card item to that category like single linked list
					Item_MLL_Node temp2 = temp.getDown_link();
					if (temp2 == null) // if there is no any card item in that category
					{
						temp2 = new Item_MLL_Node(c);
						temp.setDown_link(temp2);
					}
					else // if there exist card item, add the end of them
					{
						while (temp2.getNext_link() != null)
						{
							temp2 = temp2.getNext_link();
						}
						Item_MLL_Node newnode = new Item_MLL_Node(c);
						temp2.setNext_link(newnode);
					}
				}
				temp = temp.getRight_link();
			}
		}
	}
	
	// Count the number of the items
	public int SizeItem()
	{
		int count = 0;
		if (head == null) // if the list is empty
		{
			System.out.println("Your list is empty");
		}
		else
		{
			Category_MLL_Node temp=head;
			while(temp!=null)
			{
				Item_MLL_Node temp2 = temp.getDown_link();
				while(temp2 != null)
				{
					count++;
					temp2 = temp2.getNext_link();
				}
				temp = temp.getRight_link();
			}
		}
		return count;
	}	
	
	// Adding P1 , P2, ... P7 categories and card items to the multi linked list
	public void create_all_cards ()
	{
		//Multi_Linked_List m = new Multi_Linked_List(); // create an object of the multi linked list linked list
		Single_Linked_List s = new Single_Linked_List(); // create an object of the single linked list
		s = s.deck(); // send the object of the sll to deck method to fill it
		s.shuffle(s); // send the object of the sll to shuffle method to mix it
		int count = 1;
		Random rnd = new Random();
		int number = rnd.nextInt(20); // 28 cards to screen
		for (int i = 1; i <= 7; i++)
		{
			if (i == 1)
			{
				add_category("P1"); // add category to multi linked list
				for (int j = 0; j < count; j++)
				{
					Cards cs = new Cards(); // create an object of the Cards method
					SLL_Node new_node = new SLL_Node(s.delete_for_shuffle(number).getData());
					cs.setCard_suit(new_node.getData().getCard_suit()); // set cards suit to cs object
					cs.setCard_number(new_node.getData().getCard_number()); // set cards number to cs object
					add_item("P1", cs); // add cs object to multi linked list
				}
				count++;
			}
			else if (i == 2)
			{
				add_category("P2"); // add category to multi linked list
				for (int j = 0; j < count; j++)
				{
					Cards cs = new Cards(); // create an object of the Cards method
					SLL_Node new_node = new SLL_Node(s.delete_for_shuffle(number).getData());
					cs.setCard_suit(new_node.getData().getCard_suit()); // set cards suit to cs object
					cs.setCard_number(new_node.getData().getCard_number()); // set cards number to cs object
					add_item("P2", cs); // add cs object to multi linked list
				}
				count++;
			}
			else if (i == 3)
			{
				add_category("P3"); // add category to multi linked list
				for (int j = 0; j < count; j++)
				{
					Cards cs = new Cards(); // create an object of the Cards method
					SLL_Node new_node = new SLL_Node(s.delete_for_shuffle(number).getData());
					cs.setCard_suit(new_node.getData().getCard_suit()); // set cards suit to cs object
					cs.setCard_number(new_node.getData().getCard_number()); // set cards number to cs object
					add_item("P3", cs); // add cs object to multi linked list
				}
				count++;
			}
			else if (i == 4)
			{
				add_category("P4"); // add category to multi linked list
				for (int j = 0; j < count; j++)
				{
					Cards cs = new Cards(); // create an object of the Cards method
					SLL_Node new_node = new SLL_Node(s.delete_for_shuffle(number).getData());
					cs.setCard_suit(new_node.getData().getCard_suit()); // set cards suit to cs object
					cs.setCard_number(new_node.getData().getCard_number()); // set cards number to cs object
					add_item("P4", cs); // add cs object to multi linked list
				}
				count++;
			}
			else if (i == 5)
			{
				add_category("P5"); // add category to multi linked list
				for (int j = 0; j < count; j++)
				{
					Cards cs = new Cards(); // create an object of the Cards method
					SLL_Node new_node = new SLL_Node(s.delete_for_shuffle(number).getData());
					cs.setCard_suit(new_node.getData().getCard_suit()); // set cards suit to cs object
					cs.setCard_number(new_node.getData().getCard_number()); // set cards number to cs object
					add_item("P5", cs); // add cs object to multi linked list
				}
				count++;
			}
			else if (i == 6)
			{
				add_category("P6"); // add category to multi linked list
				for (int j = 0; j < count; j++)
				{
					Cards cs = new Cards(); // create an object of the Cards method
					SLL_Node new_node = new SLL_Node(s.delete_for_shuffle(number).getData());
					cs.setCard_suit(new_node.getData().getCard_suit()); // set cards suit to cs object
					cs.setCard_number(new_node.getData().getCard_number()); // set cards number to cs object
					add_item("P6", cs); // add cs object to multi linked list
				}
				count++;
			}
			else if (i == 7)
			{
				add_category("P7"); // add category to multi linked list
				for (int j = 0; j < count; j++)
				{
					Cards cs = new Cards(); // create an object of the Cards method
					SLL_Node new_node = new SLL_Node(s.delete_for_shuffle(number).getData());
					cs.setCard_suit(new_node.getData().getCard_suit()); // set cards suit to cs object
					cs.setCard_number(new_node.getData().getCard_number()); // set cards number to cs object
					add_item("P7", cs); // add cs object to multi linked list
				}
				count++;
			}
		}
	}
	
	// Displaying the all categories and the card items on the screen
	public void display ()
	{	cn.getTextWindow().setCursorPosition(0, 0);
		int category_positionx = 32;
		int suit_positionx = 32;
		int suit_positiony = 12;
		int number_positionx = 33;
		int number_positiony = 12;
		int suit_count = 0;
		int number_count = 0;
		
		if (head == null) // if there is no any category
		{
			System.out.println("There is no any category and card, the linked list is empty");
		}
		else // if there exist category, then traverse the category
		{
			Category_MLL_Node temp = head;
			while (temp != null)
			{
				TextAttributes category_color = new TextAttributes(Color.red, Color.green);
				cn.getTextWindow().setCursorPosition(category_positionx, 10);
				cn.getTextWindow().output(temp.getCategory() + " ", category_color);
				Item_MLL_Node temp2 = temp.getDown_link();
				if (temp2 == null) //if there exist category but NO any item in that category
				{
					System.out.println("There is no any card item in this category");
				}
				else // if there exist card item in that category, then traverse the card items
				{
					while (temp2 != null)
					{
						// Defining the color red for hearts-diamonds and black for spades-clubs and gren for the space
						TextAttributes item_color1 = new TextAttributes(Color.red, Color.white); // for heart and diamond
						TextAttributes item_color2 = new TextAttributes(Color.black, Color.white); // for spade and club
						TextAttributes space_color = new TextAttributes(Color.blue, Color.white);
						
						if (temp2.getNext_link() == null) // print the LAST cards
						{
							if (temp2.getItem().getCard_suit() == "\u2665" || temp2.getItem().getCard_suit() == "\u2666") // heart or diamond
							{
								cn.getTextWindow().setCursorPosition(suit_positionx, suit_positiony);
								cn.getTextWindow().output(temp2.getItem().getCard_suit(), item_color1);
								//***************
								cn.getTextWindow().setCursorPosition(number_positionx, number_positiony);
								cn.getTextWindow().output(temp2.getItem().getCard_number() + " ", item_color1);
							}
							else if (temp2.getItem().getCard_suit() == "\u2663" || temp2.getItem().getCard_suit() == "\u2660") // spade or club
							{
								cn.getTextWindow().setCursorPosition(suit_positionx, suit_positiony);
								cn.getTextWindow().output(temp2.getItem().getCard_suit(), item_color2);
								//***************
								cn.getTextWindow().setCursorPosition(number_positionx, number_positiony);
								cn.getTextWindow().output(temp2.getItem().getCard_number() + " ", item_color2);
							}
							temp2 = temp2.getNext_link();
							suit_positiony = suit_positiony + 1;
							number_positiony = number_positiony + 1;
						}
						else // print space until the last cards
						{
							cn.getTextWindow().setCursorPosition(suit_positionx, suit_positiony);
							cn.getTextWindow().output("**", space_color);
							//***************
							cn.getTextWindow().setCursorPosition(number_positionx, number_positiony);
							cn.getTextWindow().output("**", space_color);
							//**************
							temp2 = temp2.getNext_link();
							suit_positiony = suit_positiony + 1;
							number_positiony = number_positiony + 1;
						}
					}
					suit_count++;
					number_count++;
					suit_positionx = suit_positionx + 15;
					number_positionx = number_positionx + 15;
					category_positionx = category_positionx + 15;
				}
				temp = temp.getRight_link();
				suit_positiony = suit_positiony - suit_count;
				number_positiony = number_positiony - number_count;
			}
		}
		//**********
		TextAttributes color1 = new TextAttributes(Color.red, Color.green);
		cn.getTextWindow().setCursorPosition(77, 0);
		cn.getTextWindow().output("SCOR: ", color1);
		//**********
		cn.getTextWindow().setCursorPosition(32, 2);
		cn.getTextWindow().output("ST" + " ", color1);
		//**********
		cn.getTextWindow().setCursorPosition(77, 2);
		cn.getTextWindow().output("OC" + " ", color1);
		//**********
		cn.getTextWindow().setCursorPosition(92, 2);
		cn.getTextWindow().output("OS" + " ", color1);
		//**********
		cn.getTextWindow().setCursorPosition(107, 2);
		cn.getTextWindow().output("OD" + " ", color1);
		//**********
		cn.getTextWindow().setCursorPosition(122, 2);
		cn.getTextWindow().output("OH" + " ", color1);
	}
	
	// Deleting cards from the list
	public Item_MLL_Node deleteItem (Object itemToDel)
	{
		Item_MLL_Node temp3 = null;
		if (head == null)
		{
			System.out.println("Your list is empty");
		}
		else
		{
			Category_MLL_Node temp = head;
			while (temp != null)
			{
				Item_MLL_Node temp2 = temp.getDown_link();
				Item_MLL_Node prev = temp.getDown_link();
				while (temp2 != null)
				{
					if ((temp2.getItem().getCard_suit().equalsIgnoreCase(((String) itemToDel).substring(0,1)) && temp2.getItem().getCard_number().equalsIgnoreCase(((String) itemToDel).substring(1))) && prev.getItem().getCard_suit().equalsIgnoreCase(((String) itemToDel).substring(0,1)) && prev.getItem().getCard_number().equalsIgnoreCase(((String) itemToDel).substring(1)))
					{
                    	temp3 = temp2;
						temp.setDown_link(null);
						tempcategory = (String) temp.getCategory();
						return temp3;
					}
                    else if (temp2.getItem().getCard_suit().equalsIgnoreCase(((String) itemToDel).substring(0,1)) && temp2.getItem().getCard_number().equalsIgnoreCase(((String) itemToDel).substring(1)))
					{
						temp3 = temp2;
						prev.setNext_link(null);
						tempcategory = (String) temp.getCategory();
						return temp3;
					}
					else
					{
						prev = temp2;
						temp2 = temp2.getNext_link();
					}
				}
				temp = temp.getRight_link();
			}
		}
		System.out.println("silindi");
		return temp3;
	}

	
	// Defining an extra delete method for moving the cards
	public void addItemForMove (String categoryToAdd, Item_MLL_Node itemToAdd)
	{
		if (head == null)
		{
			System.out.println("Add category before adding item");
		}
		else
		{
			Category_MLL_Node temp = head;
			while (temp != null)
			{
				if ((categoryToAdd).equalsIgnoreCase((String) temp.getCategory())) // if the category that we want to add has been found
				{
					Item_MLL_Node temp2 = temp.getDown_link();
					if (temp2 == null)
					{
						temp.setDown_link(itemToAdd);
					}
					else
					{
						while (temp2.getNext_link() != null)
						{
							temp2 = temp2.getNext_link();
						}
						if (itemToAdd.getItem().getIndex() + 1 == temp2.getItem().getIndex())
						{
							temp2.setNext_link(itemToAdd);
						}
						else
						{
							add_item(tempcategory, itemToAdd.getItem());
						}
					}
				}
				temp = temp.getRight_link();
			}
		}
		System.out.println("eklendi");
	}
}

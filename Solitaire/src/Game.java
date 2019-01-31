import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class Game
{
	enigma.console.Console cn = Enigma.getConsole();
	
	Multi_Linked_List m = new Multi_Linked_List();
	Scanner sc = new Scanner(System.in);
	Stack oc = new Stack(13); // define OC stack
	Stack os = new Stack(13); // define OS stack
	Stack oh = new Stack(13); // define OD stack
	Stack od = new Stack(13); // define OH stack
	TextAttributes color1 = new TextAttributes(Color.red, Color.white); // Define color1 for heart and diamond
	TextAttributes color2 = new TextAttributes(Color.black, Color.white); // Define color2 for spade and club
	TextAttributes color3 = new TextAttributes(Color.red); // for FROM, TO and START words
	Circular_Queue st = new Circular_Queue(24);
	Random rnd = new Random();
	int scor = 0;
	
	// Printing the scor list on the screen
	public void print_scor_list () throws IOException
	{
		Double_Linked_List d = new Double_Linked_List();
		Player p = new Player();
		p.scor_list(d);
	}
	
	// Creating ST circular queue by using remaining 24 cards
	public Circular_Queue create_circular_queue ( Circular_Queue st)
	{
		int number = rnd.nextInt(23); // For remaining 24 cards
		Single_Linked_List s = new Single_Linked_List(); // create an object of the single linked list
		s = s.deck(); // send the object of the sll to deck method to fill it
		s.shuffle(s); // send the object of the sll to shuffle method to mix it
		for (int i = 1; i <= 24; i++) // For remaining 24 cards
		{
			Cards c = new Cards();
			SLL_Node new_node = new SLL_Node(s.delete_for_shuffle(number).getData());
			c.setCard_suit(new_node.getData().getCard_suit()); // set cards suit to cs object
			c.setCard_number(new_node.getData().getCard_number()); // set cards number to cs object
			st.enqueue(c); // Add c to ST circular queue
		}
		return st; // get st to use it in the "SIMULATION" method
	}
	// Method for printing the top element of the ST circular queue on the screen
	public void print_circular_queue()
	{
		if ((((Cards) st.peek()).getCard_suit()) == "\u2665" || ((Cards) st.peek()).getCard_suit() == "\u2666") // heart or diamond
		{
			cn.getTextWindow().setCursorPosition(32, 4);
			cn.getTextWindow().output(((Cards) st.peek()).getCard_suit(), color1);
			//***
			cn.getTextWindow().setCursorPosition(33, 4);
			cn.getTextWindow().output(((Cards) st.peek()).getCard_number() + " ", color1);
		}
		else if (((Cards) st.peek()).getCard_suit() == "\u2663" || ((Cards) st.peek()).getCard_suit() == "\u2660") // spade or club
		{
			cn.getTextWindow().setCursorPosition(32, 4);
			cn.getTextWindow().output(((Cards) st.peek()).getCard_suit(), color2);
			//***
			cn.getTextWindow().setCursorPosition(33, 4);
			cn.getTextWindow().output(((Cards) st.peek()).getCard_number()+ " ", color2);
		}
		scor = scor + 5;
		cn.getTextWindow().setCursorPosition(85, 0);
		System.out.println(scor);
	}
	
	// Method for printing OC stack
	public void print_OC ()
	{
		if (((Cards) oc.peek()).getCard_suit() == "\u2665" || ((Cards) oc.peek()).getCard_suit() == "\u2666") // heart or diamond
		{
			cn.getTextWindow().setCursorPosition(77, 4);
			cn.getTextWindow().output(((Cards) oc.peek()).getCard_suit(), color1);
			//*****
			cn.getTextWindow().setCursorPosition(78, 4);
			cn.getTextWindow().output(((Cards) oc.peek()).getCard_number() + " ", color1);
		}
		else if (((Cards) oc.peek()).getCard_suit() == "\u2663" || ((Cards) oc.peek()).getCard_suit() == "\u2660") // spade or club
		{
			cn.getTextWindow().setCursorPosition(77, 4);
			cn.getTextWindow().output(((Cards) oc.peek()).getCard_suit(), color2);
			//*****
			cn.getTextWindow().setCursorPosition(78, 4);
			cn.getTextWindow().output(((Cards) oc.peek()).getCard_number() + " ", color2);
		}
		scor = scor + 5;
		cn.getTextWindow().setCursorPosition(85, 0);
		System.out.println(scor);
	}
	
	// Method for printing OS stack
	public void print_OS ()
	{
		if (((Cards) os.peek()).getCard_suit() == "\u2665" || ((Cards) os.peek()).getCard_suit() == "\u2666") // heart or diamond
		{
			cn.getTextWindow().setCursorPosition(92, 4);
			cn.getTextWindow().output(((Cards) os.peek()).getCard_suit(), color1);
			//*****
			cn.getTextWindow().setCursorPosition(93, 4);
			cn.getTextWindow().output(((Cards) os.peek()).getCard_number() + " ", color1);
		}
		else if (((Cards) os.peek()).getCard_suit() == "\u2663" || ((Cards) os.peek()).getCard_suit() == "\u2660") // spade or club
		{
			cn.getTextWindow().setCursorPosition(92, 4);
			cn.getTextWindow().output(((Cards) os.peek()).getCard_suit(), color2);
			//*****
			cn.getTextWindow().setCursorPosition(93, 4);
			cn.getTextWindow().output(((Cards) os.peek()).getCard_number() + " ", color2);
		}
		scor = scor + 5;
		cn.getTextWindow().setCursorPosition(85, 0);
		System.out.println(scor);
	}
	
	// Method for printing OD stack
	public void print_OD ()
	{
		if (((Cards) od.peek()).getCard_suit() == "\u2665" || ((Cards) od.peek()).getCard_suit() == "\u2666") // heart or diamond
		{
			cn.getTextWindow().setCursorPosition(107, 4);
			cn.getTextWindow().output(((Cards) od.peek()).getCard_suit(), color1);
			//*****
			cn.getTextWindow().setCursorPosition(108, 4);
			cn.getTextWindow().output(((Cards) od.peek()).getCard_number() + " ", color1);
		}
		else if (((Cards) od.peek()).getCard_suit() == "\u2663" || ((Cards) od.peek()).getCard_suit() == "\u2660") // spade or club
		{
			cn.getTextWindow().setCursorPosition(107, 4);
			cn.getTextWindow().output(((Cards) od.peek()).getCard_suit(), color2);
			//*****
			cn.getTextWindow().setCursorPosition(108, 4);
			cn.getTextWindow().output(((Cards) od.peek()).getCard_number() + " ", color2);
		}
		scor = scor + 5;
		cn.getTextWindow().setCursorPosition(85, 0);
		System.out.println(scor);
	}
	
	// Method for printing OH stack
	public void print_OH ()
	{
		if (((Cards) oh.peek()).getCard_suit() == "\u2665" || ((Cards) oh.peek()).getCard_suit() == "\u2666") // heart or diamond
		{
			cn.getTextWindow().setCursorPosition(122, 4);
			cn.getTextWindow().output(((Cards) oh.peek()).getCard_suit(), color1);
			//*****
			cn.getTextWindow().setCursorPosition(123, 4);
			cn.getTextWindow().output(((Cards) oh.peek()).getCard_number() + " ", color1);
		}
		else if (((Cards) oh.peek()).getCard_suit() == "\u2663" || ((Cards) oh.peek()).getCard_suit() == "\u2660") // spade or club
		{
			cn.getTextWindow().setCursorPosition(122, 4);
			cn.getTextWindow().output(((Cards) oh.peek()).getCard_suit(), color2);
			//*****
			cn.getTextWindow().setCursorPosition(123, 4);
			cn.getTextWindow().output(((Cards) oh.peek()).getCard_number() + " ", color2);
		}
		scor = scor + 5;
		cn.getTextWindow().setCursorPosition(85, 0);
		System.out.println(scor);
	}
	
	// Simulation method for moving the cards
	public void simulation () throws IOException
	{
		create_circular_queue(st); // call ST circular queue for dequeuing from it
		m.create_all_cards(); // call all cards from multi linked list
		while (true)
		{
			m.display(); // print all cards on the screen
			print_scor_list(); // call scor list
			print_circular_queue(); // call method that prints the  ST circular queue
			//print_OC();
			cn.getTextWindow().setCursorPosition(32, 25);
			cn.getTextWindow().output("FROM:  ", color3);
			String from = sc.next();
			if (from.equalsIgnoreCase("ST")) // if the user wants to remove from ST circular queue
			{
				while (true)
				{
					cn.getTextWindow().setCursorPosition(32, 26);
					cn.getTextWindow().output("TO:    ", color3);
					String to = sc.next();
					if (to.equalsIgnoreCase("OC")) // if user wants to add to OC stack
					{
						if (oc.isEmpty() && st.peek().toString().substring(1, 1).equalsIgnoreCase("A")) // if OC stack is empty and card number of st's first element is "A", then add st's first element to oc
						{
							oc.push(st.dequeue()); // add st's first element to oc
							// Print oc's first element on the screen
							print_OC();
						}
						else if (!oc.isEmpty() && (st.peek().toString().compareToIgnoreCase(oc.peek().toString().substring(1, 1)) > 0) && (st.peek().toString().substring(0, 1).equalsIgnoreCase(oc.peek().toString().substring(0, 1)))) // if oc is NOT empty and card number of st's first element is greater than card number of oc's first element and card suit of st's first eelement is equal to card suit of oc's first element, then add st's first element to oc
						{
							oc.push(st.dequeue()); // add st's first element to oc
							// Print oc's first element on the screen
							print_OC();
						}
						else // if OC stack is NOT empty and the user did not add to it in this order: A, 2, 3, ... 10, J, Q, K; then do NOT add
						{
							cn.getTextWindow().setCursorPosition(65, 6);
							cn.getTextWindow().output("Please add cards to STACKS in this order: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K", color3);
							break;
						}
						
					}
					else if (to.equalsIgnoreCase("OS")) // if user wants to add to OS stack
					{
						if (os.isEmpty() && st.peek().toString().substring(1, 1).equalsIgnoreCase("A")) // if OS stack is empty and card number of st's first element is "A", then add st's first element to os.
						{
							os.push(st.dequeue()); // add st's first element to os
							// Print os's first element on the screen
							print_OS();
						}
						else if (!os.isEmpty() && (st.peek().toString().compareToIgnoreCase(os.peek().toString().substring(1, 1)) > 0) && (st.peek().toString().substring(0, 1).equalsIgnoreCase(os.peek().toString().substring(0, 1)))) // if os is NOT empty and card number of st's first element is greater than card number of os's first element and card suit of st's first eelement is equal to card suit of os's first element, then add st's first element to os
						{
							os.push(st.dequeue()); // add st's first element to os
							// Print os's first element on the screen
							print_OS();
						}
						else // if OS stack is NOT empty and the user did not add to it in this order: A, 2, 3, ... 10, J, Q, K; then do NOT add
						{
							cn.getTextWindow().setCursorPosition(65, 6);
							cn.getTextWindow().output("Please add cards to STACKS in this order: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K", color3);
							break;
						}
						
					}
					else if (to.equalsIgnoreCase("OD")) // if user wants to add to OD stack
					{
						if (od.isEmpty() && st.peek().toString().substring(1, 1).equalsIgnoreCase("A")) // if OD stack is empty and card number of st's first element is "A", then add st's first element to od.
						{
							od.push(st.dequeue()); // add st's first element to od
							// Print od's first element on the screen
							print_OD();
						}
						else if (!od.isEmpty() && (st.peek().toString().compareToIgnoreCase(od.peek().toString().substring(1, 1)) > 0) && (st.peek().toString().substring(0, 1).equalsIgnoreCase(od.peek().toString().substring(0, 1)))) // if od is NOT empty and card number of st's first element is greater than card number of od's first element and card suit of st's first eelement is equal to card suit of od's first element, then add st's first element to od
						{
							od.push(st.dequeue()); // add st's first element to od
							// Print od's first element on the screen
							print_OD();
						}
						else // if OD stack is NOT empty and the user did not add to it in this order: A, 2, 3, ... 10, J, Q, K; then do NOT add
						{
							cn.getTextWindow().setCursorPosition(65, 6);
							cn.getTextWindow().output("Please add cards to STACKS in this order: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K", color3);
							break;
						}
					}
					else if (to.equalsIgnoreCase("OH")) // if user wants to add to OH stack
					{
						if (oh.isEmpty() && st.peek().toString().substring(1, 1).equalsIgnoreCase("A")) // if OH stack is empty and card number of st's first element is "A", then add st's first element to oh.
						{
							oh.push(st.dequeue()); // add st's first element to to oh
							// Print oh's first element on the screen
							print_OH();
						}
						else if (!oh.isEmpty() && (st.peek().toString().compareToIgnoreCase(oh.peek().toString().substring(1, 1)) > 0) && (st.peek().toString().substring(0, 1).equalsIgnoreCase(oh.peek().toString().substring(0, 1)))) // if oh is NOT empty and card number of st's first element is greater than card number of oh's first element and card suit of st's first eelement is equal to card suit of oh's first element, then add st's first element to oh
						{
							oh.push(st.dequeue()); // add st's first element to to oh
							// Print oh's first element on the screen
							print_OH();
						}
						else // if OH stack is NOT empty and the user did not add to it in this order: A, 2, 3, ... 10, J, Q, K; then do NOT add
						{
							cn.getTextWindow().setCursorPosition(65, 6);
							cn.getTextWindow().output("Please add cards to STACKS in this order: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K", color3);
							break;
						}
					}
					// Print the top element of the ST circular queue after some dequeueing operations
					print_circular_queue();
				}
			}
			else // if the user wants to remove from P1, P2, .... P7 piles
			{
				while (true)
				{
					cn.getTextWindow().setCursorPosition(32, 26);
					cn.getTextWindow().output("TO:    ", color3);
					String to = sc.next();
					cn.getTextWindow().setCursorPosition(32, 27);
					cn.getTextWindow().output("START: ", color3);
					String start = sc.next();
					// control that is start is equal to h, d, s or c
					if (start.substring(0, 1).equalsIgnoreCase("h"))
					{
						start = '\u2665' + start.substring(1);
					}
					else if (start.substring(0, 1).equalsIgnoreCase("d"))
					{
						start = '\u2666' + start.substring(1);
					}
					else if (start.substring(0, 1).equalsIgnoreCase("s"))
					{
						start = '\u2660' + start.substring(1);
					}
					else if (start.substring(0, 1).equalsIgnoreCase("c"))
					{
						start = '\u2663' + start.substring(1);
					}
					if (to.equalsIgnoreCase("OC")) // if the user wants to add oc
					{
						if (oc.isEmpty() && start.substring(1, 1).equalsIgnoreCase("A")) // if OC stack is empty and card number of start is "A", then add start to oc
						{
							oc.push(m.deleteItem((Object)start));
							Clear_screen(); // clear the screen
							cn.getTextWindow().setCursorPosition(77, 4);
							cn.getTextWindow().output(start + " ", color1); // print oc after pushing to it
						}
						else if (!oc.isEmpty() && (start.compareToIgnoreCase(oc.peek().toString().substring(1, 1)) > 0) && (start.substring(0, 1).equalsIgnoreCase(oc.peek().toString().substring(0, 1)))) // if oc is NOT empty and card number start is greater than card number of oc's first element and card suit start is equal to card suit of oc's first element, then add start to oc
						{
							oc.push(m.deleteItem((Object)start));
							Clear_screen(); // clear the screen
							cn.getTextWindow().setCursorPosition(77, 4);
							cn.getTextWindow().output(start + " ", color1); // print oc after pushing to it
						}
						else // if OC stack is NOT empty and the user did not add to it in this order: A, 2, 3, ... 10, J, Q, K; then do NOT add
						{
							cn.getTextWindow().setCursorPosition(65, 6);
							cn.getTextWindow().output("Please add cards to STACKS in this order: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K", color3);
							break;
						}
					}
					else if (to.equalsIgnoreCase("OS")) // if the user wants to add os
					{
						if (os.isEmpty() && start.substring(1, 1).equalsIgnoreCase("A")) // if OS stack is empty and card number of start is "A", then add start to os
						{
							os.push(m.deleteItem((Object)start));
							Clear_screen(); // clear the screen
							cn.getTextWindow().setCursorPosition(77, 4);
							cn.getTextWindow().output(start + " ", color1); // print os after pushing to it
						}
						else if (!os.isEmpty() && (start.compareToIgnoreCase(os.peek().toString().substring(1, 1)) > 0) && (start.substring(0, 1).equalsIgnoreCase(os.peek().toString().substring(0, 1)))) // if os is NOT empty and card number start is greater than card number of os's first element and card suit start is equal to card suit of os's first element, then add start to os
						{
							os.push(m.deleteItem((Object)start));
							Clear_screen(); // clear the screen
							cn.getTextWindow().setCursorPosition(77, 4);
							cn.getTextWindow().output(start + " ", color1); // print os after pushing to it
						}
						else // if OS stack is NOT empty and the user did not add to it in this order: A, 2, 3, ... 10, J, Q, K; then do NOT add
						{
							cn.getTextWindow().setCursorPosition(65, 6);
							cn.getTextWindow().output("Please add cards to STACKS in this order: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K", color3);
							break;
						}
					}
					else if (to.equalsIgnoreCase("OD")) // if the user wants to add od
					{
						if (od.isEmpty() && start.substring(1, 1).equalsIgnoreCase("A")) // if OD stack is empty and card number of start is "A", then add start to od
						{
							od.push(m.deleteItem((Object)start));
							Clear_screen(); // clear the screen
							cn.getTextWindow().setCursorPosition(77, 4);
							cn.getTextWindow().output(start + " ", color1); // print od after pushing to it
						}
						else if (!od.isEmpty() && (start.compareToIgnoreCase(od.peek().toString().substring(1, 1)) > 0) && (start.substring(0, 1).equalsIgnoreCase(od.peek().toString().substring(0, 1)))) // if od is NOT empty and card number start is greater than card number of od's first element and card suit start is equal to card suit of od's first element, then add start to od
						{
							od.push(m.deleteItem((Object)start));
							Clear_screen(); // clear the screen
							cn.getTextWindow().setCursorPosition(77, 4);
							cn.getTextWindow().output(start + " ", color1); // print od after pushing to it
						}
						else // if OD stack is NOT empty and the user did not add to it in this order: A, 2, 3, ... 10, J, Q, K; then do NOT add
						{
							cn.getTextWindow().setCursorPosition(65, 6);
							cn.getTextWindow().output("Please add cards to STACKS in this order: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K", color3);
							break;
						}
					}
					else if (to.equalsIgnoreCase("OH")) // if the user wants to add oh
					{
						if (oh.isEmpty() && start.substring(1, 1).equalsIgnoreCase("A")) // if OH stack is empty and card number of start is "A", then add start to oh
						{
							oh.push(m.deleteItem((Object)start));
							Clear_screen(); // clear the screen
							cn.getTextWindow().setCursorPosition(77, 4);
							cn.getTextWindow().output(start + " ", color1); // print oh after pushing to it
						}
						else if (!oh.isEmpty() && (start.compareToIgnoreCase(oh.peek().toString().substring(1, 1)) > 0) && (start.substring(0, 1).equalsIgnoreCase(oh.peek().toString().substring(0, 1)))) // if oh is NOT empty and card number start is greater than card number of oh's first element and card suit start is equal to card suit of oh's first element, then add start to oh
						{
							oh.push(m.deleteItem((Object)start));
							Clear_screen(); // clear the screen
							cn.getTextWindow().setCursorPosition(77, 4);
							cn.getTextWindow().output(start + " ", color1); // print oh after pushing to it
						}
						else // if OH stack is NOT empty and the user did not add to it in this order: A, 2, 3, ... 10, J, Q, K; then do NOT add
						{
							cn.getTextWindow().setCursorPosition(65, 6);
							cn.getTextWindow().output("Please add cards to STACKS in this order: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K", color3);
							break;
						}
					}
					else // if the user wants to add to P1, P2, ... P7 piles
					{
						// traverse tle piles to find available pile
						for (int i = 1; i <=7; i++)
						{
							if (from.equalsIgnoreCase("P" + i)) // if the pile that user wants to delete from it has been found
							{
								m.addItemForMove(to, m.deleteItem(start));
								Clear_screen();
							}
						}
						break;
					}
				}
			}
		}
	}
	
	// Defining a method to clear the screen
	public void Clear_screen()
	{
		cn.getTextWindow().setCursorPosition(0, 0);
		for (int i = 0; i < 170; i++)
		{
			for (int j = 0; j < 30; j++)
			{
				cn.getTextWindow().setCursorPosition(i, j);
				cn.getTextWindow().output(" ");
			}
		}
	}
	
}

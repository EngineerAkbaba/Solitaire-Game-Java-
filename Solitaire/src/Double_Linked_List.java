import java.awt.Color;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class Double_Linked_List
{
	enigma.console.Console cn = Enigma.getConsole();
	
	// Difining head and tail for the double linked list
	DLL_Node head;
	DLL_Node tail;
	
	// Adding element in increasing order
	public void add_increasing_order (Player dataToAdd)
	{
		if (head == null && tail == null) // if the list is empty
		{
			DLL_Node newnode = new DLL_Node(dataToAdd);
			head = newnode;
			tail = newnode;
		}
		else // if the list is NOT empty
		{
			DLL_Node newnode = new DLL_Node(dataToAdd);
			if (dataToAdd.getScore() < head.getData().getScore()) // add before head
			{
				newnode.setNext_link(head);
				head.setPrev_link(newnode);
				head = newnode;
			}
			else
			{
				DLL_Node temp = head;
				while (temp.getNext_link() != null && dataToAdd.getScore() > temp.getNext_link().getData().getScore())
				{
					temp = temp.getNext_link();
				}
				newnode.setPrev_link(temp);
				newnode.setNext_link(temp.getNext_link());
				if (temp.getNext_link() != null) // add between nodes
				{
					temp.getNext_link().setPrev_link(newnode);
				}
				else // add to the end of the nodes
				{
					tail = newnode;
				}
				temp.setNext_link(newnode);
			}
		}
	}
	
	// Display from head forward to tail
	public void disaplayFromHead ()
	{
		TextAttributes player_color = new TextAttributes(Color.red);
		if (head == null && tail == null) // if there is no any node in the list
		{
			System.out.println("The linked list is empty");
		}
		else
		{
			DLL_Node temp = head;
			while (temp != null) // traverse the the list from head
			{
				cn.getTextWindow().output(temp.getData().getName() + " " + temp.getData().getSurname() + " " + temp.getData().getScore(), player_color);
				System.out.println();
				temp = temp.getNext_link();
			}
		}
	}
	
	// Display from tail forward to head
	public void displayFromTail ()
	{
		TextAttributes player_color = new TextAttributes(Color.red);
		if (head == null && tail == null) // if there is no any node in the list
		{
			System.out.println("The linked lis is empty");
		}
		else
		{
			DLL_Node temp = tail;
			while (temp != null) // traverse the the list from tail
			{
				cn.getTextWindow().output(temp.getData().getName() + " " + temp.getData().getSurname() + " " + temp.getData().getScore(), player_color);
				System.out.println();
				temp = temp.getPrev_link();
			}
		}
	}
	
	// Counting the number of nodes
	public int count ()
	{
		int count = 0;
		if (head == null && tail == null) // if there is no any node in the list
		{
			System.out.println("The linked list is empty");
		}
		else
		{
			DLL_Node temp = head;
			while (temp != null) // if there exist nodes in the list
			{
				count++;
				temp = temp.getNext_link();
			}
		}
		return count;
	}
	
	// Deleting an element
	public void delete (Object dataToDel)
	{
		if (head == null && tail == null) // if there is no any node in the list
		{
			System.out.println("The linked lis is empty");
		}
		else
		{
			DLL_Node ptr = head;
			DLL_Node temp = head;
			while (ptr != null) // if there exist nodes in the list
			{
				if (ptr.getData().equals(dataToDel))
				{
					temp.setNext_link(ptr.getNext_link());
					temp.setPrev_link(ptr.getPrev_link());
					break;
				}
				else
				{
					temp = ptr;
					ptr = ptr.getNext_link();
				}
			}
		}
	}
	
	// Search for an item
	public boolean search (Object item)
	{
		boolean flag = false;
		if (head == null && tail == null) // if there is no any node in the list
		{
			System.out.println("The Linked List is Empty");
		}
		else
		{
			DLL_Node temp = head;
			while (temp != null)
			{
				if (item.equals(temp.getData())) // if the data that we want to find has been found
				{
					flag = true;
					break;
				}
				else // if has not been found, then traverse the list to find it
				{
					temp = temp.getNext_link();
					flag = false;
				}
			}
			if (flag == false)
			{
				System.out.println("The item you looked for has not been not found");
			}
		}
		return flag;
	}
	
}

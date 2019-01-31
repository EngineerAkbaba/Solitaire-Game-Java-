
public class Stack 
{
	// Fields
	private int top;
	private Object[] elements;
	private int capacity;
	
	// Constructor with parameter
	Stack (int capacity)
	{
		this.capacity = capacity;
		elements = new Object[capacity];
		top = -1;
	}
	
	// Get-set methods for capacity variable
	public int getCapacity()
	{
		return capacity;
	}
	
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	
	// Control is it empty or not
	boolean isEmpty()
	{
		if (top == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Control is it full or not
	boolean isFull()
	{
		if (top + 1 == elements.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Compute the size of the stack
	int size()
	{
		return top + 1;
	}
	
	// Adding a new element
	public void push(Object data)
	{
		if (isFull()) // if the stack is full, then do NOT add
		{
			System.out.println("Stack overflow.");
		}
		else
		{
			top++;
			elements[top] = data;
		}
	}
	
	// Deleting the top element of the stack
	public Object pop()
	{
		if(isEmpty()) // if the stack if empty, then we can NOT delete
		{
			System.out.println("Stack is empty.");
			return null;
		}
		else
		{
			Object retData = elements[top];
			top--;
			return retData;
		}	
	}
	
	// Displaying the top element of the stack WITHOUT DELETING IT
	public Object peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty.");
			return null;
		}
		else
		{
			return elements[top];
		}
	}
}


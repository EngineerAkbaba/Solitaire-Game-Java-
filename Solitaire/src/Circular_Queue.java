public class Circular_Queue
{
	// Fields
	private int rear;
	private int front;
	public Object[] elements;
	
	// Constructor with parameter
	Circular_Queue (int capacity)
	{
	 elements = new Object[capacity];
	 rear=-1;
	 front=0;
	}
	
	// Adding new element
	void enqueue(Object data)
	{
		if(isFull())
		{
			System.out.println("Queue is overflow");
		}
		else
		{
			rear = (rear + 1) % elements.length;
			elements[rear]=data;
		}
	 }
	
	// Deleting element
	 Object dequeue()
	 {
		if(isEmpty())
		{
			System.out.println("Queue is Empty");
			return null;
		}
		else
		{
			Object retdata = elements[front];
			elements[front]=null;
			front = (front + 1) % elements.length;
			return retdata;
		}
	 }
	 
	 // Printing the first element of the queue on the screen
	 Object peek()
	 {
		 if(isEmpty())
		 {
			 System.out.println("Queue is Empty");
			 return null;
		 }
		 else
		 {
			return elements[front];
		 }
	 }
	 
	 // Checking whether the queue is empty or not
	 boolean isEmpty()
	 {
		 return elements[front] == null;
	 }
	 
	 // Checking whether the queue is full or not
	 boolean isFull()
	 {
		 return front == (rear + 1) % elements.length && elements[front] != null && elements[rear] != null;
	 }
	 
	 // The size of the queue
	 int size()
	 {
		 return rear - front + 1;
	 }
	
}
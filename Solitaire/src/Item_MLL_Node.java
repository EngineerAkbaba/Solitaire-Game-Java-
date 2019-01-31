
public class Item_MLL_Node
{
	// Fields
	private Cards item;
	private Item_MLL_Node next_link;
	
	// Constructor that take a parameter int type CARDS
	public Item_MLL_Node (Cards s)
	{
		item = s;
		next_link = null;
	}
	
	// Get-set methods
	public Cards getItem()
	{
		return item;
	}
	
	public void setItem(Cards item)
	{
		this.item = item;
	}
	
	public Item_MLL_Node getNext_link()
	{
		return next_link;
	}
	
	public void setNext_link(Item_MLL_Node next_link)
	{
		this.next_link = next_link;
	}
	
}



public class DLL_Node
{
	// Fields
	public Player data;
	public DLL_Node next_link;
	public DLL_Node prev_link;
	
	// Constructor wit parameter
	public DLL_Node (Player dataToAdd)
	{
		data = dataToAdd;
		next_link = null;
		prev_link = null;
	}
	
	// Get-Set methods
	public Player getData()
	{
		return  data;
	}
	
	public void setData(Player data)
	{
		this.data = data;
	}
	
	public DLL_Node getNext_link()
	{
		return next_link;
	}
	
	public void setNext_link(DLL_Node next_link)
	{
		this.next_link = next_link;
	}
	
	public DLL_Node getPrev_link()
	{
		return prev_link;
	}
	
	public void setPrev_link(DLL_Node prev_link)
	{
		this.prev_link = prev_link;
	}
	
}
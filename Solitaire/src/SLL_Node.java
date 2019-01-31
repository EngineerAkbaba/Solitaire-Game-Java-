
public class SLL_Node
{
	// Fields
	Cards data;
	SLL_Node link;
	
	//Constructor that take a parameter in type CARDS
	public SLL_Node (Cards dataToAdd)
	{
		data = dataToAdd;
		link = null;
	}
	
	// Get_set
	public Cards getData()
	{
		return data;
	}
	
	public void setData(Cards data)
	{
		this.data = data;
	}
	
	public SLL_Node getLink()
	{
		return link;
	}
	
	public void setLink(SLL_Node link)
	{
		this.link = link;
	}
	
}

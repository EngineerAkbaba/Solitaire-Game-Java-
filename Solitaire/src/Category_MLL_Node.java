
public class Category_MLL_Node
{
	// Fields
	private Object category;
	private Category_MLL_Node right_link;
	private Item_MLL_Node down_link;
	
	// Constructor with parameter
	public Category_MLL_Node (Object dataToAdd)
	{
		category = dataToAdd;
		right_link = null;
		down_link = null;
	}
	
	// Get-set methods
	public Object getCategory()
	{
		return category;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public Category_MLL_Node getRight_link()
	{
		return right_link;
	}
	
	public void setRight_link(Category_MLL_Node right_link)
	{
		this.right_link = right_link;
	}
	
	public Item_MLL_Node getDown_link()
	{
		return down_link;
	}
	
	public void setDown_link(Item_MLL_Node down_link)
	{
		this.down_link = down_link;
	}
	
}
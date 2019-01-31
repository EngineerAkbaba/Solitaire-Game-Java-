
public class Cards
{
	// Fields
	private String card_suit;
	private String card_number;
	private int index;
	
	// Constructor without parameter
	public Cards ()
	{
		card_suit = " ";
		card_number = null;
		index = 0;
	}
	
	// Get-set methods
	public String getCard_suit()
	{
		return card_suit;
	}
	
	public void setCard_suit(String card_suit)
	{
		this.card_suit = card_suit;
	}
	
	public String getCard_number()
	{
		return card_number;
	}
	
	public void setCard_number(String card_number)
	{
		this.card_number = card_number;
	}

	public int getIndex()
	{
		return index;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}
	
}


public class Card {
	private int rank;//represents the rank of a card
	private int suit;//represents the suit of a card
	private int value;//represents the value of a card
	private static String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
	
	//empty constructor
	Card(){
	    }
	//constructor with two parameters
	Card(int suit, int values)
	{
	    this.rank=values;
	    this.suit=suit;
	}
	/*
	 * Returns the string version of a card.
	 */
	public String toString()
	{
	    return ranks[rank]+" of "+suits[suit];
	}
	/*
	 * Sets the value of a card.
	 */
	public int getRank()
	{
	    return rank;
	}
	/*
	 * Gets the suit of a card.
	 */
	public int getSuit()
	{
	    return suit;
	}
	/*
	 * Gets the value of a card.
	 */
	public int getValue()
	{
	    if(rank>=10)
	    {
	        value=10;
	    }
	    else if(rank==1)
	    {
	        value=11;
	    }
	    else
	    {
	        value=rank;
	    }
	    return value;
	}
	/*
	 * Sets the value of a card.
	 */
	public void setValue(int set)
	{
	    value = set;
	}
	
}

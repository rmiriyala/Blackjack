
public class Card {
	private String rank; //represents the rank of a card
	private String suit; //represents the suit of a card
	private int value; //represents the value of a card
	public static String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	public static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
	
	/**
	 * Empty constructor.
	 */
	public Card(){
		
	}
	
	/**
	 * Two parameter constructor for Card class.
	 * @param suit - the suit of the card; can be "Clubs","Diamonds","Hearts", or "Spades".
	 * @param values - the value of the card; can range 1-10.
	 */
	public Card(String rank, String suit)
	{
	    this.rank = rank.toUpperCase();
	    for (int i = 0; i < ranks.length; i++) {
	    	if (rank.equalsIgnoreCase(ranks[i])) {
	    		this.value = getValue(i);
	    	}
	    }
	    
	    this.suit = suit.toUpperCase();
	}
	
	/**
	 * Overrides Default Object toString method
	 */
	public String toString()
	{
	    return this.rank + " of " + this.suit;
	}
	
	/**
	 * Gets the rank of the card;
	 * @return the rank of the card.
	 */
	public String getRank()
	{
	    return this.rank;
	}
	
	/**
	 * Gets the suit of the card.
	 * @return the suit of the card.
	 */
	public String getSuit()
	{
	    return this.suit;
	}
	
	/**
	 * Gets the value of the card: 2 - 11;
	 * @return the real blackjack value of the card.
	 */
	public int getValue(final int i)
	{
	    if (i >= 10) {
	    	this.value = 10; //face cards are all 10
	    } else if (i == 1) {
	        this.value = 11; //ace starts at 11 
	    } else {
	        this.value = i;
	    }
	    
	    return this.value;
	}
	
	/**
	 * Sets the value of the card.
	 * @param set - the value to set the card to.
	 */
	public void setValue(int value)
	{
	    this.value = value;
	}
	
}

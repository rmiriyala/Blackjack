/**
 * Card class for each individual card object.
 * 
 * @author Vivek, Rahul
 *
 */
public class Card {
	private String rank; //represents the rank of a card
	private String suit; //represents the suit of a card
	private int value; //represents the value of a card
	public static String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	public static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

	/**
	 * ace holds the value of 11
	 */
	public static final int ace = 11;
	
	/**
	 * faceCard holds the value of 10
	 */
	public static final int faceCard = 10;
	
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
				this.value = getRealValue(i);
			}
		}

		this.suit = suit.toUpperCase();
	}

	/**
	 * Copy constructor of another card.
	 * @param  - card the card to duplicate
	 */
	public Card(Card card) {
		this.rank = card.rank;
		this.suit = card.suit;
		this.value = card.value;
	}

	/**
	 * Overrides Default Object toString method
	 */
	public String toString()
	{
		if (this.equals(null)) {
			return "null";
		}

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
	 * Helper function gets the real value of the card: 2 - 11;
	 * @return the real blackjack value of the card.
	 */
	public int getRealValue(final int i)
	{
		int realValue = 0;
		if (i + 1 >= faceCard) {
			realValue = faceCard; //face cards are all 10
		} else if (i == 0) {
			realValue = ace; //ace starts at 11 
		} else {
			realValue = i + 1;
		}

		return realValue;
	}

	/**
	 * Getter method for card value.
	 * @return the blackjack value of the card.
	 */
	public int getValue() {
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

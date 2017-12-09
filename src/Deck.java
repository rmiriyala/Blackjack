import java.util.*;

public class Deck {
	private Card[] deck = new Card[52];
	
	/**
	 * Creates a deck of 52 new cards, one of each suit and value.
	 */
	public Deck() {
		for (int i = 0; i < Card.ranks.length; i++) {
			for (int j = 0; j < Card.suits.length; j++) {
				deck[i+j] = new Card(Card.ranks[i], Card.suits[j]);
			}
		}
	}
	
	/**
	 * Will shuffle according to the Fisher-Yates shuffle function.
	 */
	public void shuffle() {
		int index;
		Card temp = new Card();
	    Random random = new Random();
	    
	    for (int i = this.deck.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = this.deck[index];
	        this.deck[index] = this.deck[i];
	        this.deck[i] = temp;
	    }
	}
}

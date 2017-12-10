import java.util.*;

public class Deck {
	public Card[] deck = new Card[52];
	
	/**
	 * Creates a deck of 52 new cards, one of each suit and value.
	 */
	public Deck() {
		int count = 0;
		for (int i = 0; i < Card.ranks.length; i++) {
			for (int j = 0; j < Card.suits.length; j++) {
				deck[count] = new Card(Card.ranks[i], Card.suits[j]);
				count++;
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
	
	/**
	 * Will deal a card to whatever player requests the card.
	 * @return the first card on the pile.
	 */
	public Card dealCard() {
		if (this.deck.length == 0) {
			return null;
		}
		
		//copies the first element of the array, this Card will be returned
		Card first = this.deck[0];
		//creates a new deck without the first Card that was returned
		Card[] temp = new Card[this.deck.length - 1];
		
		for (int i = 0; i < this.deck.length - 1; i++) {
			temp[i] = this.deck[i + 1];
		}
		
		this.deck = temp;
		return first;
	}
	
	public void print() {
		for (int i = 0; i < this.deck.length; i++) {
			System.out.println(this.deck[i].toString());
		}
	}
}

/**
 * Implement dealer, based on class Player.
 * 
 * The dealer class must also implement standard Blackjack dealer logic, and will never
 * run out of money, since they represent the casino.
 * 
 * @author Vivek
 *
 */
public class Dealer {
	public int cardsValue;
	public int aceCount;
	public int cardCount = 0;
	public boolean limitReached = false;
	public Card[] hand = new Card[12];
	
	/**
	 * Empty constructor, never used.
	 */
	public Dealer() {
		
	}
	
	/**
	 * Creates a dealer, given a certain deck
	 * @param deck - the deck of 52 cards to be used.
	 */
	public void dealCard(Deck deck) {
		Card newCard = deck.dealCard();
		if (newCard.getRank().equalsIgnoreCase("Ace")) {
			this.aceCount++;
		}
		this.hand[this.cardCount] = new Card(newCard);
		this.cardCount++;
		this.cardsValue += newCard.getValue();
		if (cardCount == 1) {
			this.printHand();
		}
	}
	
	/**
	 * Function to check whether or not the dealer has truly busted.
	 * @return - true if the dealer has busted, false otherwise.
	 */
	public boolean isBusted() {
		if (this.cardsValue > 21 && this.aceCount == 0) {
			return true;
		} else if (this.cardsValue > 21 && this.aceCount > 0) {
			this.aceCount--;
			this.cardsValue -= 10;
		}
		return false;
	}
	
	/**
	 * Represents the dealer logic and is called by the Game class.
	 * @param deck - the deck that will be used to deal the dealer cards.
	 */
	public void action(Deck deck) {
		while(!isBusted()) {
			if(cardsValue<17) {
				dealCard(deck);			
			} else {
				break;
			}
		}
		this.limitReached = true;
	}
	
	/**
	 * Utility function to print the dealer's hand.
	 */
	public void printHand() {
		System.out.print("Dealer: ");
		for (int i = 0; i < this.cardCount - 1; i++) {
			System.out.print(this.hand[i].toString() + ", ");
		}
		System.out.println(this.hand[this.cardCount - 1].toString() + ".");		
	}
}

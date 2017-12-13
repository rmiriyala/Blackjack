
/**
 * Player class to house the cash and cards the player may have.
 * Also created utility functions, such as printHand().
 * 
 * @author Rahul
 *
 */
public class Player {
	private static final int DEFAULT_CASH = 1000;

	public int money;
	public int cardCount = 0;
	public int cardsValue;
	public int aceCount;
	public Card[] hand = new Card[12];
	/**
	 * blackjack holds the value of 21
	 */
	public static final int blackjack = 21;


	/**
	 * Empty player constructor, with default cash given to the new player.
	 */
	public Player() {
		this.money = DEFAULT_CASH;
	}

	/**
	 * dealCard is a void method which deals the cards to the player and dealer
	 * @param deck is the parameter which deals the cards of the deck.
	 */
	public void dealCard(Deck deck) {
		Card newCard = deck.dealCard();
		if (newCard.getRank().equalsIgnoreCase("Ace")) {
			this.aceCount++;
		}
		this.hand[this.cardCount] = new Card(newCard);
		this.cardCount++;
		this.cardsValue += newCard.getValue();
		this.printHand();
	}

	/**
	 * checkBlackjack method checks if the player got a natural blackjack.
	 */
	public boolean checkBlackjack() {
		if (this.cardsValue == blackjack) {
			return true;
		}
		return false;
	}

	/**
	 * isBusted method checks if the dealer or player and returns boolean.
	 */
	public boolean isBusted() {
		if (this.cardsValue > blackjack && this.aceCount == 0) {
			return true;
		} else if (this.cardsValue > blackjack && this.aceCount > 0) {
			this.aceCount--;
			this.cardsValue -= 10;
		}
		return false;
	}

	/**
	 * printHand will print card value that is dealt to the player or dealer.
	 */
	public void printHand() {
		if (this.cardCount > 1) {
			System.out.print("Your hand: ");
		}
		for (int i = 0; i < this.cardCount - 1; i++) {
			System.out.print(this.hand[i].toString() + ", ");
		}
		if (this.cardCount > 1) {
			System.out.println(this.hand[this.cardCount - 1].toString() + ".");
		}
	}
}

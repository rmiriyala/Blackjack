
public class Player {
	private static final int DEFAULT_CASH = 1000;
	
	public int money;
	public int cardCount = 0;
	public int cardsValue;
	public int aceCount;
	public Card[] hand = new Card[12];
	
	/**
	 * Empty player constructor, with default cash given to the new player.
	 */
	public Player() {
		this.money = DEFAULT_CASH;
	}
	
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
	
	public boolean checkBlackjack() {
		if (this.cardsValue == 21) {
			return true;
		}
		return false;
	}
	
	public boolean isBusted() {
		if (this.cardsValue > 21 && this.aceCount == 0) {
			return true;
		} else if (this.cardsValue > 21 && this.aceCount > 0) {
			this.aceCount--;
			this.cardsValue -= 10;
		}
		return false;
	}
	
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

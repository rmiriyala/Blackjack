
public class Dealer {
	public int cardsValue;
	public int aceCount;
	public int cardCount = 0;
	public Card[] hand = new Card[12];
	
	
	public Dealer() {
		
	}
	
	public void dealCard(Deck deck) {
		Card newCard = deck.dealCard();
		if (newCard.getRank().equalsIgnoreCase("Ace")) {
			this.aceCount++;
		}
		this.hand[this.cardCount] = new Card(newCard);
		this.cardCount++;
		this.cardsValue += newCard.getValue();
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
	
	public void action(Deck deck) {
		while(!isBusted()) {
		if(cardsValue<17) {
			dealCard(deck);			
		}
		else { 
			System.out.println("Dealer stays");
			break;
		}
	}
	}
	
}

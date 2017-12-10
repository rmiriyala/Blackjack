import java.util.*;

public class Game {



	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Player player = new Player();
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		int bet = 0;
		
		System.out.println("How much do you want to bet?");
		Scanner sc = new Scanner(System.in);
		int betAmount = sc.nextInt();
		
		boolean betIsValid = false;
		while (betIsValid == false) { 
			if (betAmount <= 0) {
				System.out.println("Please enter a bet value more than $0");
				System.out.println("How much do you want to bet?");
				sc = new Scanner(System.in);
			} else if(betAmount > player.money) {
				System.out.println("Please enter a bet value less than your total money");
				System.out.println("How much do you want to bet?");
				sc = new Scanner(System.in);
			} else {
				bet = betAmount;
				betIsValid = true;
				break;
			}
			betAmount = sc.nextInt();
		}

		player.dealCard(deck);
		dealer.dealCard(deck);
		player.dealCard(deck);

		if (player.isBusted() == true) {
			System.out.println("GAME IS BROKEN");
			resetGame(player, dealer);

		}
		System.out.println("Showing: " + player.cardsValue);
		System.out.println("Would you like to HIT or STAY?");
		
		sc = new Scanner(System.in);
		String userInput = sc.next().toLowerCase();
		
		while(userInput.equals("stay") == false) {
			if (userInput.equals("hit")) {
				player.dealCard(deck);
				if (player.isBusted() == true) {
					break;
				}
			}
			System.out.println("Showing: " + player.cardsValue);
			System.out.println("Would you like to HIT or STAY?");
			sc = new Scanner(System.in);
			userInput = sc.next().toLowerCase();
		}
		sc.close();
		
		
	}
	
	
	public static void resetGame(Player player, Dealer dealer){
		player.cardCount = 0;
		dealer.cardCount = 0;
		Deck deck = new Deck();
		deck.shuffle();
		
		player.cardCount = 0;
		dealer.cardCount = 0;
		player.aceCount = 0;
		dealer.aceCount = 0;
		player.hand = new Card[12];
		dealer.hand = new Card[12];
	}
	
	public static void winner(Player player, Dealer dealer, int bet) {
		if (player.isBusted()) {
			player.money -= bet;
			resetGame(player, dealer);
		} else if (dealer.isBusted()) {
			player.money += bet;
			resetGame(player, dealer);
		} else {
			if (player.cardsValue > dealer.cardsValue) {
				player.money += bet;
				resetGame(player, dealer);
				} else if (player.cardsValue < dealer.cardsValue) {
					player.money += bet;
					resetGame(player, dealer);
					} else if (player.cardsValue == dealer.cardsValue) {
						resetGame(player, dealer);
					}
			
		}
		
		
	}
}



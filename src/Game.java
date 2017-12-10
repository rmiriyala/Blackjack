import java.util.*;

public class Game {



	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		while (player.money != 0) {
			Deck deck = new Deck();
			deck.shuffle();
			int bet = 0;
			
			System.out.println("You have " + player.money + ". How much do you want to bet?");
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
			
			if (player.checkBlackjack() == true) {
				player.money += 1.5 * bet;
				System.out.println("Blackjack! You WIN!");
				resetGame(player, dealer);
			}

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
			
			while (dealer.limitReached != true) {
				dealer.action(deck);
			}
			
			winner(player, dealer, bet);
		}
		System.out.println("You have $0. YOU SUCK!");
		
	}
	
	
	public static void resetGame(Player player, Dealer dealer){
		player.cardCount = 0;
		dealer.cardCount = 0;
		Deck deck = new Deck();
		deck.shuffle();
		
		player.cardCount = 0;
		dealer.cardCount = 0;
		player.cardsValue = 0;
		dealer.cardsValue = 0;
		player.aceCount = 0;
		dealer.aceCount = 0;
		dealer.limitReached = false;
		player.hand = new Card[12];
		dealer.hand = new Card[12];
	}
	
	public static void winner(Player player, Dealer dealer, int bet) {
		System.out.println("Player is showing " + player.cardsValue);
		if (player.isBusted()) {
			System.out.println("You BUSTED!");
			player.money -= bet;
		} else if (dealer.isBusted()) {
			System.out.println("Dealer is showing " + dealer.cardsValue);
			System.out.println("Dealer busted. You WIN!");
			player.money += bet;
		} else {
			if (player.cardsValue > dealer.cardsValue) {
				System.out.println("Dealer is showing " + dealer.cardsValue);
				System.out.println("You WIN!");
				player.money += bet;
			} else if (player.cardsValue < dealer.cardsValue) {
				System.out.println("Dealer is showing " + dealer.cardsValue);
				System.out.println("You LOST!");
				player.money -= bet;
			} else if (player.cardsValue == dealer.cardsValue) {
				if (player.cardCount < dealer.cardCount) {
					System.out.println("Dealer is showing " + dealer.cardsValue);
					System.out.println("You WIN!");
					player.money += bet;
				} else if (player.cardCount > dealer.cardCount){
					System.out.println("Dealer is showing " + dealer.cardsValue);
					System.out.println("You LOST!");
					player.money -= bet;
				} else {
					System.out.println("Dealer is showing " + dealer.cardsValue);
					System.out.println("It's a tie.");
				}
			}
		}
		System.out.println();
		System.out.println();
		resetGame(player, dealer);
	}
}



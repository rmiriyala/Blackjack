import java.util.*;

public class Game {
	
	

	public static void main(String[] args) {
		Player player = new Player();
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		
		
		System.out.println("How much do you want to bet?");
		Scanner bet = new Scanner(System.in);
		int betAmount = bet.nextInt();
		if(betAmount <= 0) {
					System.out.println("Please enter a bet value more than $0");
					System.out.println("How much do you want to bet?");
					bet = new Scanner(System.in);
		} else if(betAmount > player.money) {
			System.out.println("Please enter a bet value less than your total money");
			System.out.println("How much do you want to bet?");
			bet = new Scanner(System.in);
		}else {
			player.bet = betAmount;
		}
		
		player.dealCard(deck);
		//dealer.dealCard(deck);
		player.dealCard(deck);
		
		if (player.isBusted() == true) {
			System.out.println("GAME IS BROKEN");
		}
		System.out.println("Showing: " + player.cardsValue);
		System.out.println("Would you like to HIT or STAY?");
		
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next().toLowerCase();
		
		while(userInput.equals("stay") == false) {
			
			if (userInput.equals("hit")) {
				player.dealCard(deck);
				if (player.isBusted() == true) {
					//bust(player); //create bust function in THIS CLASS
					resetGame(player, dealer);
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
		player.aceCount = 0;
		dealer.aceCount = 0;
		player.bet = 0;
		player.hand = new Card[12];
		dealer.hand = new Card[12];

		}
	
}
	
	

import java.util.*;

public class Game {

	public static void main(String[] args) {
		Player player = new Player();
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		
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
					break;
				}
			}
			
			System.out.println("Showing: " + player.cardsValue);
			System.out.println("Would you like to HIT or STAY?");
			
			sc = new Scanner(System.in);
			userInput = sc.next().toLowerCase();
		}
		
	}
	
	

}

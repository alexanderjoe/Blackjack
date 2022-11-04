package dev.alexanderdiaz.blackjack;

import dev.alexanderdiaz.blackjack.Cards.Deck;
import dev.alexanderdiaz.blackjack.Players.Dealer;
import dev.alexanderdiaz.blackjack.Players.Player;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean playing = true;
		double playerMoney = 100.0;
		int wins = 0;
		int loses = 0;
		int draws = 0;

		System.out.println("Welcome to blackjack!\n");
		while (playing) {
			Deck deck = new Deck();
			Player p1 = new Player(deck);
			Dealer d1 = new Dealer(deck);
			boolean stand = false;

			System.out.println("\nYou have $" + playerMoney + " to bet.");
			System.out.println("How much would you like to bet?");
			double bet = scanner.nextDouble();
			while (bet > playerMoney) {
				System.out.println("\nYou don't have enough money to bet that much.");
				System.out.println("How much would you like to bet?");
				bet = scanner.nextDouble();
			}
			playerMoney -= bet;
			System.out.printf("%nYou have $%.2f on the line!!%n", bet);
			scanner.nextLine();

			System.out.println("\nHere are the current decks in play:");
			System.out.println("Player's hand: " + p1.getHand().toString() + " (" + p1.getHand().getValue() + ")");
			System.out.println("Dealer's hand: " + d1.hiddenHand());
			System.out.println();
			while (!p1.getHand().isBusted() && !p1.getHand().isWinner() && !stand) {
				System.out.println("\nWould you like to hit or stand? (H or S)");
				char choice = scanner.nextLine().toUpperCase().charAt(0);
				if (choice == 'H') {
					p1.getHand().addCard(deck);
					System.out.println("Hit! Card: " + p1.getHand().getTopCard() + " (" + p1.getHand().getValue() + ")");
				} else {
					stand = true;
				}
			}

			d1.play(deck);

			System.out.println("\n------------------------------------");
			System.out.println("\nPlayer's hand: " + p1.getHand().toString() + " (" + p1.getHand().getValue() + ")");
			System.out.println("Dealer's hand: " + d1.getHand().toString() + " (" + d1.getHand().getValue() + ")");
			System.out.println();
			if (p1.getHand().isBusted() && d1.getHand().isBusted()) {
				System.out.println("Draw! Both you and the dealer busted.");
				System.out.println("You get your money back.");
				playerMoney += bet;
				draws++;
			} else if (p1.getHand().isWinner() && d1.getHand().isWinner()) {
				System.out.println("Draw! Both you and the dealer have 21.");
				System.out.println("You get your money back.");
				playerMoney += bet;
				draws++;
			} else if (p1.getHand().isWinner()) {
				System.out.println("Winner! You have exactly 21!");
				System.out.println("You win $" + (2*bet) + "!");
				playerMoney += bet * 2;
				wins++;
			} else if(d1.getHand().isWinner() && !p1.getHand().isWinner()) {
				System.out.println("Loser! The dealer won.");
				System.out.println("You lose $" + bet + "!");
				loses++;
			} else if (d1.getHand().isBusted()) {
				System.out.println("Winner! The dealer busted!");
				System.out.println("You win $" + (2*bet) + "!");
				playerMoney += bet * 2;
				wins++;
			} else if (p1.getHand().isBusted()) {
				System.out.println("Busted! You went over 21!");
				System.out.println("Loser! The dealer won.");
				System.out.println("You lose $" + bet + "!");
				playerMoney += bet;
				loses++;
			} else {
				System.out.println("Draw! Nobody won.");
				System.out.println("Draw! Both you and the dealer busted.");
				System.out.println("You get your money back.");
				playerMoney += bet;
				draws++;
			}
			System.out.println("\nWould you like to play again? (Y/N)");
			playing = scanner.nextLine().toUpperCase().charAt(0) == 'Y';
		}

		System.out.printf("Wins: %d, Draws: %d, Loses: %d, Money: %.2f", wins, draws, loses, playerMoney);
	}
}

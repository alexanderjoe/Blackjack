package dev.alexanderdiaz.blackjack;

import dev.alexanderdiaz.blackjack.Cards.Deck;
import dev.alexanderdiaz.blackjack.Players.Dealer;
import dev.alexanderdiaz.blackjack.Players.Player;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean playing = true;

		System.out.println("Welcome to blackjack!");
		while (playing) {
			Deck deck = new Deck();
			Player p1 = new Player(deck);
			Dealer d1 = new Dealer(deck);
			boolean stand = false;

			System.out.println("Here are the current decks in play:");
			System.out.println("Player's hand: " + p1.getHand().toString() + " (" + p1.getHand().getValue() + ")");
			System.out.println("Dealer's hand: " + d1.hiddenHand());

			while (!p1.getHand().isBusted() && !p1.getHand().isWinner() && !stand) {
				System.out.println("Would you like to hit or stand? (H or S)");
				char choice = scanner.nextLine().toUpperCase().charAt(0);
				if (choice == 'H') {
					p1.getHand().addCard(deck);
					System.out.println("Hit! Card: " + p1.getHand().getTopCard() + " (" + p1.getHand().getValue() + ")");
				} else {
					stand = true;
				}
			}

			d1.play(deck);

			System.out.println("------------------------------------");
			System.out.println("Player's hand: " + p1.getHand().toString() + " (" + p1.getHand().getValue() + ")");
			System.out.println("Dealer's hand: " + d1.getHand().toString() + " (" + d1.getHand().getValue() + ")");

			if (p1.getHand().isBusted() && d1.getHand().isBusted()) {
				System.out.println("Draw! Both the dealer and you busted.");
			} else if (p1.getHand().isWinner() && d1.getHand().isWinner()) {
				System.out.println("Draw! Both the dealer and you have 21.");
			} else if (p1.getHand().isWinner()) {
				System.out.println("Winner! You got exactly 21!");
			} else if (d1.getHand().isWinner() && !p1.getHand().isWinner()) {
				System.out.println("Loser! The dealer won.");
			} else if (d1.getHand().isBusted()) {
				System.out.println("Winner! The dealer busted!");
			} else if (p1.getHand().isBusted()) {
				System.out.println("Busted! You went over 21!");
			} else {
				System.out.println("Draw! Neither you or the dealer busted or won.");
			}
			System.out.println("Would you like to play again? (Y/N)");
			playing = scanner.nextLine().toUpperCase().charAt(0) == 'Y';
		}
	}
}

package dev.alexanderdiaz.blackjack;

import dev.alexanderdiaz.blackjack.Cards.Card;
import dev.alexanderdiaz.blackjack.Cards.Deck;
import dev.alexanderdiaz.blackjack.Cards.Hand;
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
			System.out.println("Here are the current decks in play:");
			System.out.println("Player's hand: " + p1.getHand().toString() + " (" + p1.getHand().getValue() + ")");
			System.out.println("Dealer's hand: " + d1.hiddenHand());
			playing = false;
		}
	}
}

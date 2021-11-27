package dev.alexanderdiaz.blackjack;

import dev.alexanderdiaz.blackjack.Cards.Card;
import dev.alexanderdiaz.blackjack.Cards.Deck;
import dev.alexanderdiaz.blackjack.Cards.Hand;
import dev.alexanderdiaz.blackjack.Players.Dealer;
import dev.alexanderdiaz.blackjack.Players.Player;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		final char[] cards = new char[]{'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
		final String[] suites = new String[]{"Hearts", "Diamonds", "Spades", "Clubs"};
		final String[] colors = new String[]{"Red", "Black"};
		Scanner scanner = new Scanner(System.in);
		boolean playing = true;

		System.out.println("Welcome to blackjack!");
		while (playing) {
			Deck deck = new Deck();
			Player p1 = new Player(deck);
			Dealer d1 = new Dealer(deck);
			System.out.println(p1.getHand().toString());
			playing = false;
		}
	}
}

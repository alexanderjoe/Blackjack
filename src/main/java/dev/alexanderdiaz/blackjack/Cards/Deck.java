package dev.alexanderdiaz.blackjack.Cards;

import dev.alexanderdiaz.blackjack.Cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<Card>();

	public Deck() {
		buildDeck();
	}

	private void buildDeck() {
		final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

		int cardCode = 1;

		for (String suit : suits) {
			for (int i = 1; i < 14; i++) {
				this.deck.add(new Card(new Face(i), new Suit(suit), cardCode));
				cardCode++;
			}
		}

		Collections.shuffle(this.deck);
	}

	public Card getCard() {
		return this.deck.remove(0);
	}

	public String toString() {
		return deck.toString();
	}
}

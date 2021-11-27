package dev.alexanderdiaz.blackjack.Players;

import dev.alexanderdiaz.blackjack.Cards.Deck;
import dev.alexanderdiaz.blackjack.Cards.Hand;

public class Dealer {
	private Hand hand;

	public Dealer(Deck deck) {
		this.hand = new Hand(deck);
	}

	public Hand getHand() {
		return this.hand;
	}
}

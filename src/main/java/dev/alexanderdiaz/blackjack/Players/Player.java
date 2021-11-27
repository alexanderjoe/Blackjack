package dev.alexanderdiaz.blackjack.Players;

import dev.alexanderdiaz.blackjack.Cards.Deck;
import dev.alexanderdiaz.blackjack.Cards.Hand;

public class Player {
	private Hand hand;

	public Player(Deck deck) {
		this.hand = new Hand(deck);
	}

	public Hand getHand() {
		return this.hand;
	}
}

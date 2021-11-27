package dev.alexanderdiaz.blackjack.Players;

import dev.alexanderdiaz.blackjack.Cards.Deck;
import dev.alexanderdiaz.blackjack.Cards.Hand;

public class Dealer {
	private Hand hand;
	final private int HOLD_AT = 17;

	public Dealer(Deck deck) {
		this.hand = new Hand(deck);
	}

	public Hand getHand() {
		return this.hand;
	}

	public String hiddenHand() {
		return "Deck: [" + this.hand.getCardAt(0).toString() + ", *HIDDEN*]";
	}
}

package dev.alexanderdiaz.blackjack.Cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

	final private List<Card> cardList = new ArrayList<Card>();
	private int numberOfCards = 0;
	private boolean ace = false;

	public Hand(Deck deck) {
		buildDefaultHand(deck);
	}

	private void buildDefaultHand(Deck deck) {
		Card c1 = deck.getCard();
		Card c2 = deck.getCard();
		if (c1.isAce() || c2.isAce()) {
			ace = true;
		}
		this.cardList.add(c1);
		this.cardList.add(c2);
		numberOfCards = 2;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public Card getCardAt(int index) {
		return this.cardList.get(index);
	}

	public void addCard(Card card) {
		this.cardList.add(card);
		numberOfCards++;
	}

	public void addCard(Deck deck) {
		addCard(deck.getCard());
	}

	public Card getTopCard() {
		return getCardAt(numberOfCards - 1);
	}

	public boolean removeCard(Card card) {
		return this.cardList.remove(card);
	}

	public int getValue() {
		int value = 0;
		for (Card card : this.cardList) {
			value += card.getValue();
		}

		if (value > 21 && ace) {
			value -= 10;
		}

		return value;
	}

	public void clear() {
		this.cardList.clear();
	}

	public boolean isBusted() {
		int value = getValue();

		return value > 21;
	}

	public boolean isWinner() {
		return getValue() == 21;
	}

	public String toString() {
		return "Deck: " + Arrays.toString(this.cardList.toArray());
	}
}

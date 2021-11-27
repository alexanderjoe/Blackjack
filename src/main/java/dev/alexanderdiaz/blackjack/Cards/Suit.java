package dev.alexanderdiaz.blackjack.Cards;

public class Suit {
	private String name;

	public Suit(String suit) {
		setSuit(suit);
	}

	public String getSuit() {
		return name;
	}

	public void setSuit(String suit) {
		this.name = suit;
	}
}

package dev.alexanderdiaz.blackjack.Cards;

public class Card {
	private Face face;
	private Suit suit;
	private int code;

	public Card(Face face, Suit suit, int code) {
		this.face = face;
		this.suit = suit;
		this.code = code;
	}

	@Override
	public String toString() {
		return this.face.getName() + " of " + this.suit.getSuit();
	}

	public int getValue() {
		return this.getFace().getValue();
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isAce() {
		return this.face.getName().equals("Ace");
	}
}

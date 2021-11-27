package dev.alexanderdiaz.blackjack.Cards;

public class Face {
	private String name;
	private int value;

	public Face(int face) {
		switch (face) {
			case 1 -> {
				setName("Ace");
				setValue(11);
			}
			case 2 -> {
				setName("Two");
				setValue(2);
			}
			case 3 -> {
				setName("Three");
				setValue(3);
			}
			case 4 -> {
				setName("Four");
				setValue(4);
			}
			case 5 -> {
				setName("Five");
				setValue(5);
			}
			case 6 -> {
				setName("Six");
				setValue(6);
			}
			case 7 -> {
				setName("Seven");
				setValue(7);
			}
			case 8 -> {
				setName("Eight");
				setValue(8);
			}
			case 9 -> {
				setName("Nine");
				setValue(9);
			}
			case 10 -> {
				setName("Ten");
				setValue(10);
			}
			case 11 -> {
				setName("Jack");
				setValue(10);
			}
			case 12 -> {
				setName("Queen");
				setValue(10);
			}
			case 13 -> {
				setName("King");
				setValue(10);
			}
			default -> {
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return getName();
	}
}

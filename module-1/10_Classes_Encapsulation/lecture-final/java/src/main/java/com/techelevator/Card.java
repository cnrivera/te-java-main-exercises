package com.techelevator;

public class Card {

	private final int value;
	private final String suit;
	private boolean faceUp = false;
	private final int serialNumber;
	
	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 13;
	
	public static final String SUIT_HEARTS = "Hearts";
	public static final String SUIT_SPADES = "Spades";
	public static final String SUIT_CLUBS = "Clubs";
	public static final String SUIT_DIAMONDS = "Diamonds";
	
	public static final String[] ALL_SUITS = {SUIT_HEARTS, SUIT_SPADES, SUIT_CLUBS, SUIT_DIAMONDS};
	
	private static final String[] ALL_RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	private static int createdCount = 0;
	
	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
		createdCount++;
		serialNumber = createdCount;
	}
	
	public static int getCreatedCount() {
		return createdCount;
	}
	
	public int getValue() {
		return value;
	}
	

	
	public String getSuit() {
		return suit;
	}
	

	
	public boolean isFaceUp() {
		return faceUp;
	}
	
	public String getRank() {
		return ALL_RANKS[getValue() - 1];
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public void flip() {
		faceUp = !isFaceUp();
	}
	
	public boolean isGreaterThan(Card otherCard) {
		return getValue() > otherCard.getValue();
	}
	
	public boolean isGreaterThan(int otherValue) {
		return getValue() > otherValue;
	}
	
	@Override
	public String toString() {
		String result = "Back of Card";
		
		if (isFaceUp()) {
			result = getRank() + " of " + getSuit();
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Card) {
			Card otherCard = (Card) o;
			result = (getRank().equals(otherCard.getRank()) && getSuit().equals(otherCard.getSuit()));
		}
		
		return result;
	}
	
}
 
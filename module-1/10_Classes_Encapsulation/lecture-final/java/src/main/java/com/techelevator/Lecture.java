package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		Card firstCard = new Card(Card.SUIT_HEARTS, 10);
		
		System.out.println(firstCard);
		
		firstCard.flip();
		
		System.out.println(firstCard);
			
		Card secondCard = new Card(Card.SUIT_CLUBS, 1);		
		System.out.println(firstCard.equals(secondCard));
		
		Card thirdCard = new Card(Card.SUIT_HEARTS, 10);
		System.out.println(firstCard.equals(thirdCard));
		
		System.out.println(secondCard.isGreaterThan(firstCard));
		
		System.out.println(firstCard.isGreaterThan(7));
		
		System.out.println(secondCard.getSerialNumber());
		
		Card anotherCard = new Card("Spades", 9);
		anotherCard = new Card("Spades", 9);
		anotherCard = new Card("Spades", 9);
		anotherCard = new Card("Spades", 9);
		anotherCard = new Card("Spades", 9);
		
		System.out.println(anotherCard.getSerialNumber());
		
		System.out.println(Card.getCreatedCount());
		
		Deck myDeck = new Deck();
		myDeck.shuffle();
		Card nextCard = myDeck.draw();
		while (nextCard != null) {
			nextCard.flip();
			System.out.println(nextCard);
			nextCard = myDeck.draw();
		}
	}

}


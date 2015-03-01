package us.larkoli.cmere.shared;

import java.util.Random;

public class GameDealer {

	public static Game deal() {

		Card[] deck = new Card[] { Card.ONE, Card.ONE, Card.TWO, Card.TWO,
				Card.THREE, Card.THREE, Card.FOUR, Card.FOUR, Card.FIVE,
				Card.FIVE, Card.SIX, Card.SIX, Card.SIX, Card.SIX, Card.SIX,
				Card.SIX };
		
		Card[] player1Hand = pickSix(deck);
		Card[] player2Hand = pickSix(deck);
		
		return new Game(new CardCollection(player1Hand), new CardCollection(player2Hand));
	}

	private static Card[] pickSix(Card[] deck) {
		Card[] result = new Card[6];
		
		int i = 0;
		Random random = new Random();
		
		while (i < 6) {
			int randomIndex = random.nextInt(deck.length);
			Card nextCard = deck[randomIndex];
			if (nextCard != null) {
				result[i] = nextCard;
				deck[randomIndex] = null;
				i++;
			}
		}
		
		return result;
	}

}

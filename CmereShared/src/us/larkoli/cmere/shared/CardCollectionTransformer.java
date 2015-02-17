package us.larkoli.cmere.shared;

import java.util.ArrayList;

public class CardCollectionTransformer {

	public static CardCollection addCard(CardCollection collection, Card newCard) {
		
		Card[] newCards = new Card[collection.cards.size() + 1];
		newCards[0] = newCard;
		for (int i = 0; i < collection.cards.size(); i++) {
			newCards[i + 1] = collection.cards.get(i);
		}
		
		return new CardCollection(newCards);
	}

	public static CardCollection popCard(CardCollection collection) {

		if (collection.cards.size() > 0) {
			Card[] newCards = new Card[collection.cards.size() - 1];
			for (int i = 1; i < collection.cards.size(); i++) {
				newCards[i - 1] = collection.cards.get(i);
			}
			
			return new CardCollection(newCards);
		} else {
			throw new NoCardsLeftToPopException();
		}
	}
	
	public static class NoCardsLeftToPopException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
	
	public static class NoSuchCardToRemoveException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

	public static CardCollection removeCard(CardCollection collection, Card card) {
		
		ArrayList<Card> workingCopy = new ArrayList<Card>(collection.cards);
		boolean removed = workingCopy.remove(card);
		
		if (removed) {
			return new CardCollection(workingCopy.toArray(new Card[0]));
		} else {
			throw new NoSuchCardToRemoveException();
		}
	}
}

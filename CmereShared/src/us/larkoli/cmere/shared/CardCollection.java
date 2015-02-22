package us.larkoli.cmere.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardCollection {
	public final List<Card> cards;
	
	public CardCollection(Card ... cards) {
		this.cards = Collections.unmodifiableList(Arrays.asList(cards));
	}

	private CardCollection(List<Card> cards) {
		this.cards = cards;
	}
	
	public int getCardSum() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.pointValue;
		}
		
		return sum;
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof CardCollection)) {
			return false;
		} else {
			return sameOrderedMatch((CardCollection) other);
		}
	}
	
	public CardCollection getAscendingCopy() {
		ArrayList<Card> copy = new ArrayList<Card>(this.cards);
		Collections.sort(copy);
		
		return new CardCollection(Collections.unmodifiableList(copy));
	}

	private boolean sameOrderedMatch(CardCollection other) {
		
		if (other.cards.size() != this.cards.size()) {
			return false;
		} else {			
			for (int i = 0; i < this.cards.size(); i++) {
				if (this.cards.get(i) != other.cards.get(i)) {
					return false;
				}
			}
			
			return true;
		}
	}
}

package us.larkoli.cmere.shared;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardCollection {
	public final List<Card> cards;
	
	public CardCollection(Card ... cards) {
		this.cards = Collections.unmodifiableList(Arrays.asList(cards));
	}

	public int getCardSum() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.pointValue;
		}
		
		return sum;
	}
}

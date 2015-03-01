package us.larkoli.cmere.shared;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static us.larkoli.cmere.shared.Card.*;

public class CardCollection extends AbstractList<Card> {
	public static final CardCollection FULL_DECK = new CardCollection(ONE, ONE,
			TWO, TWO, THREE, THREE, FOUR, FOUR, FIVE, FIVE, SIX, SIX, SIX, SIX,
			SIX, SIX);
	public static final CardCollection EMPTY = new CardCollection();
	
	public final List<Card> cards;

	public CardCollection(Card... cards) {
		this.cards = Collections.unmodifiableList(Arrays.asList(cards));
	}

	public CardCollection(List<Card> cards) {
		this.cards = Collections.unmodifiableList(new ArrayList<Card>(cards));
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

	@Override
	public Card get(int index) {
		return cards.get(index);
	}

	@Override
	public int size() {
		return cards.size();
	}
}

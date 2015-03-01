package us.larkoli.cmere.shared;

import java.util.Iterator;
import java.util.List;

import com.google.collections.Permutations;

public class OddsCalculator {

	public static class Result {

		public final double oddsThatKnownHandIsLower;

		public Result(double oddsThatKnownHandIsLower) {
			this.oddsThatKnownHandIsLower = oddsThatKnownHandIsLower;
		}

	}

	public static Result analyze(KnownGameState state) {

		int myScore = state.yourHand.getCardSum();
		int numWinningScenarios = 0, numLosingScenarios = 0;
		CardCollection unknownCards = getUnknownCards(state);
		for (CardCollection possibleOtherHand : new PossibleHandleIterable(
				unknownCards)) {

			if (possibleOtherHand.getCardSum() < myScore) {
				numLosingScenarios++;
			} else {
				numWinningScenarios++;
			}
		}

		return new Result((double) numWinningScenarios / (numLosingScenarios + numWinningScenarios));
	}

	private static CardCollection getUnknownCards(KnownGameState state) {
		CardCollection cardsLeft = CardCollection.FULL_DECK;

		for (Card card : state.yourHand) {
			cardsLeft = CardCollectionTransformer.removeCard(cardsLeft, card);
		}

		for (Card card : state.stack) {
			cardsLeft = CardCollectionTransformer.removeCard(cardsLeft, card);
		}
		
		for (int i = 0; i < state.numSixesDiscarded; i++) {
			cardsLeft = CardCollectionTransformer.removeCard(cardsLeft, Card.SIX);
		}
		
		return cardsLeft;
	}

	private static class PossibleHandleIterable implements
			Iterable<CardCollection> {

		public final CardCollection unknownCards;

		public PossibleHandleIterable(CardCollection unknownCards) {
			this.unknownCards = unknownCards;
		}

		@Override
		public Iterator<CardCollection> iterator() {
			// TODO: only find combinations instead of permutations
			final Iterator<List<Card>> permutations = new Permutations<Card>(
					unknownCards, unknownCards.size() - 4);
			return new Iterator<CardCollection>() {

				@Override
				public boolean hasNext() {
					return permutations.hasNext();
				}

				@Override
				public CardCollection next() {
					return new CardCollection(permutations.next());
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};

		}

	}

}

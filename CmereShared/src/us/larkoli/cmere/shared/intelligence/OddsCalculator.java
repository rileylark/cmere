package us.larkoli.cmere.shared.intelligence;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import us.larkoli.cmere.shared.Card;
import us.larkoli.cmere.shared.CardCollection;
import us.larkoli.cmere.shared.CardCollectionTransformer;
import us.larkoli.cmere.shared.Permutations;
import us.larkoli.cmere.shared.gamestate.KnownGameState;

public class OddsCalculator {

	public static class Result {

		public final double oddsThatKnownHandIsLower;

		public Result(double oddsThatKnownHandIsLower) {
			this.oddsThatKnownHandIsLower = oddsThatKnownHandIsLower;
		}

	}

	public static Result analyze(KnownGameState state) {

		int otherStuckScore = state.otherPlayerStuckCards.getCardSum();
		
		int numWinningScenarios = 0, numLosingScenarios = 0;
		CardCollection unknownCards = getUnknownCards(state);
		for (CardCollection possibleOtherHand : new PossibleHandleIterable(
				unknownCards)) {

			if ((possibleOtherHand.getCardSum() + otherStuckScore) < state.yourScore) {
				numLosingScenarios++;
			} else {
				numWinningScenarios++;
			}
		}

		return new Result((double) numWinningScenarios
				/ (numLosingScenarios + numWinningScenarios));
	}

	private static CardCollection getUnknownCards(KnownGameState state) {
		CardCollection cardsLeft = CardCollection.FULL_DECK;

		for (CardCollection collection : new CardCollection[] { state.yourHand,
				state.yourStuckCards, state.otherPlayerStuckCards, state.stack }) {

			for (Card card : collection) {
				cardsLeft = CardCollectionTransformer.removeCard(cardsLeft,
						card);
			}
		}

		for (int i = 0; i < state.numSixesDiscarded; i++) {
			cardsLeft = CardCollectionTransformer.removeCard(cardsLeft,
					Card.SIX);
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

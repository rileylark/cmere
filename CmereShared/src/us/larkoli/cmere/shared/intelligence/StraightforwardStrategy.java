package us.larkoli.cmere.shared.intelligence;

import us.larkoli.cmere.shared.Card;
import us.larkoli.cmere.shared.CardCollection;
import us.larkoli.cmere.shared.Move;
import us.larkoli.cmere.shared.PlayerId;
import us.larkoli.cmere.shared.gamestate.KnownGameState;

public class StraightforwardStrategy implements Strategy {

	@Override
	public Move nextMove(PlayerId playerId, KnownGameState knownGameState) {
		
		if (knownGameState.yourScore <= knownGameState.stack.getCardSum()) {
			return new Move.Call(playerId);
		} else if (knownGameState.yourHand.size() > 0){
			return lay(playerId, knownGameState);
		}
		
		throw new IllegalStateException("A hole in our strategy definition");
	}

	private Move.Lay lay(PlayerId playerId, KnownGameState knownGameState) {
		int scoreDifference = knownGameState.yourScore - knownGameState.stack.getCardSum();
		
		CardCollection ascendingHand = knownGameState.yourHand.getAscendingCopy();
		
		for (Card card : ascendingHand) {
			if (card.pointValue > scoreDifference / 2) {
				return new Move.Lay(playerId, card);
			}
		}
		
		Card highestCard = ascendingHand.get(ascendingHand.size() - 1);
		
		return new Move.Lay(playerId, highestCard);
	}
	 
}

package us.larkoli.cmere.shared.intelligence;

import us.larkoli.cmere.shared.Move;
import us.larkoli.cmere.shared.PlayerId;
import us.larkoli.cmere.shared.gamestate.KnownGameState;

public interface Strategy {
	public Move nextMove(PlayerId playerId, KnownGameState knownGameState);
}

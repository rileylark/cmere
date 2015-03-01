package us.larkoli.cmere.shared.intelligence;

import static org.junit.Assert.*;

import org.junit.Test;

import us.larkoli.cmere.shared.CardCollection;
import us.larkoli.cmere.shared.Move;
import us.larkoli.cmere.shared.PlayerId;
import us.larkoli.cmere.shared.gamestate.KnownGameState;
import static us.larkoli.cmere.shared.Card.*;

public class StraightforwardStrategyTest {

	@Test
	public void testCall() {
		CardCollection yourHand = new CardCollection(ONE, TWO, THREE);
		CardCollection stack = new CardCollection(FOUR, FIVE, SIX);
		KnownGameState state = new KnownGameState(yourHand, CardCollection.EMPTY, CardCollection.EMPTY, stack, 0);
		
		Move move = new StraightforwardStrategy().nextMove(PlayerId.PLAYER_A, state);
		
		assertEquals(Move.Call.class, move.getClass());
	}


	@Test
	public void testLay() {
		CardCollection yourHand = new CardCollection(SIX, FOUR, SIX, TWO);
		CardCollection stack = new CardCollection(ONE, THREE, FIVE);
		KnownGameState state = new KnownGameState(yourHand, CardCollection.EMPTY, CardCollection.EMPTY, stack, 0);
		
		Move move = new StraightforwardStrategy().nextMove(PlayerId.PLAYER_A, state);
		
		assertEquals(Move.Lay.class, move.getClass());
		assertEquals(SIX, ((Move.Lay)move).card);
	}
}

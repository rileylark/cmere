package us.larkoli.cmere.shared;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static us.larkoli.cmere.shared.Card.*;
import static us.larkoli.cmere.shared.PlayerId.*;

public class MoveTest {

	private GameState initialGameState;
	
	@Before
	public void setUp() throws Exception {
		CardCollection player1Hand = new CardCollection(ONE, ONE, THREE, FIVE, SIX);
		CardCollection player2Hand = new CardCollection(TWO, TWO, FOUR, FOUR, SIX);
		CardCollection stack = new CardCollection(THREE, SIX);
		
		initialGameState = new GameState(PLAYER_A, player1Hand, player2Hand, stack, 0, false, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLay() {
		Move.Lay lay = new Move.Lay(PLAYER_A, THREE);
		
		GameState newState = lay.applyTo(initialGameState);
		
		assertEquals(new CardCollection(ONE, ONE, FIVE, SIX), newState.player1Hand);
		assertEquals(new CardCollection(THREE, THREE, SIX), newState.stack);
	}

	@Test 
	public void testDiscard() {
		Move.Discard discard = new Move.Discard(PLAYER_A);
		
		GameState newState = discard.applyTo(initialGameState);
		
		assertEquals(1, newState.numSixesDiscarded);
		assertEquals(new CardCollection(ONE, ONE, THREE, FIVE), newState.player1Hand);
	}
}

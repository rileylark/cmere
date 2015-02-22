package us.larkoli.cmere.shared;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static us.larkoli.cmere.shared.Card.*;

public class MoveTest {

	private GameState initialGameState;
	
	@Before
	public void setUp() throws Exception {
		CardCollection player1Hand = new CardCollection(ONE, ONE, THREE, FIVE, FIVE);
		CardCollection player2Hand = new CardCollection(TWO, TWO, FOUR, FOUR, SIX);
		CardCollection stack = new CardCollection(THREE, SIX);
		
		initialGameState = new GameState(player1Hand, player2Hand, stack);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Move.Lay lay = new Move.Lay(1, THREE);
		
		GameState newState = lay.applyTo(initialGameState);
		
		assertEquals(new CardCollection(ONE, ONE, FIVE, FIVE), newState.player1Hand);
		assertEquals(new CardCollection(THREE, THREE, SIX), newState.stack);
	}

}

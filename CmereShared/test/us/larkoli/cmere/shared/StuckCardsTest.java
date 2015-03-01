package us.larkoli.cmere.shared;

import static org.junit.Assert.*;
import static us.larkoli.cmere.shared.Card.FIVE;
import static us.larkoli.cmere.shared.Card.FOUR;
import static us.larkoli.cmere.shared.Card.ONE;
import static us.larkoli.cmere.shared.Card.SIX;
import static us.larkoli.cmere.shared.Card.THREE;
import static us.larkoli.cmere.shared.Card.TWO;
import static us.larkoli.cmere.shared.PlayerId.PLAYER_A;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StuckCardsTest {

	private GameState initialGameState;
	
	@Before
	public void setUp() throws Exception {
		CardCollection player1Hand = new CardCollection(ONE, ONE, THREE, FIVE, SIX);
		CardCollection player2Hand = new CardCollection(TWO, TWO, FOUR, FOUR, SIX);
		CardCollection stack = new CardCollection(THREE, SIX);
		
		initialGameState = new GameState(PLAYER_A, player1Hand, player2Hand, CardCollection.EMPTY, CardCollection.EMPTY, stack, 0, false, null);
	}

	@Test(expected=Move.IllegalMoveException.class)
	public void testBadMove() {
		Move.Pickup pickup = new Move.Pickup(PLAYER_A, SIX);
		
		pickup.applyTo(initialGameState);
	}

	@Test
	public void testPickupOne() {
		Move.Pickup pickup = new Move.Pickup(PLAYER_A, THREE);
		
		GameState newState = pickup.applyTo(initialGameState);
		
		assertEquals(new CardCollection(THREE), newState.getPlayerStuckCards(PLAYER_A));
		assertEquals(new CardCollection(SIX), newState.stack);
	}
}

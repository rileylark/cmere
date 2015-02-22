package us.larkoli.cmere.shared;

import static org.junit.Assert.assertEquals;
import static us.larkoli.cmere.shared.Card.FIVE;
import static us.larkoli.cmere.shared.Card.FOUR;
import static us.larkoli.cmere.shared.Card.ONE;
import static us.larkoli.cmere.shared.Card.SIX;
import static us.larkoli.cmere.shared.Card.THREE;
import static us.larkoli.cmere.shared.Card.TWO;

import org.junit.Test;

public class CallTest {

	@Test
	public void testWinByDefault() {
		CardCollection player1Hand = new CardCollection(ONE, ONE, TWO, TWO);
		CardCollection player2Hand = new CardCollection(SIX, SIX, SIX, SIX);
		CardCollection stack = new CardCollection(FIVE, THREE);

		GameState state = new GameState(player1Hand, player2Hand, stack, 2, false, null);

		state = new Move.Call(1).applyTo(state);

		assertEquals(true, state.gameOver);
		assertEquals((Integer) 1, state.winnerId);
	}

	@Test
	public void testWinByMargin() {
		CardCollection player1Hand = new CardCollection(ONE, FOUR, FIVE, THREE); // 13
		CardCollection player2Hand = new CardCollection(SIX, TWO, TWO); // 10
		CardCollection stack = new CardCollection(SIX, FIVE, THREE); //14

		GameState state = new GameState(player1Hand, player2Hand, stack, 2, false, null);
		
		state = new Move.Call(1).applyTo(state);
		
		assertEquals(true, state.gameOver);
		assertEquals((Integer) 1, state.winnerId);
	}
	
	@Test
	public void testLose() {
		CardCollection player1Hand = new CardCollection(ONE, FOUR, FIVE, THREE); // 13
		CardCollection player2Hand = new CardCollection(SIX, SIX, ONE); // 13
		CardCollection stack = new CardCollection(SIX, FIVE, THREE); //14

		GameState state = new GameState(player1Hand, player2Hand, stack, 2, false, null);
		
		state = new Move.Call(1).applyTo(state);
		
		assertEquals(true, state.gameOver);
		assertEquals((Integer) 2, state.winnerId);
	}
}

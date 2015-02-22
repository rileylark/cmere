package us.larkoli.cmere.shared;

import static org.junit.Assert.*;
import static us.larkoli.cmere.shared.Card.FIVE;
import static us.larkoli.cmere.shared.Card.FOUR;
import static us.larkoli.cmere.shared.Card.ONE;
import static us.larkoli.cmere.shared.Card.SIX;
import static us.larkoli.cmere.shared.Card.THREE;
import static us.larkoli.cmere.shared.Card.TWO;
import static us.larkoli.cmere.shared.PlayerId.PLAYER_A;
import static us.larkoli.cmere.shared.PlayerId.PLAYER_B;

import org.junit.Test;

import us.larkoli.cmere.shared.Move.IllegalMoveException;

public class InvalidMovesTest {

	@Test(expected=IllegalMoveException.class)
	public void testDoublePlay() {
		GameState state = gameState1();
		state = new Move.Lay(PLAYER_A, THREE).applyTo(state);
		state = new Move.Lay(PLAYER_A, FIVE).applyTo(state);
	}

	public GameState gameState1() {
		CardCollection player1Hand = new CardCollection(ONE, ONE, THREE, FIVE, FIVE);
		CardCollection player2Hand = new CardCollection(TWO, TWO, FOUR, FOUR, SIX);
		CardCollection stack = new CardCollection(THREE, SIX);
		
		return new GameState(PLAYER_A, player1Hand, player2Hand, stack, 0, false, null);
	}
}

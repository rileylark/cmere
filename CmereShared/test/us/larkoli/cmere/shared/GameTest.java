package us.larkoli.cmere.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import static us.larkoli.cmere.shared.Card.*;
import static us.larkoli.cmere.shared.PlayerId.*;

public class GameTest {

	private final CardCollection player1Hand= new CardCollection(ONE, ONE, TWO, TWO, THREE, THREE);
	
	private final CardCollection player2Hand = new CardCollection(FOUR, FOUR, FIVE, FIVE, SIX, SIX);
	private Game game;

	@Before
	public void setup() {
		game = new Game(player1Hand, player2Hand);
	}

	@Test
	public void testViews() {

		KnownGameState player1View = game.getPlayer1View();
		assertEquals(player1Hand, player1View.yourHand);

		KnownGameState player2View = game.getPlayer2View();
		assertEquals(player2Hand, player2View.yourHand);
	}
	
	@Test
	public void testLay() {
		game.addMove(new Move.Lay(PLAYER_A, ONE));
		game.addMove(new Move.Lay(PLAYER_B, SIX));
		
		KnownGameState player1View = game.getPlayer1View();
		assertEquals(new CardCollection(ONE, TWO, TWO, THREE, THREE), player1View.yourHand);
		
		KnownGameState player2View = game.getPlayer2View();
		assertEquals(new CardCollection(FOUR, FOUR, FIVE, FIVE, SIX), player2View.yourHand);
		
		assertEquals(new CardCollection(ONE, SIX), player1View.stack.getAscendingCopy());
		assertEquals(new CardCollection(ONE, SIX), player2View.stack.getAscendingCopy());
		
	}
}

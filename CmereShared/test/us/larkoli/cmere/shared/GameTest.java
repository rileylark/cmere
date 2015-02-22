package us.larkoli.cmere.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private CardCollection player1Hand, player2Hand;
	private Game game;

	@Before
	public void setup() {
		player1Hand = new CardCollection(Card.ONE, Card.ONE, Card.TWO,
				Card.TWO, Card.THREE, Card.THREE);
		player2Hand = new CardCollection(Card.FOUR, Card.FOUR, Card.FIVE,
				Card.FIVE, Card.SIX, Card.SIX);
		game = new Game(player1Hand, player2Hand);
	}

	@Test
	public void testViews() {

		KnownGameState player1View = game.getPlayer1View();
		assertEquals(player1Hand, player1View.yourHand);

		KnownGameState player2View = game.getPlayer2View();
		assertEquals(player2Hand, player2View.yourHand);
	}
}

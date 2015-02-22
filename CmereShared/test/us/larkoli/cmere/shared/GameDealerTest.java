package us.larkoli.cmere.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameDealerTest {

	@Test
	public void testNumberOfCardsDealt() {
		GameDealer gameDealer = new GameDealer();
		Game game = gameDealer.deal();
		
		assertEquals(6, game.player1InitialHand.cards.size());
		assertEquals(6, game.player2InitialHand.cards.size());
	}

}

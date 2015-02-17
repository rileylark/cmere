package us.larkoli.cmere.shared;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayCardTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayMyCard() {
		KnownGameState state = makeStateOne();
		
		state = GameTransformer.playMyCard(state, Card.ONE);
		
		assertEquals(5,  state.stack.getCardSum());
		assertEquals(11, state.yourHand.getCardSum());
	}

	private KnownGameState makeStateOne() {
		CardCollection stack = new CardCollection(Card.ONE, Card.THREE);
		CardCollection yourHand = new CardCollection(Card.ONE, Card.FIVE, Card.SIX);
		
		return new KnownGameState(yourHand, stack); 
	}
}

package us.larkoli.cmere.shared;

import static org.junit.Assert.*;

import org.junit.Test;

import static us.larkoli.cmere.shared.Card.*;

public class OddsCalculatorTest {

	@Test
	public void testCalculateOdds1() {

		CardCollection hand = new CardCollection(ONE, ONE, TWO, TWO);
		CardCollection stack = new CardCollection(FOUR, FOUR, THREE);
		KnownGameState state = new KnownGameState(hand, stack, 1);
	
		OddsCalculator.Result odds = OddsCalculator.analyze(state);
		
		assertEquals(1.0, odds.oddsThatKnownHandIsLower, 0.0001);
	}
	
	@Test
	public void testCalculateOdds2() {

		CardCollection hand = new CardCollection(SIX, SIX, FIVE, FIVE);
		CardCollection stack = new CardCollection(FOUR, FOUR, THREE);
		KnownGameState state = new KnownGameState(hand, stack, 1);
	
		OddsCalculator.Result odds = OddsCalculator.analyze(state);
		
		assertEquals(0.0, odds.oddsThatKnownHandIsLower, 0.0001);
	}
	
	@Test
	public void testCalculateOdds3() {

		CardCollection hand = new CardCollection(TWO);
		CardCollection stack = new CardCollection(ONE, TWO, THREE, FOUR, FOUR, FIVE, FIVE, SIX, SIX, SIX);
		KnownGameState state = new KnownGameState(hand, stack, 0);

	
		OddsCalculator.Result odds = OddsCalculator.analyze(state);

		// the possible cards are [1, 3, 6, 6, 6]. There's a 20% chance they have the 1.
		assertEquals(0.8, odds.oddsThatKnownHandIsLower, 0.0001);
	}
}

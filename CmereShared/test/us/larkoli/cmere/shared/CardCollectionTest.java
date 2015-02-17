package us.larkoli.cmere.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardCollectionTest {


	private CardCollection makeCardCollection1() {
		return new CardCollection(Card.ONE, Card.TWO, Card.THREE);
	}

	@Test
	public void testGetValue() {
		assertEquals(6, makeCardCollection1().getCardSum());
	}
	
	@Test
	public void testAddCard() {
		CardCollection initialHand = makeCardCollection1();
		CardCollection updatedHand = CardCollectionTransformer.addCard(initialHand, Card.TWO);
		assertEquals(8, updatedHand.getCardSum());
	}
	
	@Test
	public void testPopCard() {
		CardCollection stack = makeCardCollection1();
		CardCollection updatedStack = CardCollectionTransformer.popCard(stack);
		updatedStack = CardCollectionTransformer.popCard(updatedStack);
		
		assertEquals(3, updatedStack.getCardSum());
	}

	@Test(expected=CardCollectionTransformer.NoCardsLeftToPopException.class)
	public void testPopTooManyCards() {
		CardCollection stack = makeCardCollection1();
		
		for (int i = 0; i < 4; i++) {
			stack = CardCollectionTransformer.popCard(stack);
		}
	}
	
	@Test
	public void testRemoveCard() {
		CardCollection stack = makeCardCollection1();
		stack = CardCollectionTransformer.removeCard(stack, Card.TWO);
		
		assertEquals(4, stack.getCardSum());
	}
	
	@Test(expected=CardCollectionTransformer.NoSuchCardToRemoveException.class)
	public void testRemoveNonExistentCard() {
		CardCollectionTransformer.removeCard(makeCardCollection1(), Card.FIVE);
	}
	
}

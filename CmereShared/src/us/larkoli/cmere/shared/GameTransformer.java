package us.larkoli.cmere.shared;

public class GameTransformer {

	public static KnownGameState playMyCard(KnownGameState initialState,
			Card card) {

		CardCollection newStack = CardCollectionTransformer.addCard(initialState.stack, card);
		CardCollection newHand = CardCollectionTransformer.removeCard(initialState.yourHand, card);
		
		return new KnownGameState(newHand, newStack);
	}

}

package us.larkoli.cmere.shared.gamestate;

import us.larkoli.cmere.shared.CardCollection;

public class KnownGameState {
	public final CardCollection stack, yourHand, yourStuckCards, otherPlayerStuckCards;
	public final int yourScore;
	public final int numSixesDiscarded;
	
	public KnownGameState(CardCollection initYourHand, CardCollection initYourStuckCards, CardCollection initOtherPlayerStuckCards, CardCollection initStack, int numSixesDiscarded) {
		this.yourHand = initYourHand;
		this.yourStuckCards = initYourStuckCards;
		this.otherPlayerStuckCards = initOtherPlayerStuckCards;
		this.stack = initStack;
		this.numSixesDiscarded = numSixesDiscarded;
		
		this.yourScore = yourHand.getCardSum() + yourStuckCards.getCardSum();
	}
}

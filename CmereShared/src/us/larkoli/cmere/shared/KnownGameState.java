package us.larkoli.cmere.shared;

public class KnownGameState {
	public final CardCollection stack;
	public final CardCollection yourHand;
	public final int numSixesDiscarded;
	
	public KnownGameState(CardCollection initYourHand, CardCollection initStack, int numSixesDiscarded) {
		this.yourHand = initYourHand;
		this.stack = initStack;
		this.numSixesDiscarded = numSixesDiscarded;
	}
}

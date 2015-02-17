package us.larkoli.cmere.shared;

public class KnownGameState {
	public final CardCollection stack;
	public final CardCollection yourHand;
	
	public KnownGameState(CardCollection initYourHand, CardCollection initStack) {
		this.yourHand = initYourHand;
		this.stack = initStack;
	}
}

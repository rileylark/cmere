package us.larkoli.cmere.shared;

public class GameState {
	public final CardCollection player1Hand, player2Hand, stack;

	public GameState(CardCollection player1Hand, CardCollection player2Hand,
			CardCollection stack) {
		this.player1Hand = player1Hand;
		this.player2Hand = player2Hand;
		this.stack = stack;
	}

	public CardCollection getPlayerHand(int playerId) {
		switch (playerId) {
		case 1:
			return player1Hand;
		case 2:
			return player2Hand;
		default:
			throw new IllegalArgumentException("Choose player 1 or 2");
		}
	}
}
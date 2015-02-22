package us.larkoli.cmere.shared;

public class GameState {
	public final CardCollection player1Hand, player2Hand, stack;
	public final int numSixesDiscarded;
	public final boolean gameOver;
	public final Integer winnerId;

	public GameState(CardCollection player1Hand, CardCollection player2Hand) {
		this(player1Hand, player2Hand, new CardCollection(), 0, false, null);
	}
	
	public GameState(CardCollection player1Hand, CardCollection player2Hand,
			CardCollection stack, int numSixesDiscarded, boolean gameOver, Integer winnerId) {
		this.player1Hand = player1Hand;
		this.player2Hand = player2Hand;
		this.stack = stack;
		this.numSixesDiscarded = numSixesDiscarded;
		this.gameOver = gameOver;
		this.winnerId = winnerId;
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

	public CardCollection getOppositePlayerHand(int playerId) {
		switch (playerId) {
		case 1:
			return player2Hand;
		case 2:
			return player1Hand;
		default:
			throw new IllegalArgumentException("Choose player 1 or 2");
		}
	}
}
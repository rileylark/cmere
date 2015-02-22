package us.larkoli.cmere.shared;

public class GameStateBuilder {
	private CardCollection player1Hand, player2Hand, stack;
	int numSixesDiscarded;
	boolean gameOver;
	Integer winnerId;

	public GameStateBuilder from(GameState initialGameState) {
		this.player1Hand = initialGameState.player1Hand;
		this.player2Hand = initialGameState.player2Hand;
		this.stack = initialGameState.stack;
		this.numSixesDiscarded = initialGameState.numSixesDiscarded;
		this.gameOver = initialGameState.gameOver;
		this.winnerId = initialGameState.winnerId;
		
		return this;
	}

	public GameState toGameState() {
		return new GameState(player1Hand, player2Hand, stack, numSixesDiscarded, gameOver, winnerId);
	}
	
	public GameStateBuilder setPlayerHand(int playerId, CardCollection newHand) {
		switch (playerId) {
		case 1:
			this.player1Hand = newHand;
			break;
		case 2:
			this.player2Hand = newHand;
			break;
		default:
			throw new IllegalArgumentException("Choose player 1 or 2");
		}
		
		return this;
	}
	
	public GameStateBuilder setStack(CardCollection newStack) {
		this.stack = newStack;
		
		return this;
	}

	public void setSixesDiscard(int newNumSixesDiscarded) {
		this.numSixesDiscarded = newNumSixesDiscarded;
	}
	
	public void setWinner(int winnerId) {
		this.gameOver = true;
		this.winnerId = winnerId;
	}

	public void setLoser(int playerId) {
		this.gameOver = true;
		if (playerId == 1) {
			this.winnerId = 2;
		} else {
			this.winnerId = 1;
		}
	}
}

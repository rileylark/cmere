package us.larkoli.cmere.shared;

public class GameStateBuilder {
	private CardCollection player1Hand, player2Hand, stack;

	public GameStateBuilder from(GameState initialGameState) {
		this.player1Hand = initialGameState.player1Hand;
		this.player2Hand = initialGameState.player2Hand;
		this.stack = initialGameState.stack;
		
		return this;
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
	
	public GameState toGameState() {
		return new GameState(player1Hand, player2Hand, stack);
	}
}

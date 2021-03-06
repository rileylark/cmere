package us.larkoli.cmere.shared.gamestate;

import us.larkoli.cmere.shared.CardCollection;
import us.larkoli.cmere.shared.PlayerId;

public class GameStateBuilder {
	private CardCollection player1Hand, player2Hand, player1StuckCards, player2StuckCards, stack;
	int numSixesDiscarded;
	boolean gameOver;
	PlayerId winnerId, activePlayer;

	public GameStateBuilder from(GameState initialGameState) {
		this.player1Hand = initialGameState.player1Hand;
		this.player2Hand = initialGameState.player2Hand;
		this.player1StuckCards = initialGameState.player1StuckCards;
		this.player2StuckCards = initialGameState.player2StuckCards;
		this.stack = initialGameState.stack;
		this.numSixesDiscarded = initialGameState.numSixesDiscarded;
		this.gameOver = initialGameState.gameOver;
		this.winnerId = initialGameState.winnerId;
		this.activePlayer = initialGameState.activePlayer;
		
		return this;
	}

	public GameState toGameState() {
		return new GameState(activePlayer, player1Hand, player2Hand, player1StuckCards, player2StuckCards, stack, numSixesDiscarded, gameOver, winnerId);
	}
	
	public GameStateBuilder setPlayerHand(PlayerId playerId, CardCollection newHand) {
		switch (playerId) {
		case PLAYER_A:
			this.player1Hand = newHand;
			break;
		case PLAYER_B:
			this.player2Hand = newHand;
			break;
		default:
			throw new IllegalArgumentException("Choose PLAYER_A or PLAYER_B");
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
	
	public void setWinner(PlayerId winnerId) {
		this.gameOver = true;
		this.winnerId = winnerId;
	}

	public void setActivePlayer(PlayerId newActivePlayer) {
		this.activePlayer = newActivePlayer;
	}

	public void setPlayerStuckCards(PlayerId playerId, CardCollection newStuckCards) {
		switch (playerId) {
		case PLAYER_A:
			this.player1StuckCards = newStuckCards;
			break;
		case PLAYER_B:
			this.player2StuckCards = newStuckCards;
			break;
		default:
			throw new IllegalArgumentException("Choose PLAYER_A or PLAYER_B");
		}
	}
}

package us.larkoli.cmere.shared;

import java.util.ArrayList;

public class Game {

	public final CardCollection player1InitialHand, player2InitialHand;
	private final ArrayList<Move> moves = new ArrayList<Move>();

	public Game(CardCollection player1InitialHand,
			CardCollection player2InitialHand) {
		this.player1InitialHand = player1InitialHand;
		this.player2InitialHand = player2InitialHand;
	}

	public KnownGameState getPlayer1View() {

		GameState currentState = getCurrentGameState();
		return new KnownGameState(currentState.player1Hand, currentState.stack, currentState.numSixesDiscarded);
	}

	public KnownGameState getPlayer2View() {
		GameState currentState = getCurrentGameState();
		return new KnownGameState(currentState.player2Hand, currentState.stack, currentState.numSixesDiscarded);
	}

	public GameState getCurrentGameState() {
		GameState state = new GameState(player1InitialHand, player2InitialHand);
		for (Move move : moves) {
			state = move.applyTo(state);
		}
		
		return state;
	}

	public void addMove(Move move) {
		moves.add(move);
	}
}

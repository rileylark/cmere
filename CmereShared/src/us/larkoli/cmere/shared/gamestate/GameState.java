package us.larkoli.cmere.shared.gamestate;

import static us.larkoli.cmere.shared.PlayerId.*;
import us.larkoli.cmere.shared.CardCollection;
import us.larkoli.cmere.shared.PlayerId;

public class GameState {
	public final PlayerId activePlayer;
	public final CardCollection player1Hand, player2Hand, player1StuckCards,
			player2StuckCards, stack;
	public final int numSixesDiscarded;
	public final boolean gameOver;
	public final PlayerId winnerId;

	public GameState(CardCollection player1Hand, CardCollection player2Hand) {
		this(PLAYER_A, player1Hand, player2Hand, new CardCollection(),
				new CardCollection(), new CardCollection(), 0, false, null);
	}

	public GameState(PlayerId activePlayer, CardCollection player1Hand,
			CardCollection player2Hand, CardCollection player1StuckCards,
			CardCollection player2StuckCards, CardCollection stack,
			int numSixesDiscarded, boolean gameOver, PlayerId winnerId) {
		this.activePlayer = activePlayer;
		this.player1Hand = player1Hand;
		this.player2Hand = player2Hand;
		this.player1StuckCards = player1StuckCards;
		this.player2StuckCards = player2StuckCards;
		this.stack = stack;
		this.numSixesDiscarded = numSixesDiscarded;
		this.gameOver = gameOver;
		this.winnerId = winnerId;
	}

	public CardCollection getPlayerHand(PlayerId playerId) {
		switch (playerId) {
		case PLAYER_A:
			return player1Hand;
		case PLAYER_B:
			return player2Hand;
		default:
			throw new IllegalArgumentException("Choose PLAYER_A or PLAYER_B");
		}
	}

	public CardCollection getPlayerStuckCards(PlayerId playerId) {
		switch (playerId) {
		case PLAYER_A:
			return player1StuckCards;
		case PLAYER_B:
			return player2StuckCards;
		default:
			throw new IllegalArgumentException("Choose PLAYER_A or PLAYER_B");
		}
	}
}
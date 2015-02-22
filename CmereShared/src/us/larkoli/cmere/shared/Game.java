package us.larkoli.cmere.shared;

public class Game {

	public final CardCollection player1InitialHand, player2InitialHand;

	public Game(CardCollection player1InitialHand,
			CardCollection player2InitialHand) {
		this.player1InitialHand = player1InitialHand;
		this.player2InitialHand = player2InitialHand;
	}

	public KnownGameState getPlayer1View() {
		return getView(1);
	}

	public KnownGameState getPlayer2View() {
		return getView(2);
	}

	private KnownGameState getView(int playerId) {
		CardCollection playerHand;
		if (playerId == 1) {
			playerHand = player1InitialHand;
		} else if (playerId == 2) {
			playerHand = player2InitialHand;
		} else {
			throw new IllegalArgumentException("Ask for player 1 or 2");
		}

		CardCollection stack = new CardCollection();

		return new KnownGameState(playerHand, stack);
	}
}

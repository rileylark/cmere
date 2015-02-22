package us.larkoli.cmere.shared;

public abstract class Move {

	public final int playerId;

	public Move(int playerId) {
		this.playerId = playerId;
	}

	public abstract GameState applyTo(GameState initialGameState);

	public static class Lay extends Move {
		public final Card card;

		public Lay(int playerId, Card card) {
			super(playerId);
			this.card = card;
		}

		@Override
		public GameState applyTo(GameState initialGameState) {
			// take card out of player's hand and add to stack
			CardCollection playersHand = initialGameState
					.getPlayerHand(playerId);
			CardCollection stack = initialGameState.stack;

			playersHand = CardCollectionTransformer.removeCard(playersHand,
					card);
			stack = CardCollectionTransformer.addCard(stack, card);

			return new GameStateBuilder().from(initialGameState)
					.setPlayerHand(playerId, playersHand).setStack(stack)
					.toGameState();
		}
	}
}

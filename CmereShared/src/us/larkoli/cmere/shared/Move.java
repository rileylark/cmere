package us.larkoli.cmere.shared;

import static us.larkoli.cmere.shared.Card.*;

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
	
	public static class Discard extends Move {
		public Discard(int playerId) {
			super(playerId);
		}

		@Override
		public GameState applyTo(GameState initialGameState) {
			GameStateBuilder builder = new GameStateBuilder();
			
			builder.from(initialGameState);
			builder.setSixesDiscard(initialGameState.numSixesDiscarded + 1);
			builder.setPlayerHand(playerId, CardCollectionTransformer.removeCard(initialGameState.getPlayerHand(playerId), SIX));
			
			return builder.toGameState();
		}
	}
	
	public static class Call extends Move {
		public Call(int playerId) {
			super(playerId);
		}

		@Override
		public GameState applyTo(GameState initialGameState) {
			GameStateBuilder builder = new GameStateBuilder().from(initialGameState);
			
			CardCollection thisHand = initialGameState.getPlayerHand(playerId);
			CardCollection otherHand = initialGameState.getOppositePlayerHand(playerId);
			CardCollection stack = initialGameState.stack;
			
			if (otherHand.getCardSum() > stack.getCardSum()) {
				builder.setWinner(playerId);
			} else if (otherHand.getCardSum() < thisHand.getCardSum()) {
				builder.setWinner(playerId);
			} else {
				builder.setLoser(playerId);
			}
			
			return builder.toGameState();
		}
	}
}

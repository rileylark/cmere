package us.larkoli.cmere.shared;

import static us.larkoli.cmere.shared.Card.*;

public abstract class Move {

	public final PlayerId playerId;

	public Move(PlayerId playerId) {
		this.playerId = playerId;
	}

	public final GameState applyTo(GameState initialGameState) {
		GameStateBuilder builder = new GameStateBuilder().from(initialGameState);
		
		if (legalMove(initialGameState)) {
			applyMutations(initialGameState, builder);
			
			return builder.toGameState();	
		} else {
			throw new IllegalMoveException();
		}
	}
	
	public final boolean legalMove(GameState initialGameState) {
		return true;
	}
	
	protected abstract void applyMutations(GameState initialGameState, GameStateBuilder builder);

	
	public static class Lay extends Move {
		public final Card card;

		public Lay(PlayerId playerId, Card card) {
			super(playerId);
			this.card = card;
		}

		@Override
		public void applyMutations(GameState initialGameState, GameStateBuilder builder) {
			// take card out of player's hand and add to stack
			CardCollection playersHand = initialGameState
					.getPlayerHand(playerId);
			CardCollection stack = initialGameState.stack;

			playersHand = CardCollectionTransformer.removeCard(playersHand,
					card);
			stack = CardCollectionTransformer.addCard(stack, card);

			builder
					.setPlayerHand(playerId, playersHand).setStack(stack)
					.toGameState();
		}
	}
	
	public static class Discard extends Move {
		public Discard(PlayerId playerId) {
			super(playerId);
		}

		@Override
		public void applyMutations(GameState initialGameState, GameStateBuilder builder) {
			builder.setSixesDiscard(initialGameState.numSixesDiscarded + 1);
			builder.setPlayerHand(playerId, CardCollectionTransformer.removeCard(initialGameState.getPlayerHand(playerId), SIX));
		}
	}
	
	public static class Call extends Move {
		public Call(PlayerId playerId) {
			super(playerId);
		}

		@Override
		public void applyMutations(GameState initialGameState, GameStateBuilder builder) {
			CardCollection thisHand = initialGameState.getPlayerHand(playerId);
			CardCollection otherHand = initialGameState.getPlayerHand(playerId.otherPlayer());
			CardCollection stack = initialGameState.stack;
			
			if (otherHand.getCardSum() > stack.getCardSum()) {
				builder.setWinner(playerId);
			} else if (otherHand.getCardSum() < thisHand.getCardSum()) {
				builder.setWinner(playerId);
			} else {
				builder.setWinner(playerId.otherPlayer());
			}
		}
	}
	
	public static class IllegalMoveException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}

package us.larkoli.cmere.client;

import us.larkoli.cmere.shared.Card;
import us.larkoli.cmere.shared.CardCollection;
import us.larkoli.cmere.shared.Game;
import us.larkoli.cmere.shared.Move;
import us.larkoli.cmere.shared.PlayerId;
import us.larkoli.cmere.shared.gamestate.GameState;
import us.larkoli.cmere.shared.gamestate.KnownGameState;
import us.larkoli.cmere.shared.intelligence.StraightforwardStrategy;

import com.google.gwt.core.client.EntryPoint;

public class sharedJsBridge implements EntryPoint {

	private final Card card = Card.FOUR;

	public void onModuleLoad() {
		exportShared(card);
	}
	
	private int[] exportCards(CardCollection cardCollection) {
		int[] collection = new int[cardCollection.size()];
		for (int i = 0; i < cardCollection.size(); i++) {
			collection[i] = cardCollection.get(i).pointValue;
		}
		
		return collection;
	}
	
	private native String exportPlayerId(PlayerId playerId) /*-{
		if (playerId) {
			return playerId.@us.larkoli.cmere.shared.PlayerId::toString()();
		} else {
			return null;
		}
	}-*/;

	private native void exportCardCollection(CardCollection cardCollection) /*-{
		return {
			cards: this.@us.larkoli.cmere.client.sharedJsBridge::exportCards(Lus/larkoli/cmere/shared/CardCollection;)(cardCollection),
			cardSum: cardCollection.@us.larkoli.cmere.shared.CardCollection::getCardSum()()
		};
	}-*/;
	
	private native void exportGameState(GameState gameState) /*-{
		var exporter = this;
		var player1Hand = gameState.@us.larkoli.cmere.shared.gamestate.GameState::player1Hand;
		var player2Hand = gameState.@us.larkoli.cmere.shared.gamestate.GameState::player2Hand;
		var player1StuckCards = gameState.@us.larkoli.cmere.shared.gamestate.GameState::player1StuckCards;
		var player2StuckCards = gameState.@us.larkoli.cmere.shared.gamestate.GameState::player2StuckCards;
		var stack = gameState.@us.larkoli.cmere.shared.gamestate.GameState::stack;
		var numSixesDiscarded = gameState.@us.larkoli.cmere.shared.gamestate.GameState::numSixesDiscarded;
		var winnerId = gameState.@us.larkoli.cmere.shared.gamestate.GameState::winnerId;
		var activePlayerId = gameState.@us.larkoli.cmere.shared.gamestate.GameState::activePlayer;
		
		return {
			gameOver: gameState.@us.larkoli.cmere.shared.gamestate.GameState::gameOver,
			winnerId: exporter.@us.larkoli.cmere.client.sharedJsBridge::exportPlayerId(Lus/larkoli/cmere/shared/PlayerId;)(winnerId),
			activePlayerId: exporter.@us.larkoli.cmere.client.sharedJsBridge::exportPlayerId(Lus/larkoli/cmere/shared/PlayerId;)(activePlayerId),
			player1Hand:  exporter.@us.larkoli.cmere.client.sharedJsBridge::exportCardCollection(Lus/larkoli/cmere/shared/CardCollection;)(player1Hand),
			player2Hand:  exporter.@us.larkoli.cmere.client.sharedJsBridge::exportCardCollection(Lus/larkoli/cmere/shared/CardCollection;)(player2Hand),
			player1StuckCards:  exporter.@us.larkoli.cmere.client.sharedJsBridge::exportCardCollection(Lus/larkoli/cmere/shared/CardCollection;)(player1StuckCards),
			player2StuckCards:  exporter.@us.larkoli.cmere.client.sharedJsBridge::exportCardCollection(Lus/larkoli/cmere/shared/CardCollection;)(player2StuckCards),
			stack:  exporter.@us.larkoli.cmere.client.sharedJsBridge::exportCardCollection(Lus/larkoli/cmere/shared/CardCollection;)(stack),
			numSixesDiscarded: numSixesDiscarded
		};
	}-*/;
	
	private Move.Lay makeLayMove(int cardValue) {
		Move.Lay newMove = new Move.Lay(PlayerId.PLAYER_A, Card.fromPointValue(cardValue));
		return newMove;
	}
	
	private void makeComputerMove(Game game) {
		
		KnownGameState computerView = game.getPlayer2View();
		StraightforwardStrategy strat = new StraightforwardStrategy();
		Move move = strat.nextMove(PlayerId.PLAYER_B, computerView);
		game.addMove(move);
	}
	
	private native void exportGame(Game game) /*-{
		var exporter = this;
		
		return {
			getCurrentGameState: function () {
				var gameState = game.@us.larkoli.cmere.shared.Game::getCurrentGameState()();
				return exporter.@us.larkoli.cmere.client.sharedJsBridge::exportGameState(Lus/larkoli/cmere/shared/gamestate/GameState;)(gameState);
			},
			
			addPlayer1Move: {
				lay: function layCard(card) {
					var newMove = exporter.@us.larkoli.cmere.client.sharedJsBridge::makeLayMove(I)(card);
					game.@us.larkoli.cmere.shared.Game::addMove(Lus/larkoli/cmere/shared/Move;)(newMove);
				}				
			},
			
			addComputerMove: function () {
				exporter.@us.larkoli.cmere.client.sharedJsBridge::makeComputerMove(Lus/larkoli/cmere/shared/Game;)(game);
			}
		};
	}-*/;
	
	private native void exportShared(Card card) /*-{
		var exporter = this;
		var jsCard = card.@us.larkoli.cmere.shared.Card::toString()();

		$wnd.cmereShared = {
			deal: function () {
				var game = @us.larkoli.cmere.shared.GameDealer::deal()();				
				return exporter.@us.larkoli.cmere.client.sharedJsBridge::exportGame(Lus/larkoli/cmere/shared/Game;)(game);
			}
		};
		if (typeof $wnd.cmereSharedLoaded === 'function') {
			$wnd.cmereSharedLoaded();
		}
	}-*/;
}

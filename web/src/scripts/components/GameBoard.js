'use strict';

var React = require('react/addons');
var cardWidgets = require('./cardWidgets');
var KnownHand = cardWidgets.KnownHand;
var Stack = cardWidgets.Stack;

// CSS
require('../../styles/normalize.css');
require('../../styles/main.css');


var GameBoard = React.createClass({
    componentWillMount: function () {
        var component = this;

        component.setState({
            gameState: component.props.gameStore.getGameState()
        });

        component.props.eventBus.addListener(function (event) {
            if (event.gameStateChanged) {
                component.setState({
                    gameState: component.props.gameStore.getGameState()
                });
            }
        });
    },

    fireEvent: function (event) {
        this.props.eventBus.fire(event);
    },

    playCard: function (card) {
        this.fireEvent({
            type: 'PLAY_CARD',
            card: card
        });
    },

    callRound: function () {
        this.fireEvent({
            type: 'CALL_ROUND'
        });
    },

    discard: function () {
        this.fireEvent({
            type: 'DISCARD'
        });
    },

    pickUpFromStack: function () {
        this.fireEvent({
            type: 'PICK_UP_FROM_STACK'
        });
    },

    render: function () {
        var game = this.props.game;
        var component = this;
        var header, actionButtons;

        if (this.state.gameState.gameOver) {
            header = <div>Winner: {this.state.gameState.winnerId}</div>;
            actionButtons = <div></div>;
        } else {
            header = <div>Current player: {this.state.gameState.activePlayerId}</div>;
            actionButtons = <div>
                <button onClick={component.callRound}>
                Call
                </button>
                <button onClick={component.discard}>
                Discard
                </button>
            </div>;
        }


        return (
            <div className='main'>
                {header}
                <div>
                Opponent has {this.state.gameState.player2Hand.cards.length} cards left
                </div>
                <div>
                Stack
                    <Stack cardCollection={this.state.gameState.stack} onPickup={component.pickUpFromStack} />
                </div>
                <div>
                Your Hand
                    <KnownHand
                    stuckCards={this.state.gameState.player1StuckCards}
                    movableCards={this.state.gameState.player1Hand}
                    onClickCard={component.playCard}
                    />
                </div>
                {actionButtons}

            </div>
            );
    }
});

module.exports = GameBoard;

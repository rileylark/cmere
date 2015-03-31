'use strict';

var React = require('react/addons');
var cardWidgets = require('./cardWidgets');
var KnownHand = cardWidgets.KnownHand;
var Stack = cardWidgets.Stack;

// CSS
require('../../styles/normalize.css');
require('../../styles/main.css');


var CmereApp = React.createClass({
    componentWillMount: function () {
        var component = this;

        component.setState({
            gameState: component.props.gameState
        });
    },

    fireEvent: function (event) {
        var newState = this.props.eventProcessor(event);
        this.setState({gameState: newState});
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
                <h1>C'mere</h1>
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

module.exports = CmereApp;

'use strict';

var React = require('react/addons');
var KnownHand = require('./KnownHand');

// CSS
require('../../styles/normalize.css');
require('../../styles/main.css');


var CmereApp = React.createClass({
    componentWillMount: function () {
        var component = this;
        var game = component.props.game;

        component.setState({
            gameState: game.getCurrentGameState()
        });
    },

    playCard: function (card) {
        this.props.game.addPlayer1Move.lay(card);
        this.props.game.addComputerMove();
        this.setState({gameState: this.props.game.getCurrentGameState()});
    },

    render: function () {
        var game = this.props.game;
        var component = this;

        return (
            <div className='main'>
                <h1>C'mere</h1>
                <div>
                Current player: {this.state.gameState.activePlayerId}
                </div>
                <div>
                Winner: {this.state.gameState.winnerId}
                </div>
                <div>
                Opponent has {this.state.gameState.player2Hand.cards.length} cards left
                </div>
                <div>
                Stack
                    <KnownHand cardCollection={this.state.gameState.stack}/>
                </div>
                <div>
                Your Hand
                    <KnownHand
                    cardCollection={this.state.gameState.player1Hand}
                    onClickCard={component.playCard}
                    />
                </div>
            </div>
            );
    }
});

module.exports = CmereApp;

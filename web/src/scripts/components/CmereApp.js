'use strict';

var React = require('react/addons');
var KnownHand = require('./KnownHand');

// CSS
require('../../styles/normalize.css');
require('../../styles/main.css');


var CmereApp = React.createClass({
    render: function () {
        var playCard = function(card) {
            console.log("PLAYING: ", card);
        };

        return (
            <div className='main'>
                <h1>C'mere</h1>
                <div>
                    Opponent has {this.props.gameState.player2Hand} cards
                </div>
                <div>
                    Stack
                    <KnownHand cardCollection={this.props.gameState.stack}/>
                </div>
                <div>
                    Your Hand
                    <KnownHand
                        cardCollection={this.props.gameState.player1Hand}
                        onClickCard={playCard}
                    />
                </div>
            </div>
            );
    }
});

module.exports = CmereApp;

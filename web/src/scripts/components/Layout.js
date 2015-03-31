'use strict';

var React = require('react/addons');
var Menu = require('./Menu');
var GameBoard = require('./GameBoard');


require('./layout.css');

function checkForNewGameState(component) {
    var gameState = component.props.gameStore.getGameState();

    component.setState({
        aGameExists: !!gameState,
        menuOpen: !gameState || (gameState && gameState.gameOver)
    });
}

module.exports = React.createClass({
    componentWillMount: function () {
        var component = this;
        component.props.eventBus.addListener(function (event) {
            if (event.gameStateChanged) {
                checkForNewGameState(component);
            }
        });

        checkForNewGameState(component);
    },
    render: function () {
        var component = this, gamePanel;


        if (component.state.aGameExists) {
            gamePanel = (
                <GameBoard
                gameStore={component.props.gameStore}
                eventBus={component.props.eventBus}/>
                );
        } else {
            gamePanel = <div>Start a New Game</div>;
        }

        var menuClass = component.state.menuOpen ? "menu--open" : "menu--closed";

        return <div>
            <div className="headerPanel">
                <h1>C'mere</h1>
            </div>
            <div className={"menuPanel " + menuClass}>
                <Menu eventBus={component.props.eventBus}/>
            </div>
            <div className={"gamePanel " + menuClass}>
            {gamePanel}
            </div>

        </div>
    }
});
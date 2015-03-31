'use strict';

var React = require('react/addons');
var Menu = require('./Menu');
var GameBoard = require('./GameBoard');


require('./layout.css');

module.exports = React.createClass({
    render: function () {
        var component = this;
        return <div>
            <div className="headerPanel">
                <h1>C'mere</h1>
            </div>
            <div className="menuPanel">
                <Menu eventBus={component.props.eventBus}/>
            </div>
            <div className="gamePanel">
                <GameBoard
                gameStore={component.props.gameStore}
                eventBus={component.props.eventBus}/>
            </div>

        </div>
    }
});
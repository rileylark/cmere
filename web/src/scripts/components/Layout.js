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
                <Menu eventProcessor={component.props.eventProcessor} />
            </div>
            <div className="gamePanel">
                <GameBoard
                gameStore={component.props.gameStore}
                eventProcessor={component.props.eventProcessor}
                eventBus={component.props.eventBus}/>
            </div>

        </div>
    }
});
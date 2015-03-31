'use strict';

var React = require('react/addons');
var Menu = require('./Menu');
var GameBoard = require('./GameBoard');

module.exports = React.createClass({
    render: function () {
        var component = this;
        return <div>
            <h1>C'mere</h1>
            <Menu />
            <GameBoard gameState={component.props.gameState} eventProcessor={component.props.eventProcessor}/>
        </div>
    }
});
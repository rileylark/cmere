var React = require('react/addons');

require('./menu.css');

module.exports = React.createClass({
    startNewGame: function () {
        this.props.eventProcessor({
            type: 'START_NEW_GAME'
        });
    },
    render: function () {
        var component = this;

        return (
            <div className="menu">
                <button onClick={component.startNewGame}>New Game</button>
            </div>
            );
    }
});
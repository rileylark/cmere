var React = require('react/addons');

require('./menu.css');

module.exports = React.createClass({
    startNewGame: function () {
        this.props.eventBus.fire({
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
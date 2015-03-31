'use strict';

var React = require('react/addons');

// CSS
require('../../styles/normalize.css');
require('../../styles/main.css');

require("./card.css");

var createCard = function (card) {

    var params = {
        extraClassName: card.extraClassName || '',
        value: card.value,
        onClick: card.onClick || function () {}
    };

    var className = "card card" + params.value + " " + params.extraClassName;
    var clickHandler = function () {
        if (typeof params.onClick === 'function') {
            params.onClick(params.value);
        }
    };

    return <div
    onClick={clickHandler}
    className={className}>
                 {params.value}
    </div>;
};

var KnownHand = React.createClass({
    render: function () {

        var cards = [], i;

        for (i = 0; i < this.props.stuckCards.cards.length; i++) {
            cards.push(createCard({ value: this.props.stuckCards.cards[i] , extraClassName: "stuck"}));
        }

        for (i = 0; i < this.props.movableCards.cards.length; i++) {
            cards.push(createCard({ value: this.props.movableCards.cards[i], onClick: this.props.onClickCard}));
        }

        return (
            <div>{cards}</div>
            );
    }
});

var Stack = React.createClass({
    render: function () {
        var cards = [], i;
        if (this.props.cardCollection.cards.length > 0) {
            cards.push(createCard({ value: this.props.cardCollection.cards[0], onClick: this.props.onPickup }));
        }

        for (i = 1; i < this.props.cardCollection.cards.length; i++) {
            cards.push(createCard({ value: this.props.cardCollection.cards[i] }));
        }

        return (
            <div>{cards}</div>
            );
    }
});

module.exports = {
    KnownHand: KnownHand,
    Stack: Stack
};

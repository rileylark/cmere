'use strict';

var React = require('react/addons');

// CSS
require('../../styles/normalize.css');
require('../../styles/main.css');

require("./card.css");

var createCard = function (card, onClickCard) {
    var className = "card card" + card;
    var clickHandler = function () {
        onClickCard(card);
    };

    return <div
    onClick={clickHandler}
    className={className}>
                 {card}
    </div>;
};

var KnownHand = React.createClass({
    render: function () {

        var cards = [], i;
        for (i = 0; i < this.props.cardCollection.cards.length; i++) {
            cards.push(createCard(this.props.cardCollection.cards[i], this.props.onClickCard));
        }

        return (
            <div>{cards}</div>
            );
    }
});

var Stack = React.createClass({
    render: function () {
        var cards = [], i;
        for (i = 0; i < this.props.cardCollection.cards.length; i++) {
            cards.push(createCard(this.props.cardCollection.cards[i], this.props.onClickCard));
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

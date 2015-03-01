'use strict';

var React = require('react/addons');
var KnownHand = require('./KnownHand');

// CSS
require('../../styles/normalize.css');
require('../../styles/main.css');


var CmereApp = React.createClass({
    render: function () {
        return (
            <div className='main'>
                <h1>C'mere</h1>
                <div>
                    Opponent Hand
                </div>
                <div>
                    Stack
                </div>
                <div>
                    Your Hand
                    <KnownHand />
                </div>
            </div>
            );
    }
});

module.exports = CmereApp;

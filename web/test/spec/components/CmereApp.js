'use strict';

describe('Main', function () {
  var React = require('react/addons');
  var CmereApp, component;

  beforeEach(function () {
    var container = document.createElement('div');
    container.id = 'content';
    document.body.appendChild(container);

    CmereApp = require('../../../src/scripts/components/CmereApp.js');
    component = React.createElement(CmereApp);
  });

  it('should create a new instance of CmereApp', function () {
    expect(component).toBeDefined();
  });
});

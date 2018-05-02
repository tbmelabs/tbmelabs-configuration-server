// @flow
'use strict';

import {applyMiddleware, compose, createStore} from 'redux';
import thunk from 'redux-thunk';

import reducers from './state/reducers';

import logger from 'redux-logger';

import createSagaMiddleware from 'redux-saga';
import sagas from './state/sagas';

const middlewares = [];
const environment = require('./config/environment').environment;

middlewares.push(thunk);

if (environment === 'dev') {
  middlewares.push(logger);
}

const sagaMiddleware = createSagaMiddleware();
middlewares.push(sagaMiddleware);

const store = createStore(
  reducers,
  compose(
    applyMiddleware(...middlewares),
    window.devToolsExtension ? window.devToolsExtension() : f => f
  )
);

sagas.forEach(saga => sagaMiddleware.run(saga));

export default () => {
  return store;
};

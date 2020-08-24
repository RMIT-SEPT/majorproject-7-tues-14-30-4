import React from 'react';
import Header from './components/Layout/Header';
import Footer from './components/Layout/Footer';
// import LeftColumn from './components/Layout/LeftColumn';
import Body from './components/Layout/Body';
import Dashboard from './components/Dashboard';


import {BrowserRouter as Router, Route} from "react-router-dom";
import {Provider} from "react-redux";
import store from './store';

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div>
          <Header/>
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/" component={Body} />
          <Footer/>
        </div>
      </Router>
    </Provider>
  );
}

export default App;


// <Body/>
// <Dashboard/>
import React from 'react';
import Header from './components/Layout/Header';
import Footer from './components/Layout/Footer';
// import LeftColumn from './components/Layout/LeftColumn';
import Dashboard from './components/Dashboard';
import Signin from './components/Signin/Signin'
import Home from './components/Home'


import {BrowserRouter as Router, Route} from "react-router-dom";
import {Provider} from "react-redux";
import store from './store';

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="overall">
          <Header/>
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/dashboard/:id" component={Dashboard} />
          <Route exact path="/" component={Home} />
          <Route exact path="/home" component={Home} />
          <Route exact path="/signin" component={Signin} />
          <Footer/>
        </div>
      </Router>
    </Provider>
  );
}

export default App;


// <Body/>
// <Dashboard/>
import React from 'react';
import Header from './components/Layout/Header';
import Footer from './components/Layout/Footer';
// import LeftColumn from './components/Layout/LeftColumn';
import Dashboard from './components/Dashboard';
import Login from './components/Session/Login'
import Logout from "./components/Session/Logout";
import Home from './components/Home'
import Signup from './components/Session/Signup'
// import Signin from './components/Signin/Signin'
import Services from './components/Services';
import Service from './components/Service';

import {BrowserRouter as Router, Route} from "react-router-dom";
import {Provider} from "react-redux";
import store from './store';

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="overall">
          <Header />
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/service/:name" component={Service} />
          <Route exact path="/" component={Home} />
          <Route exact path="/home" component={Home} />
          <Route exact path="/login" component={Login} />
          <Route exact path="/logout" component={Logout} />
          <Route exact path="/signup" component={Signup} />
          <Route exact path="/services" component={Services} />
          <Footer/>
        </div>
      </Router>
    </Provider>
  );
}

export default App;


// <Body/>
// <Dashboard/>
import React from 'react';
import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router, Route} from "react-router-dom";
import AddUser from './components/Persons/AddUser';
import {Provider} from "react-redux";
import store from './store';


function App() {
  return (
    <Provider store={store}>
      <Router>
        <div>
          <Header/>
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/addUser" component={AddUser} />
        </div>
      </Router>
    </Provider>
  );
}

export default App;

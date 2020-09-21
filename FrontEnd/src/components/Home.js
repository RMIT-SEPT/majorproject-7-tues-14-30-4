import React, { Component } from 'react'
import axios from "axios";
import AddUser from './User/AddUser'
import {link, Link} from "react-router-dom";

import {createUser, UserProfiles} from '../actions/personActions'
 
// import CreatePersonButton from './Persons/CreatePersonButton';

class Home extends Component {

    render() {
        return (
            <div className="dashboard">
                <p>Welcome to AGME's AGME's Online Appointment Booking System. Here your customers can book and hire your companies
                services easily with the click of a button</p>
                <br/>
                <p>Don't have an account? Sign up&nbsp;
                    <Link to="/signup"
                    className="mainbutton">
                    Here!
                    </Link>
                </p>
                <br/>

                {/*
                
                <div className='Body'>
                    <div className='column'>
                        <p>Avaliable jobs</p>
                    
                    </div>

                    <div
                */}

            </div>
        )
    }
}

export default Home;

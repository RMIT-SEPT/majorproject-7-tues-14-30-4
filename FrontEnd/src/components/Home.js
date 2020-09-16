import React, { Component } from 'react'
import axios from "axios";
import AddUser from './User/AddUser'

import {createUser, UserProfiles} from '../actions/personActions'
 
// import CreatePersonButton from './Persons/CreatePersonButton';

class Home extends Component {

    render() {
        return (
            <div className="dashboard">
                <p>This is the home page</p>
                <br/>
                <div className='Body'>
                    <div className='column'>
                        <p>Avaliable jobs</p>
                    
                    </div>

                    <div className='column'></div>
                </div>

            </div>
        )
    }
}

export default Home;

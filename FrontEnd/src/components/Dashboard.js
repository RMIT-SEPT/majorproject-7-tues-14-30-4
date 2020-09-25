import React, { Component } from 'react'
import axios from "axios";
import AddUser from './User/AddUser'
import UserProfile from '../Tools/UserProfile';
import {getUser} from '../Tools/tools_helper'
import CreateWorker from './Admin/CreateWorker'

// import {createUser, UserProfiles} from '../actions/personActions'
 
// import CreatePersonButton from './Persons/CreatePersonButton';

class Dashboard extends Component {

    constructor() {
        super();
        this.state = {
            loggedUser: {}
        };
    }

    componentDidMount() {
        const string =  "http://localhost:8080/api/user/id/" + localStorage.getItem("LoggedUser").toUpperCase() + "/"

        console.log(string)

        axios.get(string).then(res => {
            const loggedUser = res.data;
            this.setState({ loggedUser });

            console.log(loggedUser)
        })

        console.log(this.state.loggedUser)
    }

    isAdmin()
    {
        if (this.state.loggedUser["userType"] === "Admin")
        {
            return <CreateWorker />
        }
    }


    render() {
        const { isLoading, users, error } = this.state;

        // const meh = getUser(this.state.loggedUser)
        

        return (
            <div className="dashboard">
                <p>Welcome to the User Dashboard {this.state.loggedUser["name"]}</p>

                {/*this.state.loggedUser.map(user => <p>{user.name}</p>)*/} 

                <br/>


                { this.isAdmin() }
                
            </div>
        )
    }
}

export default Dashboard;



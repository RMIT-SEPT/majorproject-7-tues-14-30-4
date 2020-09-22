import React, { Component } from 'react'
import axios from "axios";
import AddUser from './User/AddUser'
import UserProfile from '../Tools/UserProfile';
import {getUserName} from '../Tools/tools_helper'

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


    render() {
        const { isLoading, users, error } = this.state;
        return (
            <div className="dashboard">
                <p>Welcome to the User Dashboard {this.state.loggedUser["name"]}</p>

                {/*this.state.loggedUser.map(user => <p>{user.name}</p>)*/} 

                <br/>


                <p>Eventually only admins will be able to see the following</p>
                <p className="addUserButton" onClick={hide}>Click here to add a user</p>

                <div className="formBox" style={ { display: "none" }}>
                    <AddUser/>
                </div>
            </div>
        )
    }
}

export default Dashboard;

// Hidden Form Script
function hide() {
    // var x = document.getElementsByClassName("formBox");
    var x = document.getElementsByClassName("formBox")[0];

    if (x.style.display === "none") 
    {
        x.style.display = "block";
        console.log("Form shown")
    } 
    else 
    {
        x.style.display = "none";
        console.log("Form hidden")

    }
}

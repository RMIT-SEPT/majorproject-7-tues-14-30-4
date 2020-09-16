import React, { Component } from 'react'
import AddUser from './User/AddUser'
import UserProfile from '../Tools/UserProfile';

// import {createUser, UserProfiles} from '../actions/personActions'
 
// import CreatePersonButton from './Persons/CreatePersonButton';

class Dashboard extends Component {
    render() {
        return (
            <div className="dashboard">
                <p>Welcome to the User Dashboard {UserProfile.getName()}!</p>

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

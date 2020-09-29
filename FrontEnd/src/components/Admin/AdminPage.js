import React, { Component } from 'react'
import axios from "axios";
import AddUser from '../User/AddUser'
import {link, Link} from "react-router-dom";
import UserProfile from '../../actions/personActions';
import {getUser} from '../../Tools/tools_helper'


class AdminPage extends Component {

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
        return (
            <div>
                <p>Welcome to the Admin Dashboard {this.state.loggedUser["name"]}</p>
                <p className="addUserButton" onClick={hide}>Click here to add a user</p>

                <div className="formBox" style={ { display: "none" }}>
                    <AddUser/>
                </div>
            </div>
        )
    }
}

export default AdminPage;

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
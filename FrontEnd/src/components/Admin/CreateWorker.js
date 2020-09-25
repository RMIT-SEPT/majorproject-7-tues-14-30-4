import React, { Component } from 'react'
import axios from "axios";
import AddUser from '../User/AddUser'
import {link, Link} from "react-router-dom";
import UserProfile from '../../actions/personActions';
import {getUser} from '../../Tools/tools_helper'


class CreateWorker extends Component {

    render() {
        return (
            <div>
                <p className="addUserButton" onClick={hide}>Click here to add a user</p>

                <div className="formBox" style={ { display: "none" }}>
                    <AddUser/>
                </div>
            </div>
        )
    }
}

export default CreateWorker;

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
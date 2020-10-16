import React, { Component } from 'react'
import axios from "axios";
import AddUser from './User/AddUser'
import UserProfile from '../Tools/UserProfile';
import {getUser} from '../Tools/tools_helper'
import AdminPage from './Admin/AdminPage'
import CustomerDashboard from './Customer/CustomerDashboard';
import WorkerDashboard from './Worker/WorkerDashboard';
import { Redirect } from 'react-router';
import {Link} from "react-router-dom";



class Dashboard extends Component {

    constructor() {
        super();
        this.state = {
            loggedUser: {}
        };
    }

    componentDidMount() {
        if (localStorage.getItem("LoggedUser")){
            const string =  "http://localhost:8080/api/user/id/" + localStorage.getItem("LoggedUser") + "/"

            console.log(string)

            axios.get(string).then(res => {
                const loggedUser = res.data;
                this.setState({ loggedUser });

                console.log(loggedUser)
            })

            console.log(this.state.loggedUser)
        }   
    }

    whatType()
    {
        if (this.state.loggedUser["userType"] === "Admin")
        {
            return (
                <div>
                    <AdminPage />
                    <p className="addUserButton" onClick={this.logout}>Click here to logout</p>
                </div>
            )
        }
        else if (this.state.loggedUser["userType"] === "Worker")
        {
            return (
                <div>
                    <WorkerDashboard />
                    <p className="addUserButton" onClick={this.logout}>Click here to logout</p>
                </div>
            )
        }
        else if (this.state.loggedUser["userType"] === "Customer")
        {
            return (
                <div>
                    <CustomerDashboard />
                    <Link 
                        to="/"
                        onClick={this.logout}
                        className="logoutButton">
                            Logout
                    </Link>
                    {/*<p className="addUserButton" onClick={this.logout}>Click here to logout</p>*/}
                </div>
            )
        }
        else 
        {
            return <p>Please Sign in to view this page</p>
        }
    }

    logout()
    {

        if(localStorage.getItem("LoggedUser"))
        {
        localStorage.removeItem("LoggedUser");
        return <Redirect to="/" push/>
        }
    }


    render() {
        return (
            <div className="dashboard">

                { this.whatType() }
                
            </div>
        )
    }
}

export default Dashboard;



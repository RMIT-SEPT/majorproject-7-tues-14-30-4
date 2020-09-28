import React, { Component } from 'react'
import axios from "axios";
import AddUser from './User/AddUser'
import UserProfile from '../Tools/UserProfile';
import {getUser} from '../Tools/tools_helper'
import AdminPage from './Admin/AdminPage'
import CustomerDashboard from './Customer/CustomerDashboard';
import WorkerDashboard from './Worker/WorkerDashboard';


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

    whatType()
    {
        if (this.state.loggedUser["userType"] === "Admin")
        {
            return <AdminPage />
        }
        else if (this.state.loggedUser["userType"] === "Worker")
        {
            return <WorkerDashboard />
        }
        else if (this.state.loggedUser["userType"] === "Customer")
        {
            return <CustomerDashboard />
        }
        else 
        {
            return <p>Please Sign in to view this page</p>
        }
    }


    render() {
        const { isLoading, users, error } = this.state;

        // const meh = getUser(this.state.loggedUser)
        

        return (
            <div className="dashboard">
                {/*
                    <p>Welcome to the User Dashboard {this.state.loggedUser["name"]}</p>

                this.state.loggedUser.map(user => <p>{user.name}</p>)

                <br/>
                */} 


                { this.whatType() }
                
            </div>
        )
    }
}

export default Dashboard;



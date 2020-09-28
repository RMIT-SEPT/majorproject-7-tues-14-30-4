import React, { Component } from 'react'
import UserProfile from '../../Tools/UserProfile';
import axios from "axios";

class WorkerDashboard extends Component {
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
                <p>Welcome to the Worker Dashboard {this.state.loggedUser["name"]}</p>
            </div>
        );
    }
}

export default WorkerDashboard;
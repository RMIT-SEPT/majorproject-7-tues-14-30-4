import React, { Component } from 'react'
import axios from "axios";

class WorkerDashboard extends Component {
    constructor() {
        super();
        this.state = {
            loggedUser: {},
            allBookings: {}
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

        const all = "http://localhost:8080/api/booking/allBookings"


        axios.get(all).then(res => {
            const allBookings = res.data;
            this.setState({ allBookings });
        })

        console.log(this.state.allBookings)
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
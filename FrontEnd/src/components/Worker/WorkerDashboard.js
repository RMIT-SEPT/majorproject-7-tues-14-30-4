import React, { Component } from 'react'
import UserProfile from '../../Tools/UserProfile';
import axios from "axios";

class WorkerDashboard extends Component {
    constructor() {
        super();
        this.state = {
            loggedUser: {},
            bookingsMade: []
        };
    }

    componentDidMount() {
        const getUserString =  "http://localhost:8080/api/user/id/" + localStorage.getItem("LoggedUser")+ "/"


        axios.get(getUserString).then(res => {
            const loggedUser = res.data;
            this.setState({ loggedUser });
        })

        const getBookingString = "http://localhost:8080/api/booking/unavailableBookings/workerIdentifier/" + localStorage.getItem("LoggedUser")

        console.log(getBookingString)

        axios.get(getBookingString).then(res => {
            const bookingsMade = res.data;
            this.setState({ bookingsMade });
        })
    }

    getBookings()
    {
        if(this.state.bookingsMade.length > 0)
        {   
            return (
                <div style={{textAlign: "center"}}>
                    <p>These are the services you are currently rostered to work</p>
                    <div className="bookings">
                        { this.state.bookingsMade.map(booking => 
                            <div className="booking">
                                <p>Service: {booking.serviceName}</p>
                                {console.log(booking.dateAndTime)}
                                <p>Date: {new Date(booking.dateAndTime).toLocaleDateString()}</p>
                                <p>Time: {booking.dateAndTime}</p>
                                <p>With: {booking.customerUserIdentifier}</p>
                            </div>
                            )}
                    </div>
                </div>
            )
        }
    }



    render() {
        return (
            <div>
                <p>Welcome to the Worker Dashboard {this.state.loggedUser["name"]}</p>

                {(this.state.bookingsMade.length > 0) ? this.getBookings() : <p>You are not currently rostered to work at the moment or a customer has not booked a service with you</p>}
            </div>
        );
    }
}

export default WorkerDashboard;
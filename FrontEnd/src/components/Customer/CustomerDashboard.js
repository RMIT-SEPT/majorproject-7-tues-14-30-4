import React, { Component } from 'react'
import UserProfile from '../../Tools/UserProfile';
import axios from "axios";

class CustomerDashboard extends Component {
    constructor() {
        super();
        this.state = {
            loggedUser: {},
            bookingsMade: []
        };
    }

    componentDidMount() {
        const getUserString =  "http://localhost:8080/api/user/id/" + localStorage.getItem("LoggedUser").toUpperCase() + "/"


        axios.get(getUserString).then(res => {
            const loggedUser = res.data;
            this.setState({ loggedUser });
        })

        const getBookingString = "http://localhost:8080/api/booking/unavailableBookings/customerIdentifier/" + localStorage.getItem("LoggedUser").toUpperCase()

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
            // var i;
            // for(i = 0; i < this.state.bookingsMade.length; i++)
            // {
            //     console.log(this.state.bookingsMade[i]["serviceName"])
            // }

            // console.log(typeof this.state.bookingsMade[0].dateAndTime)
            // var d = new Date(this.state.bookingsMade[0].dateAndTime)
            // console.log(d.getDay())
            
            
            return (
                <div>
                    <p>These are the services you are currently booked in for</p>
                    <div className="bookings">
                        { this.state.bookingsMade.map(booking => 
                            <div className="booking">
                                <p>Service: {booking.serviceName}</p>
                                <p>Time: {Date(booking.dateAndTime)}</p>
                                <p>With: {booking.workerUserIdentifier}</p>
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
                <p>Welcome to the Customer Dashboard {this.state.loggedUser["name"]}</p>

                {(this.state.bookingsMade.length > 0) ? this.getBookings() : <p>You are not currently booked in for any services at the moment</p>}
            </div>
        );
    }
}

export default CustomerDashboard;
import React, { Component } from 'react'
import axios from "axios";
 
// import CreatePersonButton from './Persons/CreatePersonButton';

class BookingListing extends Component {

    constructor() {
        super();
        this.state = {
            bookingsMade: []
        };
        
    }

    componentDidMount() {
        const string = "http://localhost:8080/api/booking/unavailableBookings/customerIdentifier/" + this.props.match.params['id']

        axios.get(string).then(res => {
            const bookingsMade = res.data;
            this.setState({ bookingsMade });
        })
    }
    
    render() {
        const emptyBookingsMade = (this.state.bookingsMade.length === 0)
        return (
            <div className="bookingListing">
                <h4>Thank-you {this.props.match.params['id']}! Your booking is confirmed! </h4>
                <br></br>
                <p>All your bookings with AGME:</p>
                {emptyBookingsMade ? (<p> &nbsp;&nbsp;&nbsp; None at the moment... check out our Services page to book! </p>) : (<p></p>)}
                <ul>
                { this.state.bookingsMade.map(booking => 
                    <li> "{booking.serviceName}" service, with {booking.workerUserIdentifier} on {booking.dateAndTime} </li>)}
                </ul>
                <br></br>
                </div> 
        );

    }
}

export default BookingListing;
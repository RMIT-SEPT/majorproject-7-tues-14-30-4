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
        return (
            <div className="bookingListing">
                <h4>Thank-you {this.props.match.params['id']}! Your booking is confirmed! </h4>
                
                <p>All your bookings with AGME:</p>
                
                <ul>
                { this.state.bookingsMade.map(booking => 
                    <li> "{booking.serviceName}" service, with {booking.workerUserIdentifier} on {booking.dateAndTime} </li>)}
                </ul>
               
                </div> 
        );

    }
}

export default BookingListing;
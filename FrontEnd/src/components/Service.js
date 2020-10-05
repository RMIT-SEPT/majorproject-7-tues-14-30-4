import React, { Component } from 'react'
import axios from "axios";

class Service extends React.Component 
{
    constructor()
    {
        super();
        this.state = {
            service: [],
            workers: [],
            bookings: []
        };
        
    }

    componentDidMount() {
        const string = "http://localhost:8080/api/businessService/name/" + this.props.match.params['name']

        axios.get(string).then(res => {
            const service = res.data;
            this.setState({ service });
            console.log(service)
        })

        const url = "http://localhost:8080/api/worker/byCompanyName/" + this.props.match.params['name']

        axios.get(url).then(res => {
            const workers = res.data;
            this.setState({ workers });
            console.log(workers)
        })

        const bookingsURL = "http://localhost:8080/api/booking//availableBookings/serviceName/" + this.props.match.params['name']

        axios.get(bookingsURL).then(res => {
            const bookings = res.data;
            this.setState({ bookings });
        })

        console.log(string)
    }
    // Find service object based off passed id
    // Find each worker and list them with their rates, availability (days), etc



    render() {
        const emptyBookings = (this.state.bookings.length === 0)
        const emptyStaff = (this.state.workers.length === 0)
        return (
            <div className='services'>
            <h3>Welcome to the booking page for {this.state.service["name"]}</h3>
            <br></br>
            <p>The staff who work for this service are: </p>
            {emptyStaff ? (<p> &nbsp;&nbsp;&nbsp; Sorry, no workers are currently registered for this service. Please check back later.</p>) : (<p></p>)}
            <ul>
                { this.state.workers.map(worker => 
                    <li> {worker.name} </li>)}
            </ul>
            <br></br>
            <p>The available bookings are: </p>
            {emptyBookings ? (<p> &nbsp;&nbsp;&nbsp; Sorry, no bookings are currently available. Please check back later.</p>) : (<p></p>)}
            <ul>
                { this.state.bookings.map(booking => 
                    <li> <a href={"/booking/" + booking.id}> {booking.workerUserIdentifier}, available on {booking.dateAndTime}</a></li>)}
            </ul>
            <br></br>
            </div>
        );
    }
}

export default Service;
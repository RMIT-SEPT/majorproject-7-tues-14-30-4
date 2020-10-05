import React, { Component } from 'react'
import axios from "axios";
 
class Booking extends React.Component {

    constructor() {
        super();
        this.state = {
            booking: {},
            customerUserIdentifier: ""
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }
    
    onChange(e){
        this.setState({[e.target.name]: e.target.value});
    }

    onSubmit(e) {
        e.preventDefault();

        // update booking info
        axios.post("http://localhost:8080/api/booking/", { id: this.props.match.params['id'], 
        customerUserIdentifier: this.state.customerUserIdentifier, 
        workerUserIdentifier: this.state.booking["workerUserIdentifier"],
        serviceName: this.state.booking["serviceName"],
        dateAndTime: this.state.booking["dateAndTime"] })
          .then(res => {
            console.log(res);
            console.log(res.data);
          });
        
        // or should it redirect browser to homepage/dashboard of user?
        this.props.history.push(`/bookinglisting/${this.state.customerUserIdentifier}`);
    }

    componentDidMount() {
        const bookingURL = "http://localhost:8080/api/booking/id/" + this.props.match.params['id']

        axios.get(bookingURL).then(res => {
            const booking = res.data;
            this.setState({ booking });
        })

    }
    
    render() {
        return (
            <div className = "booking">
                <p>Booking completion form for the following:</p>
                <p>Appointment with "{this.state.booking["workerUserIdentifier"]}" for service "{this.state.booking["serviceName"]}" on {this.state.booking["dateAndTime"]}</p>
            
                <form onSubmit={this.onSubmit}>
                    <label>
                    Please enter your customer user identifier  
                    <input type="text" className="form-control form-control-lg " 
                    placeholder="User Name"
                    name="customerUserIdentifier"
                    value={this.state.customerUserIdentifier}
                    onChange={this.onChange} />
                    </label>
                    <button type="submit">Confirm</button>
                </form>
            </div>
        );

    }
}

export default Booking;
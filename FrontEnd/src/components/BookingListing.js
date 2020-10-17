import React, { Component } from 'react'
import axios from "axios";
 
// import CreatePersonButton from './Persons/CreatePersonButton';

class BookingListing extends Component {

    constructor() {
        super();
        this.state = {
            bookingsMade: [],
            serviceBooked: {},
            servicesByCategory: []
        };
        
    }

    componentDidMount() {
        if (localStorage.getItem("ServiceBooked")){
            
            const serviceURL =  "http://localhost:8080/api/businessService/name/" + localStorage.getItem("ServiceBooked")

            axios.get(serviceURL).then(res => {
                const serviceBooked = res.data;
                this.setState({ serviceBooked });

                const categoryURL = "http://localhost:8080/api/businessService/category/" + this.state.serviceBooked["category"]
                
                axios.get(categoryURL).then(res => {
                    const servicesByCategory = res.data;
                    this.setState({ servicesByCategory });

                    const servicesWithoutOne = [];
                    var serviceInList;
                    for (serviceInList of servicesByCategory) {
                        
                        if (serviceInList["name"] != localStorage.getItem("ServiceBooked")) {
                            servicesWithoutOne.push(serviceInList);
                          
                        }
                    }
                    this.setState({servicesByCategory: servicesWithoutOne});

                    const string = "http://localhost:8080/api/booking/unavailableBookings/customerIdentifier/" + this.props.match.params['id']

                    axios.get(string).then(res => {
                        const bookingsMade = res.data;
                        this.setState({ bookingsMade });
                    })
                })

                

            }) 
            
            
        }
        
        
    }
    
    render() {
        const emptyBookingsMade = (this.state.bookingsMade.length === 0)
        const emptyRecommendations = (this.state.servicesByCategory.length === 0)
        return (
            <div className="bookingListing">
                <h4><center>Thank-you {this.props.match.params['id']}! Your booking is confirmed! </center></h4>
                <br></br>
                
                <p>These are some of our other services in the same category that you may in interested in:</p>
                {emptyRecommendations ? (<p> &nbsp;&nbsp;&nbsp;Sorry, we have no other services in this category at the moment. Please check back later...</p>) : (<p></p>)}
                    <ul>
                        { this.state.servicesByCategory.map(service => 
                            <li> <a href={"/service/" + service.name}> "{service.name}" service, category {service.category} </a> </li>)}
                    </ul>
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
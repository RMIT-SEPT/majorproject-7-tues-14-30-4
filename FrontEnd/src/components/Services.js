import React, { Component } from 'react'
import axios from "axios";
 
// import CreatePersonButton from './Persons/CreatePersonButton';

class Services extends Component {

    constructor() {
        super();
        this.state = {
            services: []
        };

        
    }


    componentDidMount() {
        axios.get("http://localhost:8080/api/businessService/all/").then(res => {
            const services = res.data;
            this.setState({ services });
            console.log(services)
        })

        
    }
    
    render() {
        const { isLoading, users, error } = this.state;
        return (
            <div className="services">
                <p>Our registered business services:</p>
                
                <ul>
                { this.state.services.map(service => 
                    <li> {service.name} </li>)}
                </ul>
               
            </div>
        )
    }
}

export default Services;
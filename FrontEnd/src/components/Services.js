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
        const empty = (this.state.services.length === 0)
        return (
            
            <div className="services">
                <br></br>
                <p>Our registered business services:</p>
                
                {empty ? (<p> &nbsp;&nbsp;&nbsp; Sorry, no businesses are currently registered. Please check back later.</p>) : (<p></p>)}
                
                <ul>
                { this.state.services.map(service => 
                    <li> <a href={"/service/" + service.name}> {service.name} </a></li>)}
                </ul>
                <br></br>
            </div> 
        );

    }
}

export default Services;
import React, { Component } from 'react'
import axios from "axios";

class Services extends Component {

    constructor() {
        super();
        this.state = {
            services: []
        };

    }

    // api call to get all services in database
    componentDidMount() {
        axios.get("http://localhost:8080/api/businessService/all/").then(res => {
            const services = res.data;
            this.setState({ services });
            console.log(services)
        })
    }
    
    // list all services currently in system
    render() {
        const empty = (this.state.services.length === 0)
        return (
            
            <div className="services">
                <h3>Our registered business services:</h3>
                
                <div className="serviceList">
                    {empty ? (<p> &nbsp;&nbsp;&nbsp; Sorry, no businesses are currently registered. Please check back later.</p>) : (<p></p>)}
                    
                    { this.state.services.map(service => <p><a href={"/service/" + service.name} className="serviceText"> {service.name} </a></p>)}
                    <br/>
                </div>
                <br/>
                <br/>
            </div> 
        );

    }
}

export default Services;
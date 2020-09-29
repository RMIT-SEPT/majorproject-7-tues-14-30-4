import React, { Component } from 'react'
import axios from "axios";

class Service extends React.Component 
{
    constructor()
    {
        super();
        this.state = {
            service: []
            workers: []
        };
        
    }

    componentDidMount() {
        const string = "http://localhost:8080/api/businessService/name/" + this.props.match.params['name']

        axios.get(string).then(res => {
            const service = res.data;
            this.setState({ service });
            console.log(service)
        })

        const string = "http://localhost:8080/api/user/company_id/" + this.props.match.params['name']

        axios.get(string).then(res => {
            const service = res.data;
            this.setState({ service });
            console.log(service)
        })

        console.log(string)
    }
    // Find service object based off passed id
    // Find each worker and list them with their rates, availability (days), etc



    render() {
        return (
            <div className='services'>
            <p>Hello {this.state.service["name"]}</p>
            </div>

        );
    }
}

export default Service;
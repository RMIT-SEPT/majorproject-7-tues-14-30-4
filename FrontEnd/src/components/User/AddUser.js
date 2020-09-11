import React, { Component } from 'react'
import {createUser, UserProfiles} from '../../actions/personActions'

class AddUser extends Component {
    constructor(){
        super();

        this.state= {
        name: "",
        password: "",
        phone: "",
        user_type: "",
        // address: "",
        userIdentifier: "",
    }; 
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    
        }

    onChange(e){
        this.setState({[e.target.name]: e.target.value});
    }
    onSubmit(e){
        e.preventDefault();
        const newUser = {
            name: this.state.name,
            phone: this.state.phone,
            password: this.state.password,
            userType: this.state.userType,
            // address: this.state.address,
            userIdentifier: this.state.userIdentifier,  
        }

        console.log(newUser);

        createUser(newUser);

        console.log(UserProfiles(newUser['userIdentifier']));
        // UserProfiles(1);
    }

    render() {
        return (
            <form onSubmit={this.onSubmit}>
                <h4>Name</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="Name"
                    name="name"
                    value= {this.state.name}
                    onChange = {this.onChange}
                        />
                </div>


                <h4>Password</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="Password"
                    name="password"
                    value= {this.state.password}
                    onChange = {this.onChange}
                        />
                </div>


                <h4>Phone Number</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="Phone Number"
                    name="phone"
                    value= {this.state.phone}
                    onChange = {this.onChange}
                        />
                </div>
                {/*
                <h4>Address</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="Address"
                    name="address"
                    value= {this.state.address}
                    onChange = {this.onChange}
                        />
                </div>
                */}

                <h4>User Type</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="User Type"
                    name="userType"
                    value= {this.state.userType}
                    onChange = {this.onChange}
                        />
                </div>

                <h4>User Identifier</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="User Identifier"
                    name="userIdentifier"
                    value= {this.state.userIdentifier}
                    onChange = {this.onChange}
                        />
                </div>

                <br/>
                <input type="submit" className="Form Submit" />
            </form>
        )
    }
}
export default AddUser;
import React, { Component } from 'react'
import {createUser} from '../../actions/personActions'
import { withRouter } from 'react-router-dom';

import UserProfile from '../../Tools/UserProfile';




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

        // UserProfiles(newUser['userIdentifier']);

        // UserProfile.setName(newUser["name"]);
        // console.log(UserProfile.getName());

        this.props.history.push(`/dashboard/${newUser["userIdentifier"]}`);
        // window.location.reload();
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
                <p>
                    <input type="submit" className="mainbutton" />
                </p>
            </form>
        )
    }
}
export default withRouter(AddUser);
// export default AddUser;
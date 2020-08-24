import React, { Component } from 'react'

class AddUser extends Component {
    constructor(){
        super();

        this.state= {
        id: "",
        firstName: "",
        lastName: "",
        password: "",
        userType: "",
        phone: ""
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
            id: this.state.id,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            password:this.state.password,
            userType: this.state.userType,
            phone: this.state.phone    
        }

        console.log(newUser);
    }

    render() {
        return (
            <form onSubmit={this.onSubmit}>
                <h4>User ID</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="User ID" 
                    name="id"
                    value= {this.state.id}
                    onChange = {this.onChange}
                    />    
                </div>

                <h4>First Name</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="First Name"
                    name="firstName"
                    value= {this.state.firstName}
                    onChange = {this.onChange}
                        />
                </div>
                
                <h4>Last Name</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="Last Name"
                    name="lastName"
                    value= {this.state.lastName}
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

                <h4>User Type</h4>
                <div className="form">
                    <input type="text" className="form-input" 
                    placeholder="User Type"
                    name="userType"
                    value= {this.state.userType}
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

                <input type="submit" className="Form Submit" />
            </form>
        )
    }
}
export default AddUser;
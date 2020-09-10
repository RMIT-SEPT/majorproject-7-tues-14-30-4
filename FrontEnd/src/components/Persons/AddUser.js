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
    this.onChange = this.onChange.bind(this); // allows you to change value of each field
    this.onSubmit = this.onSubmit.bind(this);
    
        }

    onChange(e){
        this.setState({[e.target.name]: e.target.value}); // applies to all fields, not just name text field
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
            <div className="User">
            <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <h5 className="display-4 text-center">Create Account</h5>
                        <hr />
                        <form onSubmit={this.onSubmit} method="POST">
                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg " 
                                placeholder="User ID" 
                                name="id"
                                value= {this.state.id}
                                onChange = {this.onChange}
                                />    
                                
                            </div>
                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg" 
                                placeholder="First Name"
                                name="firstName"
                                value= {this.state.firstName}
                                onChange = {this.onChange}
                                />
                            </div>
                          
                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg " 
                                placeholder="Last Name"
                                name="lastName"
                                value= {this.state.lastName}
                                onChange = {this.onChange}
                                />  
                            </div>


                            <div className="form-group">
                            <input type="text" className="form-control form-control-lg " 
                                placeholder="Password"
                                name="password"
                                value= {this.state.password}
                                onChange = {this.onChange}
                                />
                            </div>


                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg " 
                                placeholder="User Type"
                                name="userType"
                                value= {this.state.userType}
                                onChange = {this.onChange}
                                /> 
                            </div>

                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg " 
                                placeholder="Phone Number"
                                name="phone"
                                value= {this.state.phone}
                                onChange = {this.onChange}
                                />
                            </div>
    
                            <input type="submit" className="btn btn-primary btn-block mt-4" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        )
    }
}
export default AddUser;
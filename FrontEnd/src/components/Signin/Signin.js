import React, { Component } from 'react'
import {link, Link} from "react-router-dom";

class Signin extends Component {
    constructor(){
      super();

      this.state= {
        id: "",
        password: "",
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
            password: this.state.password,  
        }

        console.log(newUser);
        this.props.history.push('/dashboard');
    }


  render() {
    return (
      <div>
        <div className = "formBox">
          <form onSubmit={this.onSubmit}>
            <h4>Username</h4>
            <div className="form">
                <input type="text" className="form-input" 
                placeholder="Username" 
                name="id"
                value= {this.state.id}
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
            <input type="submit" className="Form Submit" />
          </form>
          
          {/*
            <p>
              <Link to="/"
                className="navText">
                Home
              </Link>
            </p>
          */}
        </div>
      </div>
    )
  }
}
export default Signin;
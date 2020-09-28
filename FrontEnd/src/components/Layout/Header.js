import React, { Component } from 'react'
import {link, Link} from "react-router-dom";
import UserProfile from '../../Tools/UserProfile';
import isLoggedIn from '../../Tools/tools_helper';


class Header extends React.Component 
{
   
    constructor()
    {
        super();
        this.state = {
            signedIn: false,
            userID: ""
        }

    }
    LoggedIn()
    {
        if (localStorage.getItem("LoggedUser"))
        {
            this.state.signedIn = true;
            this.set.userID = localStorage.getItem("LoggedUser")

            return true;
        }
        return false;
    }
    render() {
        return (
            <div>
                <h1 className = "title">AGME's Online Appointment Booking System</h1>
                {/* <p>{this.state.signedIn}</p> */}
                
                <nav className="navBar">
                    <div className="container">
                        <div className="navBox">
                            <p>
                                <Link to="/"
                                className="navText">
                                Home
                                </Link>
                            </p>
                            <p>
                                <Link to="/services"
                                className="navText">
                                Services
                                </Link>
                            </p>

                            {isLoggedIn
                                ? <p> <Link to="/login" className="navText"> Sign In </Link> </p>
                                : <p> <Link to="/logout" className="navText"> Sign out </Link> </p>
                            }
                        </div>
                    </div>
                </nav>
            </div>
        );
    }
}


export default Header;
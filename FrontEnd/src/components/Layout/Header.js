import React, { Component } from 'react'
import {link, Link} from "react-router-dom";
import UserProfile from '../../Tools/UserProfile';
import isLoggedIn from '../../Tools/tools_helper';


class Header extends React.Component 
{
   
    constructor(props)
    {
        super();
        this.state = {
            signedIn: false
        }

    }
    checkIfLoggedIn()
    {
        if (UserProfile.getName() != "")
        {
            this.state.signedIn = true;
        }
    }
    render() {
        return (
            <div>
                <h1 className = "title">The Application</h1>
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

                            {isLoggedIn()}

                            {/*
                            <p>
                                <Link to="/signin"
                                className="navText">
                                Signin
                                </Link>
                            </p>
                            

                             <p>
                                <Link to="/logout"
                                className="navText">
                                Logout
                                </Link>
                            </p>
                            */}
                        </div>
                        {/*<div className="navBox">
                            <p>
                                <Link to="/dashboard"
                                className="navText">
                                Dashboard
                                </Link>
                            </p>
                        </div>
                        */} 
                    </div>
                </nav>
            </div>
        );
    }
}


export default Header;
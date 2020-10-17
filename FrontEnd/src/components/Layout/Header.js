import React from 'react'
import {Link} from "react-router-dom";
import isLoggedIn from '../../Tools/tools_helper';

import logo from '../../Images/AGME.png'


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
                <div className = "logo">
                    <img src={logo} alt="Logo" />
                </div>
                
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
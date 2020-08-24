import React, { Component } from 'react'
import {link, Link} from "react-router-dom";


class Header extends React.Component 
{
    render() {
        return (
            <div>
                <h1 className = "title">The Application</h1>
                
                <nav className="navBar">
                    <div className="container">
                        <div className="navBox">
                            <p>
                                <Link to="/"
                                className="navText">
                                Home
                                </Link>
                            </p>
                        </div>
                        <div className="navBox">
                            <p>
                                <Link to="/dashboard"
                                className="navText">
                                Dashboard
                                </Link>
                            </p>
                        </div>
                    </div>
                </nav>
            </div>
        );
    }
}

export default Header;
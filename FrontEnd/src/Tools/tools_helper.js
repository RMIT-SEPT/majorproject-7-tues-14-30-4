import React, { Component } from 'react'
import {link, Link} from "react-router-dom";
import {UserProfile} from './UserProfile';

function isLoggedIn()
{
  console.log(UserProfile.getID())
  if (UserProfile.getName() != "") {
    return (
      <p>
        <Link to="/logout" className="navText">
          Logout
        </Link>
      </p>
    );
  } else {
    return (
      <p>
        <Link to="/signin" className="navText">
          Signin
        </Link>
      </p>
    );
  }
}

export default isLoggedIn;
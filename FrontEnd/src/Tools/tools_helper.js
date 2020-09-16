import React, { Component } from 'react'
import {link, Link} from "react-router-dom";
import UserProfile from '../Tools/UserProfile';

// UserProfile.getName();

function isLoggedIn()
{
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

// function isLoggedIn()
// {
//   console.log(UserProfile)
// }

export default isLoggedIn;
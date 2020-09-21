import React, { Component } from 'react'
import {link, Link} from "react-router-dom";
import UserProfile from '../Tools/UserProfile';
import axios from "axios";

function isLoggedIn()
{
  console.log("Checking if user is logged in")
  // UserProfile.setID("owqnfc")
  console.log(UserProfile.getID())
  if (UserProfile.getID() !== "") {
    console.log("Logged in")
    return (
      <p>
        <Link to="/logout" className="navText">
          Logout
        </Link>
      </p>
    );
  } else {
    console.log("Not logged in")
    return (
      <p>
        <Link to="/login" className="navText">
          Login
        </Link>
      </p>
    );
  }
}

function get10Services()
{
  const string = "http://localhost:8080/api/all";

    axios.get(string).then(res => {
    const data = res.data;
    })
  }

// function isLoggedIn()
// {
//   console.log(UserProfile)
// }


const funcs = {
  isLoggedIn() {},
  get10Services() {}
}

export default funcs;
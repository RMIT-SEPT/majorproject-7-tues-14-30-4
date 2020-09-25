import React, { Component } from 'react'
import {link, Link} from "react-router-dom";
import UserProfile from '../Tools/UserProfile';
import axios from "axios";

function isLoggedInDisplay()
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



export function getUser(id)
{
  console.log(id)
  const string = "http://localhost:8080/api/user/id/" + id.toUpperCase();

  let recievedData

  let promise = axios.get(string).then(recievedData => recievedData.data)

  // console.log(recievedData["data"])

  return recievedData["data"]
}


const funcs = {
  getUser(id) {}
}

export default funcs;
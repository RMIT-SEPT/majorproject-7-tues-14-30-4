import axios from "axios";
import { getUser } from "../Tools/tools_helper"

export function createUser(user)
{
    axios.post("http://localhost:8080/api/user", user)
      .then(function (response) {
        console.log("fine")
        // console.log(response);
      })
      .catch(function (error) {
        console.log("not fine")
        // console.log(error);
      });
}

export function createCustomer(user)
{
    axios.post("http://localhost:8080/api/customer", user)
    .then(function (response) {
      console.log("Customer fine")
      // console.log(response);
    })
    .catch(function (error) {
      console.log("Customer not fine")
      // console.log(error);
    });

    localStorage.setItem("LoggedUser", user["id"])
}

export function createWorker(user)
{
    axios.post("http://localhost:8080/api/worker", user)
    .then(function (response) {
      console.log("Worker fine")
      // console.log(response);
    })
    .catch(function (error) {
      console.log("Worker not fine")
      // console.log(error);
    });
}

export function deleteUser(id)
{
  //Check if logged in user is an admin
  if(localStorage.getItem("LoggedUser"))
  {

    // let loggedUser = getUser(id.toUpperCase())

    const string =  "http://localhost:8080/api/user/id/" + id + "/"

    console.log(string)

    axios.delete(string);

    console.log("User deleted")

    return "User Deleted"
  }
    
  else
  {
    console.log("User not logged in")
    return "User not logged in"
  }
}

export function createBooking(booking)
{
  axios.post("http://localhost:8080/api/booking", booking)
    .then(function (response) {
      console.log("Booking fine")
      // console.log(response);
    })
    .catch(function (error) {
      console.log("Booking not fine")
      // console.log(error);
    });
}

const funcs = {
  createUser() {},
  createCustomer() {},
  createWorker() {},
  deleteUser(){},
  createBooking(){}
}

export default funcs;

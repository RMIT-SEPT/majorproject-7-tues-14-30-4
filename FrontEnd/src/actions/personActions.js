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
    axios.post("http://localhost:8080/api/user", user)
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

export function deleteUser(id)
{
  //Check if logged in user is an admin
  if(localStorage.getItem("LoggedUser"))
  {

    let loggedUser = getUser(localStorage.getItem("LoggedUser").toUpperCase())

    console.log(loggedUser)
  }
    
  else
  {
    return "User not logged in"
  }

    // const string =  "http://localhost:8080/api/user/id/" + id + "/"

    // console.log(string)

    // axios.delete(string);

    // console.log("User deleted")

    return "User deleted"
}

const funcs = {
  createUser() {},
  createCustomer() {},
  deleteUser(){}
}

export default funcs;

import axios from "axios";
import { GET_ERRORS } from "./types";

// const createUser = (user, history) => async dispatch => {
//     console.log("Adding user!")
//     try {
//         const res = await axios.post("http://localhost:8080/api/user", user);
//         history.push("/dashboard");
//     } catch (err) {
//         dispatch({
//             type: GET_ERRORS,
//             payload: err.response.data
//         });
//         console.log("fghf")
//     }
// };

export function createUser(user)
{
    axios.post("http://localhost:8080/api/user", user)
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
}

export function UserProfiles(id)
{
  const string = "http://localhost:8080/api/user/id/" + id.toUpperCase();

  axios.get(string).then(res => {
  const data = res.data;
  })
}

const funcs = {
  UserProfiles() {},
  createUser() {}
}

export default funcs;

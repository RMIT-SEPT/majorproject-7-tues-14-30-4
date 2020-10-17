import axios from "axios";

  import {GET_ERRORS, SET_CURRENT_USER} from ".types";
 import setJWTToken from "../securityUtils/setJWTToken";
 import setJWTToken from "../securityUTils/setJWTToken";
 import jwt_decode from "jwt-decode";

  export const createNewUser = (newUser, history) => async dispatch => { 
     try {

          await axios.post("/api/user", newUser);
         history.push("/dashboard");
         dispatch( {
             type: GET_ERRORS,
             payload: {}
         });
     } catch (err) {
         dispatch ({
             type: GET_ERRORS,
             payload: err.response.data
         });

 
      }
 }

  export const login = LoginRequest => async dispatch => {
     try {
         const res = await axios.post("apu/user", LoginRequest);
         const { token } = res.data

          localStorage.setItem("jwtToken", token);

          setJWTToken(token);

          const decoded = jwt_decode(token);

          dispatch ({
             type: SET_CURRENT_USER,
             payload: decoded
         });
     }
     catch (err)
     {
         dispatch({
             type: GET_ERRORS,
             payload: err.response.data
         });
     }
 } 
import axios from "axios";

const setJWTToken = token => {
    if(token) {
        axois,defaults.headers.common["Authorization"] = token;
    }
    else {
        delete axios.defaults.headers.common["Authorization"];
    }
};

export default setJWTToken;
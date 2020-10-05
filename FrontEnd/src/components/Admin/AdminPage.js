import React, { Component } from 'react'
import axios from "axios";
import AddUser from '../User/AddUser'
import { deleteUser } from '../../actions/personActions';
import { withRouter } from 'react-router-dom';




class AdminPage extends Component {

    constructor() {
        super();
        this.state = {
            loggedUser: {},
            user_id_to_delete: "",
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    componentDidMount() {
        const string =  "http://localhost:8080/api/user/id/" + localStorage.getItem("LoggedUser").toUpperCase() + "/"

        console.log(string)

        axios.get(string).then(res => {
            const loggedUser = res.data;
            this.setState({ loggedUser });

            console.log(loggedUser)
        })

        console.log(this.state.loggedUser)
    }

    onChange(e){
        this.setState({[e.target.name]: e.target.value});
    }
    onSubmit(e){
        e.preventDefault();
        const deletingUser = {
            user_id_to_delete: this.state.user_id_to_delete,
        }

        // console.log(deleteUser);

        deleteUser(deletingUser['user_id_to_delete']);


        this.props.history.push('/dashboard/true');
    }

    wasDeleteSuccessful()
    {
        console.log(this.props.match.params['delete_success'])

        const delete_success = this.props.match.params['delete_success']

        if(delete_success)
        {
            console.log("wasDeleteSuccessful")
            return <p>User Deleted</p>
        }
    }


    render() {
        const { parameter1 } = this.props.match.params;
        return (
            <div>
                <p>Welcome to the Admin Dashboard {this.state.loggedUser["name"]}</p>
                <p className="addUserButton" onClick={hide}>Click here to add a user</p>

                <div className="formBox" style={ { display: "none" }}>
                    <AddUser/>
                </div>

                <p>You can delete a worker here</p>
                {this.wasDeleteSuccessful()}
                <div>
                <form onSubmit={this.onSubmit}>
                    <h4>Worker Username to Delete</h4>
                    <div className="form">
                        <input type="text" className="form-input" 
                        placeholder="Username"
                        name="user_id_to_delete"
                        value= {this.state.user_id_to_delete}
                        onChange = {this.onChange}
                        />
                    </div>
                    <p>
                    <input type="submit" className="mainbutton" />
                    </p>
                </form>
                </div>
            </div>
        )
    }
}

export default withRouter(AdminPage);

// Hidden Form Script
function hide() {
    // var x = document.getElementsByClassName("formBox");
    var x = document.getElementsByClassName("formBox")[0];

    if (x.style.display === "none") 
    {
        x.style.display = "block";
        console.log("Form shown")
    } 
    else 
    {
        x.style.display = "none";
        console.log("Form hidden")

    }
}
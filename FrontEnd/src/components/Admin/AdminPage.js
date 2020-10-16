import React, { Component } from 'react'
import axios from "axios";
import AddUser from '../User/AddUser'
import { deleteUser, createBooking } from '../../actions/personActions';
import { withRouter } from 'react-router-dom';

class AdminPage extends Component {

    constructor() {
        super();
        this.state = {
            loggedUser: {},
            user_id_to_delete: "",

            workerUserIdentifier: "",
            serviceName: "",
            dateAndTime: null,

        };

        this.onChange = this.onChange.bind(this);
        this.onDeleteSubmit = this.onDeleteSubmit.bind(this);
        this.onBookingSubmit = this.onBookingSubmit.bind(this);
    }

    componentDidMount() {
        const string =  "http://localhost:8080/api/user/id/" + localStorage.getItem("LoggedUser") + "/"

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
    onDeleteSubmit(e){
        e.preventDefault();
        const deletingUser = {
            user_id_to_delete: this.state.user_id_to_delete,
        }

        // console.log(deleteUser);

        deleteUser(deletingUser['user_id_to_delete']);


        this.props.history.push('/dashboard');
    }

    onBookingSubmit(e){
        e.preventDefault();
        const newBooking = {
            workerUserIdentifier: this.state.workerUserIdentifier,
            serviceName: this.state.serviceName,
            dateAndTime: this.state.dateAndTime,
        }

        // console.log(deleteUser);

        createBooking(newBooking);


        this.props.history.push('/dashboard');
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

                
                <div className="outside">
                    <div className="inside">
                        <p>You can delete a worker here</p>

                        <form onSubmit={this.onDeleteSubmit}>
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

                    <div className="inside">
                        <p>You can create new bookings here</p>
                        <form onSubmit={this.onBookingSubmit}>
                            <h4>Worker Username</h4>
                            <div className="form">
                                <input type="text" className="form-input" 
                                placeholder="Username"
                                name="workerUserIdentifier"
                                value= {this.state.workerUserIdentifier}
                                onChange = {this.onChange}
                                />
                            </div>

                            <h4>Service Name</h4>
                            <div className="form">
                                <input type="text" className="form-input" 
                                placeholder="Service Name"
                                name="serviceName"
                                value= {this.state.serviceName}
                                onChange = {this.onChange}
                                />
                            </div>

                            <h4>Date and Time</h4>
                            <div className="form">
                                <input type="datetime-local" className="form-input" 
                                name="dateAndTime"
                                value= {this.state.dateAndTime}
                                onChange = {this.onChange}
                                />
                            </div>

                            <p>
                            <input type="submit" className="mainbutton" />
                            </p>
                        </form>
                    </div>
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
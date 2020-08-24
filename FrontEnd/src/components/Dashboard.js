import React, { Component } from 'react'
import AddUser from './User/AddUser'
// import Person from './Users/User'
// import CreatePersonButton from './Persons/CreatePersonButton';

class Dashboard extends Component {
    render() {
        return (
            <div>
                <div className = "formBox">
                    <AddUser />
                </div>
            </div>
        )
    }
}
export default Dashboard;


// <CreatePersonButton />

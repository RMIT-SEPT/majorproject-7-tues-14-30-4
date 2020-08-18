import React, { Component } from 'react'
import LeftColumn from './LeftColumn'
import RightColumn from './RightColumn'

class Body extends React.Component 
{
    render() {
        return (
            <div class='Body'>
            <LeftColumn/>
            <RightColumn/>
            </div>
        );
    }
}

export default Body;
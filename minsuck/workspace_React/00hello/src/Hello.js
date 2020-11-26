//react 안의 Component 를 가지고 오겠다는 것이다
import React, { Component } from 'react';
//var React = require('react');
//var Component = React.Component
var Component2 = React.Component;

class Hello extends Component{

    render(){
        return (

            <div>
            Hello, React!
            </div>

        )
    }

};

export default Hello;
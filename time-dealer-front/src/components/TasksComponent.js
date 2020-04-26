import React, {Component} from 'react';
import {get} from '../API';

class Tasks extends Component{

    constructor(props){
        super(props);

        this.state = {
            user: {}
        }
    }

    // for now, i wanna put to this props user with data - tasks (all about tasks) , username , user id mb idk ))) 
    // i mean this class will not make authorisation of user, only take params from request from back
    // no one class cant do it, only AuthComponent.js ...

    render(){
        return(
            <div></div>
            );
    }
}
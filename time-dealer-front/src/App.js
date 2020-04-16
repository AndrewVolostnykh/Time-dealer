import React, { useState, useEffect, Component} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";


const UserProfile = () => 
{
  fetch('http://localhost:8190/user/profile/1').then(data => console.log(data));
};



function App() {
  return (
    <div className="App">
      <UserProfile />
    </div>
  );
}

export default App;

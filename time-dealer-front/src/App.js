import React, { Component } from 'react';
import { Route, BrowserRouter as Router, Switch } from 'react-router-dom'
import UserProfile from './UserProfile';
import Home from './Home';

class App extends Component{
	state = {}

	render()  { 

		<Router>
			<Switch>
				<Route path='/' exact={true} component={Home}/>
				<Route path='/profile' exact={true} component={UserProfile}/>
			</Switch>
		</Router>
	}
}

export default App;
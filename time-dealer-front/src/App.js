import React, { Component } from 'react';
import { Route, BrowserRouter as Router, Switch } from 'react-router-dom'
import UserProfile from './UserProfile';
import Home from './Home';
import AppNav from "./AppNav";

class App extends Component {
	constructor(props) {
		super(props);

		this.state = {}
	}

	render() { 
		return (
			<div>
				<AppNav />
				<Router>
					<Switch>
						<Route path='/' exact={true} component={Home}/>
						<Route path='/profile/:profileId' exact={true} component={UserProfile}/>
					</Switch>
				</Router>
			</div>
		)
	}
}

export default App;
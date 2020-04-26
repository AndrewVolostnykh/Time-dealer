import React, { Component } from 'react';
import { Route, BrowserRouter as Router, Switch } from 'react-router-dom'
import Main from './components/MainComponent';

class App extends Component {
	constructor(props) {
		super(props);

		this.state = {}
	}

	render() { 
		return (
			<BrowserRouter>
				<div className="App">
					<Main />
				</div>
			</BrowserRouter>
		)
	}
}

export default App;
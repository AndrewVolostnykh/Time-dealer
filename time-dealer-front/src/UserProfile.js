import React, { Component } from 'react';
import AppNav from './AppNav';

class UserProfile extends Component {
	state = {
		isLoading : true,
		Profile : null
	}

	async componentDidMount(){
		const response = await fetch('/user/profile/1');
		const body = await response.json();
		this.setState({Profile : body, isLoading : false});
	}

	render() {

		const {Profile, isLoading} = this.state;

		if(isLoading){
			return (<div>Loading...</div>);
		}

		return (
			<div>
				<h2>Hello! {Profile.userName}</h2>
				{
						Profile.tasks.map( task => 
							<div id={task.id}> 
								<p>{task.summary}</p>
								<p>{task.acceptance_criteria}</p>
								<p>{task.status}</p>
								<br/><br/>
							</div>)
				}
			</div>
		);
	}
}

export default UserProfile;
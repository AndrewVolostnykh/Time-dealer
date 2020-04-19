import React, { Component } from 'react';
import API, { get } from "./API";
class UserProfile extends Component {
	constructor(props) {
		super(props);

		this.state = {
			isLoading : true,
			Profile : {}
		}
	}
	

	async componentDidMount(){
		const { profileId } = this.props.match.params;
		const response = await API.get(`/user/profile/${profileId}`);

		this.setState({Profile: { ...response.data }, isLoading : false});
	
	}

	render() {
		const {Profile, isLoading} = this.state;

		if(isLoading){
			return (<div>Loading...</div>);
		} else {
			return(
				<div>
					<h2>Hello! {Profile.userName}</h2>
					{
						Profile && Profile.tasks && Profile.tasks.map( task => 
							<div id={task.id}> 
								<p>{task.summary}</p>
								<p>{task.acceptance_criteria}</p>
								<p>{task.status}</p>
								<br/><br/>
							</div>
						)
					}
				</div>
			)
		}

	}
}

export default UserProfile;
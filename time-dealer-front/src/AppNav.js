import React, {Component} from 'react';
import { Nav,
 		 Navbar,
   		 NavItem,
  		 NavbarBrand,
  		 NavLink } from 'reactstrap';

class AppNav extends Component{
	state = {}

	render () {
		return (
			<div>
		      <Navbar color="dark" dark expand="md">
		        <NavbarBrand href="/">Time-dealer</NavbarBrand>
		          <Nav className="mr-auto" navbar>
		            <NavItem>
		              <NavLink href="/home/">Home</NavLink>
		            </NavItem>
		            <NavItem>
		              <NavLink href="/user/prfile">Profile</NavLink>
		            </NavItem>
		            <NavItem>
		              <NavLink href="/login">Login</NavLink>
		            </NavItem>
		          </Nav>
		      </Navbar>
		    </div>	
    	)
	}
}

export default AppNav;
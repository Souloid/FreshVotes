package com.freshvotes.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.freshvotes.domain.User;

public class CustomSecurityUser extends User implements UserDetails {
	
	
	private static final long serialVersionUID = 9079615471231942053L;

	public CustomSecurityUser () {}
	
	public CustomSecurityUser (User user) {
		//this.//set authorities
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}
	

	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		//ignoring this cause we're not implementing account status for now.
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//ignoring this cause we're not implementing account status for now.
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//ignoring this cause we're not implementing account status for now.
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		//ignoring this cause we're not implementing account status for now.
		// TODO Auto-generated method stub
		return true;
	}

}

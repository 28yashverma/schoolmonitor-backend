package com.schoolmonitor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	

	
	private CredentialsRepository credentials;
	@Autowired
	public CustomUserDetailsService(CredentialsRepository credentials) {
		this.credentials = credentials;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.credentials.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
	}
}
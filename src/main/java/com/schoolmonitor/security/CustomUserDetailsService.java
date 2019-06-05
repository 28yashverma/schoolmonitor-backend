package com.schoolmonitor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private CredentialsRepository credentials;

	public CustomUserDetailsService(CredentialsRepository credentials) {
		this.credentials = credentials;
	}
	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { UserDetails user=(UserDetails)
	 * this.credentials.findByUserName(username); if (null!=user) return user; else
	 * throw new UsernameNotFoundException("Username: " + username + " not found");
	 * }
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.credentials.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
	}
}
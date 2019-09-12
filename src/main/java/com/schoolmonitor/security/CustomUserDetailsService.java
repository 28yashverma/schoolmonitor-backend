package com.schoolmonitor.security;

import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.schoolmonitor.entities.schoolmonitor.Credential;
import com.schoolmonitor.model.CredentialDTO;
import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
	

	@Autowired
	private CredentialsRepository credentialsRepository;
	
	@Autowired
	private CredentialDTO credentialDTO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		BeanUtils.copyProperties(credentialsRepository.findByUserName(username),credentialDTO);
		return credentialDTO;
	}

	public CustomUserDetailsService() {
		super();
	}





	
}
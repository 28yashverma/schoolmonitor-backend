package com.schoolmonitor.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.schoolmonitor.entities.schoolmonitor.Credential;
import com.schoolmonitor.model.CredentialDTO;
import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;
import com.schoolmonitor.service.AuthService;
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

	@Autowired
	AuthService authService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credential credential = this.credentialsRepository.findByUserName(username);
		credentialDTO.setIsStudent(null != credential.getLinkedStudentId() ? true : false);
		List<String> roles = this.getUserRoles(credentialDTO);
        credentialDTO.setAuthorities(authService.getAuthorities(roles));
		BeanUtils.copyProperties(credentialsRepository.findByUserName(username),credentialDTO);
		return credentialDTO;
	}

	public List<String> getUserRoles(CredentialDTO credentialDTO) {

		List<String> roles = new ArrayList<String>();
		if (credentialDTO.isStudent())
			roles.add("Student User");
		else
			roles.add("Teacher User");
		if (credentialDTO.getIsAdmin() == 1)
			roles.add("Administrator");
		return roles;
	}
	
	public CustomUserDetailsService() {
		super();
	}





	
}
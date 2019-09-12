package com.schoolmonitor.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.schoolmonitor.entities.schoolmonitor.Credential;
import com.schoolmonitor.model.CredentialDTO;
import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;
import com.schoolmonitor.security.AuthenticationRequest;
import com.schoolmonitor.security.JwtTokenProvider;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Service
public class AuthServiceImpl  implements AuthService{
	@Autowired
	CredentialsRepository credentialsRepository;
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	@Autowired
	CredentialDTO credentialDTO;

	 public Collection<? extends GrantedAuthority> getAuthorities(Collection<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
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

	public Map<Object, Object> signin(@RequestBody AuthenticationRequest data, HttpServletRequest request) {
		Credential credential = this.credentialsRepository.findByUserNameAndPassword(data.getUsername(),
				data.getPassword());
		credentialDTO.setIsStudent(null != credential.getLinkedStudentId() ? true : false);
		List<String> roles = this.getUserRoles(credentialDTO);
        credentialDTO.setAuthorities(this.getAuthorities(roles));
		BeanUtils.copyProperties(credential, credentialDTO);

		UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(
				credentialDTO.getUsername(), credentialDTO.getPassword(), credentialDTO.getAuthorities());
		authtoken.setDetails(new WebAuthenticationDetails(request));

		String token = jwtTokenProvider.createToken(data.getUsername(), roles);

		Map<Object, Object> model = new HashMap<>();
		model.put("username", data.getUsername());
		model.put("token", token);
		return model;
	}

	

	
}

package com.schoolmonitor.security;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmonitor.entities.schoolmonitor.Credential;
import com.schoolmonitor.multitenacy.TenantContext;
import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	TenantContext tenantContext;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	CredentialsRepository users;

	private Collection<? extends GrantedAuthority> getAuthorities(Collection<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody AuthenticationRequest data, HttpServletRequest request) {

		try {
			tenantContext.setCurrentTenant(data.getDomain());
			Credential user = this.users.findByUserNameAndPassword(data.getUsername(), data.getPassword());
			List<String> roles = new ArrayList<String>();
			if (null != user.getStudent())
				roles.add("Student User");
			else
				roles.add("Teacher User");
			if (user.getIsAdmin() == 1)
				roles.add("Administrator");
			UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(data.getUsername(),
					data.getPassword(), getAuthorities(roles));

			authtoken.setDetails(new WebAuthenticationDetails(request));

			String token = jwtTokenProvider.createToken(data.getUsername(), roles);

			Map<Object, Object> model = new HashMap<>();
			model.put("username", data.getUsername());
			model.put("token", token);
			return ok(model);
		} catch (

		AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password supplied");
		}
	}
}

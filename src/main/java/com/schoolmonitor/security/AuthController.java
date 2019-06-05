package com.schoolmonitor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmonitor.entities.schoolmonitor.Credential;
import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	CredentialsRepository users;

	@PostMapping("/signin")
	public ResponseEntity signin(@RequestBody AuthenticationRequest data) {

		try {
			String username = data.getUsername();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
			Credential user = this.users.findByUserName(username)
					.orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
			List<String> roles = new ArrayList<String>();
			if (null != user.getStudent())
				roles.add("studentUser");
			roles.add("TeacherUser");
			if (1==user.getIsAdmin())
				roles.add("AdminUser");
			String token = jwtTokenProvider.createToken(username, roles);

			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("token", token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password supplied");
		}
	}
}

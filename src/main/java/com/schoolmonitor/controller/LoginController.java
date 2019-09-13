package com.schoolmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmonitor.security.AuthenticationRequest;
import com.schoolmonitor.service.LoginService;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
@RestController("/schoolmonitor")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/Login")
	public ResponseEntity<Boolean> Login(@RequestBody AuthenticationRequest credentials) {
		// return new ResponseEntity<Boolean>()(loginService.Login(credentials));
		return null;

	}

}

package com.schoolmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmonitor.entities.schools.School;
import com.schoolmonitor.entities.schools.Subscription;
import com.schoolmonitor.model.LoginCredentials;
import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;
import com.schoolmonitor.repositories.schools.SchoolRepository;
import com.schoolmonitor.repositories.schools.SubscriptionRepository;
import com.schoolmonitor.service.LoginService;

@RestController("/schoolmonitor")
public class LoginController {

	@Autowired
	LoginService loginService;
	@PostMapping("/Login")
	public ResponseEntity<Boolean> Login(@RequestBody LoginCredentials credentials){
		//return new ResponseEntity<Boolean>()(loginService.Login(credentials));
		return null;
		
		
	}

}

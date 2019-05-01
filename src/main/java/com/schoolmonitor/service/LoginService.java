package com.schoolmonitor.service;


import org.springframework.stereotype.Service;

import com.schoolmonitor.model.LoginCredentials;

@Service
public interface LoginService {
boolean Login(LoginCredentials credentials);
}

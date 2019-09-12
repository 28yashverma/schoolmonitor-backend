package com.schoolmonitor.service;


import org.springframework.stereotype.Service;

import com.schoolmonitor.security.AuthenticationRequest;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Service
public interface LoginService {
boolean Login(AuthenticationRequest credentials);
}

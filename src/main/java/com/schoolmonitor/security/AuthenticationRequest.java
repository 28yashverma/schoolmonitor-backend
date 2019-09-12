package com.schoolmonitor.security;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
public class AuthenticationRequest extends User implements Serializable {

	public String getDomain() {
		return domain;
	}
	private static final long serialVersionUID = 4583870654336178863L;
	private String domain;
	public AuthenticationRequest(String username, String password, Collection<? extends GrantedAuthority> authorities,String domain) {
		super(username, password, authorities);
		this.domain=domain;
	}

}

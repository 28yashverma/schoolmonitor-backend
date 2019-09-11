package com.schoolmonitor.model;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
public class LoginCredentials {

	
	public LoginCredentials() {
	}

	String domain;
	String password;
	String userName;
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

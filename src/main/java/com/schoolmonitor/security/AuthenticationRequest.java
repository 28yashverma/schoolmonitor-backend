package com.schoolmonitor.security;

import java.io.Serializable;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
	public class AuthenticationRequest implements Serializable {
	    public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public AuthenticationRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AuthenticationRequest(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		private static final long serialVersionUID = 1L;
		private String username;
	    private String password;
	    private String domain;
		public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
	
}

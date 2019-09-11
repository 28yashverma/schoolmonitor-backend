package com.schoolmonitor.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.schoolmonitor.security.JwtConfigurer;
import com.schoolmonitor.security.JwtTokenProvider;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.headers().frameOptions().disable().and()

				.httpBasic().disable()

				.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers("/auth/signin").permitAll().antMatchers("/").permitAll().and()
				.authorizeRequests().antMatchers("/console/**").permitAll()

				.antMatchers(HttpMethod.GET, "/schoolmonitor/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/schoolmonitor/**").permitAll()
				.antMatchers(HttpMethod.POST, "/schoolmonitor/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/schoolmonitor/**").permitAll().anyRequest().authenticated().and()
				.apply(new JwtConfigurer(jwtTokenProvider));
		// @formatter:on
		// verify configuration later on
	}
}

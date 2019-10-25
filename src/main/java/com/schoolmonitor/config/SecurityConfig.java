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

		http.headers().frameOptions().disable().and().httpBasic().disable().authorizeRequests()
				.antMatchers("/auth/signin", "/auth/signout").permitAll().antMatchers("/schoolmonitor/FeesManagment/**")
				.hasAuthority("Student User").antMatchers("/schoolmonitor/TeacherConsole/**")
				.hasAuthority("Teacher User").antMatchers("/schoolmonitor/AdminConsole/**")
				.hasAuthority("Administrator").antMatchers("/schoolmonitor/AttendanceManagment/**").permitAll()
				.antMatchers("/schoolmonitor/CourseManagment/**").permitAll()
				.antMatchers("/schoolmonitor/ResultManagment/**").hasAuthority("Student User").anyRequest()
				.authenticated().and().logout().logoutUrl("/auth/signout").invalidateHttpSession(true).and().formLogin()
				.loginPage("/auth/signin").and().apply(new JwtConfigurer(jwtTokenProvider));

	}
}

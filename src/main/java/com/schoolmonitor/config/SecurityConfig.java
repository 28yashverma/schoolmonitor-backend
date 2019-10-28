package com.schoolmonitor.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.schoolmonitor.security.JwtConfigurer;
import com.schoolmonitor.security.JwtTokenProvider;

/**
 * @author PrabhjeetS
 * @version 1.0
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://localhost:8088"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST","PUT","DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().configurationSource(corsConfigurationSource()).and().csrf().disable().headers().frameOptions()
				.disable().and().httpBasic().disable().authorizeRequests().antMatchers("/auth/**").permitAll()
				.antMatchers("/schoolmonitor/FeesManagment/**").hasAuthority("Student User")
				.antMatchers("/schoolmonitor/TeacherConsole/**").hasAuthority("Teacher User")
				.antMatchers("/schoolmonitor/AdminConsole/**").hasAuthority("Administrator")
				.antMatchers("/schoolmonitor/AttendanceManagment/**").permitAll()
				.antMatchers("/schoolmonitor/CourseManagment/**").permitAll()
				.antMatchers("/schoolmonitor/ResultManagment/**").hasAuthority("Student User").anyRequest()
				.authenticated().and().logout().logoutUrl("/auth/signout").invalidateHttpSession(true).and().formLogin()
				.loginPage("/auth/signin").and().apply(new JwtConfigurer(jwtTokenProvider));

	}
}

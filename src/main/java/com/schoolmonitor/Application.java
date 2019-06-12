package com.schoolmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan({ "com.schoolmonitor", "com.schoolmonitor.config", "com.schoolmontior.controller",
		"com.schoolmonitor.entities.schoolmonitor", "com.schoolmonitor.entities.schools", "com.schoolmonitor.exception",
		"com.schoolmonitor.model", "com.schoolmonitor.reports", "com.schoolmonitor.repositories.schoolmonitor",
		"com.schoolmonitor.repositories.schools", "com.schoolmonitor.security", "com.schoolmonitor.security" })
*/public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

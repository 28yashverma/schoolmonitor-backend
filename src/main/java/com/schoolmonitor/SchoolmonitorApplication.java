package com.schoolmonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.schoolmonitor.config.DatasourceConfig;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
@EnableJpaRepositories
@SpringBootApplication(exclude = { DatasourceConfig.class })
@EnableAutoConfiguration // for spring 2 explicit @EnableAutoConfiguration is needed
public class SchoolmonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmonitorApplication.class, args);
	}

}

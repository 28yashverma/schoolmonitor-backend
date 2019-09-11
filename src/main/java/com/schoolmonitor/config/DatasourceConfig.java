package com.schoolmonitor.config;


//import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Configuration
//@Import(SecurityConfig.class)
public class DatasourceConfig {

	/* @Bean
	    ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
	        registrationBean.addUrlMappings("/console/*");
	        return registrationBean;
	    }
	*/
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.schoolmonitor")
	public DataSourceProperties firstTenantDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.schoolmonitor.configuration")
	public HikariDataSource firstTenantDataSource() {
		return firstTenantDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.schoolmonitor2")
	public DataSourceProperties secondTenantDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.schoolmonitor2.configuration")
	public HikariDataSource secondTenantDataSource() {
		return secondTenantDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource.school")
	public DataSourceProperties catalogueDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.configuration")
	public HikariDataSource catalogueDataSource() {
		return catalogueDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

}

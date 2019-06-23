package com.schoolmonitor.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.schoolmonitor.config.*;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Import(SecurityConfig.class)
public class DatasourceConfig {

	

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.schoolmonitor")
	public DataSourceProperties firstDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.schoolmonitor.configuration")
	public HikariDataSource firstDataSource() {
		return firstDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean
	@ConfigurationProperties("app.datasource.school")
	public DataSourceProperties secondDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("app.datasource.school.configuration")
	public HikariDataSource secondDataSource() {
		return secondDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

}

package com.schoolmonitor.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatasourceConfig {
	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.primarydatasource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
}

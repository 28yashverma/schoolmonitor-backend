package com.schoolmonitor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.schoolmonitor.config.*;
@Configuration
@Import(SecurityConfig.class)
public class DatasourceConfig {
	/*@Bean
	@Primary
	@ConfigurationProperties("app.datasource.schoolmonitor")
	public DataSourceProperties firstDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.schoolmonitor.configuration")
	public HikariDataSource firstDataSource() {
		return firstDataSourceProperties().initializeDataSourceBuilder()
				.type(HikariDataSource.class).build();
	}

	@Bean
	@ConfigurationProperties("app.datasource.school")
	public DataSourceProperties secondDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("app.datasource.school.configuration")
	public DataSource secondDataSource() {
		return secondDataSourceProperties().initializeDataSourceBuilder()
				.type(DataSource.class).build();
	}*/
}

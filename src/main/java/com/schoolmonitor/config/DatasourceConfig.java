package com.schoolmonitor.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.schoolmonitor.config.*;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Import(SecurityConfig.class)
public class DatasourceConfig {

	/*
	 * In case of Using spring 2,either this additional configuration or
	 * explicit @EnableAutoConfiguration with JPA provider(Hibernate) dependency is
	 * needed
	 * 
	 * @Bean public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	 * //JpaVendorAdapteradapter can be autowired as well if it's configured in
	 * application properties. HibernateJpaVendorAdapter vendorAdapter = new
	 * HibernateJpaVendorAdapter(); vendorAdapter.setGenerateDdl(false);
	 * 
	 * LocalContainerEntityManagerFactoryBean factory = new
	 * LocalContainerEntityManagerFactoryBean();
	 * factory.setJpaVendorAdapter(vendorAdapter); //Add package to scan for
	 * entities. factory.setPackagesToScan("com.company.domain");
	 * factory.setDataSource(dataSource); return factory; }
	 * 
	 * @Bean public PlatformTransactionManager
	 * transactionManager(EntityManagerFactory entityManagerFactory) {
	 * JpaTransactionManager txManager = new JpaTransactionManager();
	 * txManager.setEntityManagerFactory(entityManagerFactory); return txManager; }
	 */

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

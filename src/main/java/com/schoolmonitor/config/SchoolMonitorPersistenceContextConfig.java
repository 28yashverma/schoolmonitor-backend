package com.schoolmonitor.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.schoolmonitor.repositories.BaseRepositoryImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(repositoryBaseClass=BaseRepositoryImpl.class,entityManagerFactoryRef = "schoolmonitorEntityManagerFactory", transactionManagerRef = "schoolmonitorTransactionManager", basePackages = {
		"com.schoolmonitor.repositories.schoolmonitor" })

public class SchoolMonitorPersistenceContextConfig {

	@Value("${spring.schoolmonitor.tenant1.datasource.username}")
	String dataUsername;
	@Value("${spring.schoolmonitor.tenant1.datasource.password}")
	String password;
	@Value("${spring.schoolmonitor.tenant1.datasource.url}")
	String url;
	@Value("${spring.schoolmonitor.tenant1.datasource.driver-class-name}")
	String driverClassName;

	@Bean(name = "schoolmonitorDataSource")
	@Primary
	public DataSource schoolmonitorDataSource() {

		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(driverClassName);
		dataSourceConfig.setJdbcUrl(url);
		dataSourceConfig.setUsername(dataUsername);
		dataSourceConfig.setPassword(password);

		return new HikariDataSource(dataSourceConfig);

	}

	@Primary
	@Bean(name = "schoolmonitorEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean schoolmonitorEntityManagerFactory(
			final @Qualifier("schoolmonitorDataSource") DataSource schoolmonitorDataSource, Environment environment) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect",
				environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		jpaProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		jpaProperties.put("hibernate.ejb.naming_strategy",
				environment.getRequiredProperty("spring.jpa.hibernate.naming.physical-strategy"));
		jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));

		factory.setJpaProperties(jpaProperties);
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.schoolmonitor.entities.schoolmonitor");
		factory.setDataSource(schoolmonitorDataSource);
		return factory;
	}

	@Primary
	@Bean(name = "schoolmonitorTransactionManager")
	public PlatformTransactionManager schoolmonitorTransactionManager(
			@Qualifier("schoolmonitorEntityManagerFactory") EntityManagerFactory schoolmonitorEntityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(schoolmonitorEntityManagerFactory);
		return txManager;
	}
}

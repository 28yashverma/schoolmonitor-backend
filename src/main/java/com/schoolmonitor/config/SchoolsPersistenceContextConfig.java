package com.schoolmonitor.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
@EnableJpaRepositories(repositoryBaseClass=BaseRepositoryImpl.class,entityManagerFactoryRef = "schoolsEntityManagerFactory", transactionManagerRef = "schoolsTransactionManager", basePackages = {
		"com.schoolmonitor.repositories.schools" })
public class SchoolsPersistenceContextConfig {

	@Value("${spring.shoolmonitor.datasource.username}")
	String dataUsername;
	@Value("${spring.shoolmonitor.datasource.password}")
	String password;
	@Value("${spring.shoolmonitor.datasource.url}")
	String url;
	@Value("${spring.shoolmonitor.datasource.driver-class-name}")
	String driverClassName;

	@Bean(name = "schoolsDataSource")

	public DataSource schoolmonitorDataSource() {

		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(driverClassName);
		dataSourceConfig.setJdbcUrl(url);
		dataSourceConfig.setUsername(dataUsername);
		dataSourceConfig.setPassword(password);

		return new HikariDataSource(dataSourceConfig);

	}

	@Bean(name = "schoolsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean schoolsEntityManagerFactory(
			final @Qualifier("schoolsDataSource") DataSource schoolsDataSource, Environment environment) {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect",
				environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		jpaProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		jpaProperties.put("hibernate.ejb.naming_strategy",
				environment.getRequiredProperty("spring.jpa.hibernate.naming.physical-strategy"));
		jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));

		factory.setJpaProperties(jpaProperties);
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.schoolmonitor.entities.schools");
		factory.setDataSource(schoolsDataSource);
		return factory;
	}

	@Bean(name = "schoolsTransactionManager")
	public PlatformTransactionManager schoolsTransactionManager(
			@Qualifier("schoolsEntityManagerFactory") EntityManagerFactory schoolsEntityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(schoolsEntityManagerFactory);
		return txManager;
	}
}

package com.schoolmonitor.config;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "schoolmonitorEntityManagerFactory", transactionManagerRef = "schoolmonitorTransactionManager", basePackages = {
		"com.schoolmonitor.repositories.schoolmonitor" })
public class SchoolMonitorPersistenceContextConfig {

	@Primary
	@Bean(name = "schoolmonitorDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.schoolmonitor.tenant1")
	public DataSource schoolmonitorDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "schoolmonitorEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final EntityManagerFactoryBuilder builder,
			final @Qualifier("schoolmonitorDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.schoolmonitor.entities.schoolmonitor")
				.persistenceUnit("schoolmonitor").build();
	}
    
	
	
	@Primary
	@Bean(name = "schoolmonitorTransactionManager")
	public PlatformTransactionManager schoolmonitorTransactionManager(
			@Qualifier("schoolmonitorEntityManagerFactory") EntityManagerFactory schoolmonitorEntityManagerFactory) {
		return new JpaTransactionManager(schoolmonitorEntityManagerFactory);
	}
}

package com.schoolmonitor.config;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
@EnableJpaRepositories(entityManagerFactoryRef = "schoolsEntityManagerFactory", transactionManagerRef = "schoolsTransactionManager", basePackages = {
		"com.schoolmonitor.repositories.schools" })
public class SchoolsPersistenceContextConfig {

	@Bean(name = "schoolsDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.schools")
	public DataSource schoolmonitorDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "schoolsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final EntityManagerFactoryBuilder builder,
			final @Qualifier("schoolsDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.schoolmonitor.entities.schools")
				.persistenceUnit("schools").build();
	}

	@Bean(name = "schoolsTransactionManager")
	public PlatformTransactionManager schoolTransactionManager(
			@Qualifier("schoolsEntityManagerFactory") EntityManagerFactory schoolsEntityManagerFactory) {
		return new JpaTransactionManager(schoolsEntityManagerFactory);
	}
}


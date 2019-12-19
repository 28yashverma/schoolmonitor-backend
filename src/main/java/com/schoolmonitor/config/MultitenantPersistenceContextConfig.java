/*
package com.schoolmonitor.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.schoolmonitor.config.MultitanentConfigurationProperties.DataSourceProperties;
import com.schoolmonitor.multitenacy.CurrentTenantIdentifierResolverImpl;
import com.schoolmonitor.multitenacy.DataSourceBasedMultiTenantConnectionProviderImpl;
import com.schoolmonitor.repositories.BaseRepositoryImpl;

*//**
 * @author PrabhjeetS
 * @version 1.0 November 21, 2019
 *//*

@Configuration
@EnableTransactionManagement
 @EnableConfigurationProperties({ MultitanentConfigurationProperties.class,
 JpaProperties.class })
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class, entityManagerFactoryRef = "multitenancyEntityManager", transactionManagerRef = "multitenancyTransactionManager", basePackages = {
		"com.schoolmonitor.repositories.schoolmonitor" })
public class MultitenantPersistenceContextConfig {

	@Autowired
	private JpaProperties jpaProperties;

	@Autowired
	private MultitanentConfigurationProperties multitenancyProperties;

	@Primary
	@Bean(name = "multitenancyDataSourceMap")
	public Map<String, DataSource> multitenancyDataSourceMap() {
		Map<String, DataSource> result = new HashMap<>();
		for (DataSourceProperties dataSourceProperties : this.multitenancyProperties.getDataSources()) {
			DataSourceBuilder<?> factory = DataSourceBuilder.create().url(dataSourceProperties.getUrl())
					.username(dataSourceProperties.getUsername()).password(dataSourceProperties.getPassword())
					.driverClassName(dataSourceProperties.getDriverClassName());
			result.put(dataSourceProperties.getTenantIdentifier(), factory.build());
		}
		return result;
	}

	*//**
	 * Autowires the data sources so that they can be used by the Spring JPA to
	 * access the database using Hibernate's API.
	 *//*
	@Bean
	public MultiTenantConnectionProvider multiTenantConnectionProvider() {
		return new DataSourceBasedMultiTenantConnectionProviderImpl();
	}

	*//**
	 * Since this is a multi-tenant application, Hibernate requires that the current
	 * tenant identifier is resolved for use
	 * 
	 * @return
	 *//*
	@Bean
	public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
		return new CurrentTenantIdentifierResolverImpl();
	}

	@Bean(name = "multitenancyEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean multitenancyEntityManagerFactoryBean(
			MultiTenantConnectionProvider multiTenantConnectionProvider,
			CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {

		Map<String, Object> hibernateProps = new LinkedHashMap<>();
		hibernateProps.putAll(this.jpaProperties.getProperties());

		hibernateProps.put(Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
		hibernateProps.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
		hibernateProps.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolver);

		LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();

		result.setPackagesToScan("com.schoolmonitor.entities.schoolmonitor");
		result.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		result.setJpaPropertyMap(hibernateProps);

		return result;
	}
	@Primary
	@Bean(name = "multitenancyEntityManager")
	public EntityManagerFactory multitenancyEntityManager(
			@Qualifier("multitenancyEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean multitanencyEntityManagerFactoryBean) {
		return multitanencyEntityManagerFactoryBean.getObject();
	}
	@Primary
	@Bean(name = "multitenancyTransactionManager")
	public PlatformTransactionManager multitenancyTransactionManager(
			@Qualifier("multitenancyEntityManager") EntityManagerFactory multitenancyEntityManager) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(multitenancyEntityManager);
		return txManager;
	}
}
*/
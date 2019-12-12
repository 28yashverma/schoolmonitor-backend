
package com.schoolmonitor.multitenacy;

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
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.schoolmonitor.config.MultitanentConfigurationProperties;
import com.schoolmonitor.config.MultitanentConfigurationProperties.CustomDataSourceProperties;

/**
 * @author PrabhjeetS
 * @version 1.0 November 21, 2019
 */

@Configuration
@EnableConfigurationProperties({ MultitanentConfigurationProperties.class, JpaProperties.class })
@EnableTransactionManagement
public class MultitenancyPropertiesContainer {

	@Autowired
	private JpaProperties jpaProperties;

	@Autowired
	private MultitanentConfigurationProperties multitenancyProperties;

	@Primary
	@Bean(name = "multitanencyDataSourceMap")
	public Map<String, DataSource> multitanencyDataSourceMap() {
		Map<String, DataSource> result = new HashMap<>();
		for (CustomDataSourceProperties dataSourceProperties : this.multitenancyProperties
				.getCustomDataSourceProperties()) {
			DataSourceBuilder<?> factory = DataSourceBuilder.create().url(dataSourceProperties.getUrl())
					.username(dataSourceProperties.getUsername()).password(dataSourceProperties.getPassword())
					.driverClassName(dataSourceProperties.getDriverClassName());
			result.put(dataSourceProperties.getTenantIdentifier(), factory.build());
		}
		return result;
	}

	/**
	 * Autowires the data sources so that they can be used by the Spring JPA to
	 * access the database using Hibernate's API.
	 */
	@Bean
	public MultiTenantConnectionProvider multiTenantConnectionProvider() {
		return new DataSourceBasedMultiTenantConnectionProviderImpl();
	}

	/**
	 * Since this is a multi-tenant application, Hibernate requires that the current
	 * tenant identifier is resolved for use with
	 * {@link org.hibernate.context.spi.CurrentSessionContext} and
	 * {@link org.hibernate.SessionFactory#getCurrentSession()}
	 * 
	 * @return
	 */
	@Bean
	public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
		return new CurrentTenantIdentifierResolverImpl();
	}

	/**
	 * org.springframework.beans.factory.FactoryBean that creates a JPA
	 * {@link javax.persistence.EntityManagerFactory} according to JPA's standard
	 * container bootstrap contract. This is the most powerful way to set up a
	 * shared JPA EntityManagerFactory in a Spring application context; the
	 * EntityManagerFactory can then be passed to JPA-based DAOs via dependency
	 * injection. Note that switching to a JNDI lookup or to a
	 * {@link org.springframework.orm.jpa.LocalEntityManagerFactoryBean} definition
	 * is just a matter of configuration!
	 * 
	 * @param multiTenantConnectionProvider
	 * @param currentTenantIdentifierResolver
	 * @return
	 */
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
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

	@Bean
	@Primary
	public EntityManagerFactory entityManagerFactory(@Qualifier("MultitenancyPropertiesContainerEntityManagerFactoryBean")LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		
		return entityManagerFactoryBean.getObject();
	}

	@Bean
	@Primary
	public PlatformTransactionManager transactionManager(@Qualifier("MultitenancyPropertiesContainerTransactionManager")EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}

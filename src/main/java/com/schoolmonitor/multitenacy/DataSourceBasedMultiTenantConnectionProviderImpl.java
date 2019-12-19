
package com.schoolmonitor.multitenacy;

import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author PrabhjeetS
 * @version 1.0 November 21, 2019
 */

/**
 * DataSourceBasedMultiTenantConnectionProviderImpl is subclass of Class
 * AbstractDataSourceBasedMultiTenantConnectionProviderImpl
 */
@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl
		extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	@Autowired
	private Map<String, DataSource> multitanencyDataSourceMap;
	private static final long serialVersionUID = 1L;

	public DataSourceBasedMultiTenantConnectionProviderImpl() {
	}

	@Override
	protected DataSource selectAnyDataSource() {
		return this.multitanencyDataSourceMap.values().iterator().next();
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		return this.multitanencyDataSourceMap.get(tenantIdentifier);
	}

}

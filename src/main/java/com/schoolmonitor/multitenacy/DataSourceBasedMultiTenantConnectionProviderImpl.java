
package com.schoolmonitor.multitenacy;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;

/**
 * @author PrabhjeetS
 * @version 1.0
   November 21, 2019
 */
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl{

	
	
	private static final long serialVersionUID = 1L;


	public DataSourceBasedMultiTenantConnectionProviderImpl() {
	}

	
	@Override
	protected DataSource selectAnyDataSource() {
		//TODO:
		return null;
	}

	
	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		//TODO:
		return null;
	}

}

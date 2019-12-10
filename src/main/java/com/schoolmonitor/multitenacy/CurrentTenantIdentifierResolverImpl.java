
package com.schoolmonitor.multitenacy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import com.schoolmonitor.model.TenantContext;

/**
 * @author PrabhjeetS
 * @version 1.0 November 21, 2019
 */
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	@Override
	public String resolveCurrentTenantIdentifier() {
		return TenantContext.getCurrentTenant();
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}

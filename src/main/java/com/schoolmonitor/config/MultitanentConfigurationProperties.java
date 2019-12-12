/**
 * 
 */
package com.schoolmonitor.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import  org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

/**
 * @author PrabhjeetS
 * @version 1.0
   Dec 9, 2019
 */
@Configuration
@ConfigurationProperties(prefix="spring.schoolmonitor")
public class MultitanentConfigurationProperties {

	private List<CustomDataSourceProperties> customDataSourceProperties=new ArrayList<CustomDataSourceProperties>();
    
	public List<CustomDataSourceProperties> getCustomDataSourceProperties() {
		return customDataSourceProperties;
	}

	public void setCustomDataSourceProperties(List<CustomDataSourceProperties> customDataSourceProperties) {
		this.customDataSourceProperties = customDataSourceProperties;
	}

	public static class CustomDataSourceProperties extends  DataSourceProperties{
    	private String tenantIdentifier;

		public String getTenantIdentifier() {
			return tenantIdentifier;
		}

		public void setTenantIdentifier(String tenantIdentifier) {
			this.tenantIdentifier = tenantIdentifier;
		}

		
    	
    }
}

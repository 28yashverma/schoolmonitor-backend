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

	private List<ConfigurationPropertiesList> configurationPropertiesList=new ArrayList<ConfigurationPropertiesList>();
    public List<ConfigurationPropertiesList> getConfigurationPropertiesList() {
		return configurationPropertiesList;
	}
	public void setConfigurationPropertiesList(List<ConfigurationPropertiesList> configurationPropertiesList) {
		this.configurationPropertiesList = configurationPropertiesList;
	}
	public static class ConfigurationPropertiesList extends  DataSourceProperties{
    	private String Identifier;

		public String getIdentifier() {
			return Identifier;
		}

		public void setIdentifier(String identifier) {
			Identifier = identifier;
		}
    	
    }
}

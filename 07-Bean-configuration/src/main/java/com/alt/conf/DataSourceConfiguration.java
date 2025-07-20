package com.alt.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.alt.serviceImpl.HDfC;
import com.alt.serviceImpl.SBI;

@Configuration
public class DataSourceConfiguration {
	public DataSourceConfiguration() {
		System.out.println("DataSourceConfiguration::0-param");
	}
//Indicates that a method produces a bean to be managed by the Spring container. 
	   @Bean  
	   @Scope("prototype")
	   public HDfC getHdfc() {
		   System.out.println("DataSourceConfiguration::getHdfc is executed");
		   return new HDfC();
	   }
	   @Bean  
	   @Scope("prototype")
	   public SBI getSbi() {
		   System.out.println("DataSourceConfiguration::getSbi is executed");
		   return new SBI();
	   }
}

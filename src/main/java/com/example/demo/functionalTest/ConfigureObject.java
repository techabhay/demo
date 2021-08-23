package com.example.demo.functionalTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureObject {

	/*	@Bean
	public Employee getConfiguredEmployee() {
		Employee employee = new Employee();
		employee.setLastName("Mishra");
		return employee;
	}
	 */

	@Bean
	public CustomFuntionInterface getConfiguredEmployee() {
		return employee -> {			
			employee.setLastName("Mishra");
			return employee;
		};	
	}

}

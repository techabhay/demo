package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.functionalTest.Employee;

@RestController
@RequestMapping("/testFunction")
public class TestConfigure {

	/*
	 * @Autowired
	 *  CustomFuntionInterface customFunctionInterface;
	 */
	
	@Autowired
	Employee employee;
	
	@GetMapping(path = "/bean")  
	public String getEmployeeName() {
		employee.setFirstName("Abhay");
		return employee.getFirstName() + " " + employee.getLastName();
	   // System.out.println("Heyy : " + employee.getFirstName() + " " + employee.getLastName());
	}
	
}

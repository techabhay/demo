package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	
	@Value("${application.welcome.message}")
	String profileMessage;
	
	@Override
	public String getProfileMessage() {
		System.out.println("ProfileMessage : " + profileMessage);
		return profileMessage;
	}
	
}

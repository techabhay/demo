package com.example.demo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedRateSchedule {
	
	private final static Logger log = LoggerFactory.getLogger(FixedRateSchedule.class);
	
	//@Scheduled(fixedDelay = 1000)
	public void scheduleFixedDelayTask() {
		log.info("Fixed delay task - " + System.currentTimeMillis() / 1000);
	}
}

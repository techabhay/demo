package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class CounterInStream {
	
	static List list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		list.add(12);
		list.add(16);
		list.add(21);
		list.add(32);
		list.add(40);
		list.add(11);
		list.add(60);
		
		printCounter();
	}
	
	static void printCounter() {
		AtomicInteger counter = new AtomicInteger(1);
		list.stream().forEach(i -> {
			System.out.println("counter :: " + counter.getAndIncrement());
			System.out.println("list ... : " + i);
		});
	}
	
}




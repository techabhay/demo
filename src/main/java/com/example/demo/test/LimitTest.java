package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class LimitTest {
	
	public static void main(String[] args) {
		int limit = 3;
		int page = 2;
		int totalResult = 7;
		System.out.println("betweenMap : " + getStartAndEndIndex(limit, page));
		System.out.println("NumberOfPages : " + getNoOfPages(limit, totalResult));
	}
	
	static Map<String, Integer> getStartAndEndIndex(int limit, int page) {
		Map<String, Integer> betweenMap = new HashMap<String, Integer>();
		
		int end = page*limit;
		int start = end-(limit-1);
		betweenMap.put("start", start);
		betweenMap.put("end", end);
		
		return betweenMap;
	}
	
	static int getNoOfPages(int limit, int totalResult) {
		/*int noOfPages;
		if (totalResult % limit == 0) {
			noOfPages = totalResult / limit;
		} else {
			noOfPages = totalResult / limit + 1;
		}
		return noOfPages; */
		
		return (int) Math.ceil((float)totalResult/limit);
	}
}




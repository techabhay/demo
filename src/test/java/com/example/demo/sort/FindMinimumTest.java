package com.example.demo.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FindMinimumTest {

	@Test
	void findMinTest() {
		String expected = "1";
		
		FindMinimum findMinimum = new FindMinimum();
		List<String> inputList = new ArrayList<String>();
		inputList.add("3");
		inputList.add("5 1 4");
		
		String actual = findMinimum.findMin(inputList);
		Assertions.assertEquals(expected, actual);
		
	}
}

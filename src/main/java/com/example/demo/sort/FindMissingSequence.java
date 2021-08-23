package com.example.demo.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class FindMissingSequence {

	public static void main(String []args){
		System.out.println("Hello World");

		FindMissingSequence findMissingSequence = new FindMissingSequence();
		findMissingSequence.solution(new int[]{11,13,26,16,12,14});
	}

	public int solution(int[] arr) {

		List<Integer> inputList =  IntStream.of(arr).boxed().sorted().collect(Collectors.toList());
		System.out.println("sorted List : " + inputList);
		
		 int output =  IntStream.range(0, (inputList.size()-1))
			        .filter(i -> {System.out.println("h : " + inputList.get(i)); return ((inputList.get(i+1) - inputList.get(i)) >=2);}).map(i -> inputList.get(i))
			        .findFirst().orElse(inputList.get(inputList.size()-1)+1);
			    
			     System.out.println("output : " + output);
		
		return output;
	}
}




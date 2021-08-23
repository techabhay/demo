package com.example.demo.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;


/**
 *@author Abhay Mishra
 */

public class FindMinimum {
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,4};
		List<String> inputList = new ArrayList<String>();
		inputList.add("3");
		inputList.add("5 1 4");
		
		System.out.println("Find_Min: " + findMin(inputList));
		
		/*	
		 IntStream stream = IntStream.of(getAllValuesArr(inputList));
	       
	       OptionalInt obj = stream.min();
	       
	       if(obj.isPresent()) {
	           System.out.println(obj.getAsInt());
	       } else {
	           System.out.println("-1");
	       }
	      */
	}
	
	public static String findMin(List<String> inputList) {
		 IntStream stream = IntStream.of(getAllValuesArr(inputList));
	       
	       OptionalInt obj = stream.min();
	       
	       if(obj.isPresent()) {
	           return String.valueOf(obj.getAsInt());
	       } else {
	           return "-1";
	       }
	}
	
	private static int[] getAllValues(List<String> inputList) {
		List<Integer> intList = new ArrayList<Integer>();
        for (String inputVal : inputList) {
           for (char iChar : inputVal.toCharArray()) {
        	   if (iChar!=' ') {
        		   Character.toString(iChar);
        		   intList.add(Integer.parseInt(String.valueOf(iChar)));
        		  //System.out.println(Integer.parseInt(String.valueOf(iChar)));
        	   }        	   
           }
        }
        System.out.println(intList);
        int[] intArray = intList.stream().mapToInt(i->i).toArray();
        return intArray;
    }
	
	private static int[] getAllValuesArr(List<String> inputList) {
		List<Integer> intList = new ArrayList<Integer>();
		 for (String inputVal : inputList) {
			 if (inputVal.contains(" ")) {
				String[] strArr = inputVal.split(" ");
				for (String str : strArr) {
					intList.add(Integer.parseInt(str));
				}
			 } else {
				 intList.add(Integer.parseInt(inputVal));
			 }			 
		 }
		 System.out.println(intList);
		 int[] intArray = intList.stream().mapToInt(i->i).toArray();
	     return intArray;
	}
}




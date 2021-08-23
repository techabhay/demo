package com.example.demo.sort;

import java.util.HashMap;
import java.util.Map;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class DivideAndSwapString {
	public static void main(String[] args) {
		/*StringBuilder b = new StringBuilder("hacker");
		b.append(4).deleteCharAt(3).delete(3,b.length()-1);
		System.out.println(b);
		 */
		//"aabcc cabba"

		String str = "aabcccabba";		

		String secondPartFormatted = "";
		String firstPartFormatted = "";

		Map<String, String> dividedMap = getDividedString(str);

		String firstPart = dividedMap.get("firstPart");
		String secondPart = dividedMap.get("secondPart");
		String result = secondPart+firstPart;

		while (result.length() >4 && secondPart.charAt(secondPart.length()-1) == firstPart.charAt(0)) {
			if (secondPart.charAt(secondPart.length()-1) == firstPart.charAt(0)) {
				char c = secondPart.charAt(secondPart.length()-1);
				secondPart = getSecondPartFormattedString(secondPart,c);
				//System.out.println("s FORMAT : " + secondPart);

				firstPart = getFirstPartFormattedString(firstPart, c);
				//System.out.println("f FORMAT : " + firstPart);
				System.out.println("result : " + secondPart + " " + firstPart);
				result = secondPart+firstPart;
				
				dividedMap = getDividedString(result);
				firstPart = dividedMap.get("firstPart");
				secondPart = dividedMap.get("secondPart");
			}
		}
		System.out.println("Result : " + result);


	}

	private static String getSecondPartFormattedString(String str, char charValue) {

		char c = str.charAt(str.length()-1);
		//System.out.println("c in meth : " + c);
		while(str.length()>=1 && str.charAt(str.length()-1) == charValue) {
			str = str.substring(0,str.length()-1);
		}
		return str;
	}

	private static String getFirstPartFormattedString(String str, char charValue) {
		
		while(str.length()>=1 && str.charAt(0) == charValue) {
			str = str.substring(1,str.length());
		}
		return str;
	}

	private static Map<String, String> getDividedString(String inputString) {
		System.out.println("InputString : " + inputString);
		Map<String, String> dividedMap = new HashMap<String, String>();
		int stringLength = inputString.length();
		int mid = stringLength/2;
		//System.out.println(mid);

		String firstPart = inputString.substring(0,mid);
		String secondPart = inputString.substring(mid,stringLength);

		System.out.println("firstPart : " + firstPart);
		System.out.println("secondPart : " + secondPart);
		System.out.println("beforeFormatting : " + secondPart + " " + firstPart);
		
		dividedMap.put("firstPart", firstPart);
		dividedMap.put("secondPart",secondPart);
		return dividedMap;
	}
}




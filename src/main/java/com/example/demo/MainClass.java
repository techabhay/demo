package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
	
	public static void main(String []args) {
        System.out.println("Hello World");
        getMergedString("Hello", "World");
     }
     
     
     public static String getMergedString(String a, String b) {
         String output = "";
        List<Character> outList = new ArrayList<Character>();
            Stream<Character> aStream = a.chars().mapToObj(c -> (char)c);
            Stream<Character> bStream = b.chars().mapToObj(c -> (char)c);
            
            int aSize = a.length();
            int bSize = b.length();
            
            String combinedString = a+b;
            
            System.out.println("Char : " + output.charAt((aSize+bSize)-1));
            
            
                        
         /* ListoutList  aStream.map((aChar) -> {
            	int i = 0;
            	outList.add(i+=2, aChar);
            	return outList;
            }).collect(Collectors.toList());
            
            bStream.map((bChar) -> {
            	int i = 1;
            	outList.add(i+=2, bChar);
            	return outList;
            }).collect(Collectors.toList()); */
            
            System.out.println("outList : " + outList);
        return output;
     }
}

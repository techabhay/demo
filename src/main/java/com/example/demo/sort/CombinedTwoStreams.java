package com.example.demo.sort;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class CombinedTwoStreams {
	
	public static void main(String[] args) {
		Stream<Integer> stream1 = Stream.of(1, 3, 5);
	    Stream<Integer> stream2 = Stream.of(2, 4, 6);
	    Stream<Integer> stream3 = Stream.of(18, 15, 36);
	    
	    Stream<String> stringSteam = Stream.of("2, 4, 6");
	 
	    Stream<Integer> resultingStream = Stream.concat(
	      Stream.concat(stream1, stream2), stream3);
	    
	    IntStream intStream = resultingStream.mapToInt(Integer::intValue);
	   System.out.println(intStream.min().orElse(-1));
	}
	
}




package com.example.demo.sort;

/*
XEBIA:YBL
@author ABHAY MISHRA
*/

import java.util.*;
import java.util.stream.IntStream;
class PrintFizzBuzzWithinRange {
   static int totalNumbersPrinted = 1;
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 */
        //Scanner
        
        Scanner s = new Scanner(System.in);
        List<String> inputList = new ArrayList<String>();              
        int limit = Integer.parseInt(s.nextLine());
        while (s.hasNextLine()) {
        
        String scanValue = s.nextLine();
        inputList.add(scanValue);            
       } 

    List<Integer> intList = getAllValuesArr(inputList);
       
     intList.stream().forEach(i -> {

        IntStream.range(1, i+1).forEach(num -> {           
            printRangeNumbers(num);          
            });
    });
        


    }

    private static void printRangeNumbers(int i) {        

        if ((i%3 == 0) && (i%5 == 0)) {
            System.out.println("FizzBuzz");
        } else if (i%3 == 0) {
            System.out.println("Fizz");
        } else if (i%5 == 0) {
            System.out.println("Buzz");
        } else {
         System.out.println(i);
        }     
    }
    private static List<Integer> getAllValuesArr(List<String> inputList) {
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
         return intList;	
	}
}

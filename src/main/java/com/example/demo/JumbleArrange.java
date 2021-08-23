package com.example.demo;

import java.util.List;

public class JumbleArrange {

	static char c = '\0';
	public static void main(String ar[]) {

		String aStr = "aaaaaa";
		String bStr = "bb";
				

		char[] aChAr = aStr.toCharArray();
		char[] bChAr = bStr.toCharArray();
		
		//List<Character> remainingChar = new char[aStr.length()+bStr.length()];

		char[] resultChar = new char[aStr.length()+bStr.length()];
		String resultString = "";

		//System.out.println("c : " + c);
		//resultString = runOuterAsA(aChAr, bChAr, resultChar);
		//resultString = runOuterAsB(resultChar);
		
		randomArrangementOfA(aStr, resultChar);
		
		int i=0;
		for (char c : resultChar) {
			
			System.out.println("value " + c + " @index " + i);
			if (c == '\0') {
				System.out.println("empty @index " + i);
				resultChar[i]='b';
			}
			i++;
		}

		System.out.println("resultChar : " + new String(resultChar).toString());
	}

	private static void randomArrangementOfA(String aStr, char[] resultChar) {
		System.out.println("A length : " + aStr.toCharArray().length );

		for(int i=0; i<aStr.toCharArray().length;) {
			int index = (int)(resultChar.length * Math.random());
			System.out.println("INDEX : " + index);
			
			  if (resultChar[index] != 'a') {
				  resultChar[index] = 'a';
				  i++;
			  }
		}
		System.out.println("DONE");
	}	


	/*
	 * private static String runOuterAsA(char[] aChar, char[] bChar, char[]
	 * resultChar) { int aCounter = 1; int bCounter = 1; int resultCharCounter=0;
	 * for(char aCh : aChar) { bCounter=1; resultChar[resultCharCounter++] = aCh;
	 * aCounter++; if(aCounter > 2) { aCounter = 1; for(char bCh : bChar) {
	 * resultChar[resultCharCounter++] = bCh; bCounter++; if(bCounter > 2) { break;
	 * } } } } return resultChar.toString(); }
	 */
}

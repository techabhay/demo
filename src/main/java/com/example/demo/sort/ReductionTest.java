package com.example.demo.sort;

import java.util.ArrayList;
import java.util.List;

public class ReductionTest {

	public static int reductionCost(List<Integer> num) {
		// Write your code here
		int reductionCost = 0;
		List<Integer> sumList = new ArrayList<Integer>();
		
		int loopLimit = num.size()-1;
		for (int i=0; i<loopLimit; i++) {
		//while(num.size() >= 2) {
			int sumOfTwo = getSumOfTwoNumbers(num.get(0), num.get(1));
			sumList.add(sumOfTwo);
			num.remove(0);
			if (num.size() > 1) {
				num.remove(0);
			}
			num.add(sumOfTwo);
		}
		reductionCost = sumList.stream().reduce(0, Integer::sum);
		System.out.println("reductionCost : " + reductionCost);
		return reductionCost;
	}

	private static int getSumOfTwoNumbers(int num1, int num2) {
		return num1 + num2;
	}
	
	public static void main(String[] args) {
		List<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(2);
		num.add(3);
		reductionCost(num);
	}
}

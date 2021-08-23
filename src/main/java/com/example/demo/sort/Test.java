package com.example.demo.sort;

import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
		TreeMap obj = new TreeMap();
		obj.put("A", new Integer(1));
		obj.put("B", new Integer(2));
		obj.put("C", new Integer(3));
		System.out.println(obj.entrySet());
	}
}

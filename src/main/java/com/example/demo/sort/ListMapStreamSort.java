package com.example.demo.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.test.Address;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class ListMapStreamSort {
	
	public static void main(String[] args) {
		
		ListMapStreamSort listMapStreamSortObj = new ListMapStreamSort();
				
		List<String> strList = new ArrayList<String>();
		strList.add("K");
		strList.add("G");
		strList.add("A");
		strList.add("F");
		strList.add("E");
		strList.add("D");
		
		List<Address> objList = new ArrayList<Address>();
		objList.add(new Address("KAddrs", 88));
		objList.add(new Address("GAddrs", 62));
		objList.add(new Address("AAddrs", 74));
		objList.add(new Address("FAddrs", 42));
		objList.add(new Address("EAddrs", 79));
		objList.add(new Address("DAddrs", 86));
		objList.add(new Address("BAddrs", 47));
		
		Map<String, String> strKeyMap = new HashMap<String, String>();
		strKeyMap.put("K", "2");
		strKeyMap.put("G", "2");
		strKeyMap.put("A", "2");
		strKeyMap.put("F", "2");
		strKeyMap.put("E", "2");
		strKeyMap.put("D", "2");
		strKeyMap.put("B", "2");
		
		Map<String, String> strValueMap = new HashMap<String, String>();
		strValueMap.put("62", "K");
		strValueMap.put("24", "G");
		strValueMap.put("92", "A");
		strValueMap.put("82", "F");
		strValueMap.put("21", "E");
		strValueMap.put("72", "D");
		strValueMap.put("42", "B");
		
		Map<Address, String> objKeyMap = new HashMap<Address, String>();
		objKeyMap.put(new Address("KAddrs", 88), "2");
		objKeyMap.put(new Address("GAddrs", 62), "2");
		objKeyMap.put(new Address("AAddrs", 74), "2");
		objKeyMap.put(new Address("FAddrs", 42), "2");
		objKeyMap.put(new Address("EAddrs", 79), "2");
		objKeyMap.put(new Address("DAddrs", 86), "2");
		objKeyMap.put(new Address("BAddrs", 47), "2");
		
		Map<String, Address> objValueMap = new HashMap<String, Address>();
		objValueMap.put("62", new Address("KAddrs", 88));
		objValueMap.put("24", new Address("GAddrs", 62));
		objValueMap.put("92", new Address("AAddrs", 74));
		objValueMap.put("82", new Address("FAddrs", 42));
		objValueMap.put("21", new Address("EAddrs", 79));
		objValueMap.put("72", new Address("DAddrs", 86));
		objValueMap.put("42", new Address("BAddrs", 47));
		

		listMapStreamSortObj.sortStrList(strList);
		listMapStreamSortObj.sortObjList(objList);
		listMapStreamSortObj.sortStrKeyMap(strKeyMap);
		listMapStreamSortObj.sortStrValueMap(strValueMap);
		listMapStreamSortObj.sortObjKeyMap(objKeyMap);
		listMapStreamSortObj.sortObjValueMap(objValueMap);
	}
	
	
	public void sortStrList(List<String> strList) {
		System.out.println("String List Sort :: ");
		strList.stream().sorted().forEach(System.out::println);
	}
	
	public void sortObjList(List<Address> objList) {
		System.out.println("Object List Sort :: ");
		objList.stream().sorted(Comparator.comparing(address->address.getStreetAddress())).forEach(adrs -> System.out.println(adrs));
	}
	
	public void sortStrKeyMap(Map<String, String> strKeyMap) {
		System.out.println("String Key Map Sort ::");
		strKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
	}
	
	public void sortStrValueMap(Map<String, String> strValueMap) {
		System.out.println("String Value Map Sort ::");
		strValueMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
	}
	
	public void sortObjKeyMap(Map<Address, String> objKeyMap) {
		System.out.println("Object Key Map Sort ::");
		objKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(addrs -> addrs.getStreetAddress()))).forEach(System.out::println);
	}
	
	public void sortObjValueMap(Map<String, Address> objValueMap) {
		System.out.println("Object Value Map Sort ::");
		objValueMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Address::getStreetAddress))).forEach(System.out::println);
	}	
	
	//======
	
	public void sortStrListReversed(List<String> strList) {
		System.out.println("String List Sort Reversed:: ");
		strList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	public void sortObjListReversed(List<Address> objList) {
		System.out.println("Object List Sort Reversed:: "); // to use reversed(), use methodReference.
		objList.stream().sorted(Comparator.comparing(Address::getStreetAddress).reversed()).forEach(adrs -> System.out.println(adrs));
	}
	
	public void sortStrKeyMapReversed(Map<String, String> strKeyMap) {
		System.out.println("String Key Map Sort Reversed::");
		strKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
	}
	
	public void sortObjValueMapReversed(Map<String, Address> objValueMap) {
		System.out.println("Object Value Map Sort Reversed::");
		objValueMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Address::getStreetAddress).reversed())).forEach(System.out::println);
	}
}




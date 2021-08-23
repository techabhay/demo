package com.example.demo.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.test.Address;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class OrderedSortedMapStream {
	
	public static void main(String[] args) {
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
		
		List<Address> objList = new ArrayList<Address>();
		objList.add(new Address("KAddrs", 88));
		objList.add(new Address("GAddrs", 62));
		objList.add(new Address("AAddrs", 74));
		objList.add(new Address("FAddrs", 42));
		objList.add(new Address("EAddrs", 79));
		objList.add(new Address("DAddrs", 86));
		objList.add(new Address("BAddrs", 47));
		
		
		
		OrderedSortedMapStream orderedSortedMapStream = new OrderedSortedMapStream();
		// it will sort, but it will not maintain the sorted ordered.
		orderedSortedMapStream.sortedAndOrderedMapForKey(objKeyMap);
		
		// this will maintain sorted order
		orderedSortedMapStream.sortedAndOrderedMapForKeyMaintained(objKeyMap);
		
		orderedSortedMapStream.sortedAndOrderedMapForValueMaintained(objValueMap);
		
		orderedSortedMapStream.listToMap(objList);
		
		objList.add(new Address("DAddrs", 86)); // added for duplicacy
		// orderedSortedMapStream.listToMapWithDuplicateKey(objList); // this will give error, as duplicatekey not handled.
		
		orderedSortedMapStream.listToMapWithDuplicateKeyHandled(objList);
		
		// this will not maintain sorted order
		orderedSortedMapStream.listToSortedMap(objList);
		
		// this will maintain sorted order
		orderedSortedMapStream.listToSortedMapMaintainted(objList);
		
		orderedSortedMapStream.listToSortedMapMaintaintedForObjectValue(objList);
		

	}
	
	public void sortedAndOrderedMapForKey(Map<Address,String> objKeyMap) {
		Map<Address, String> sortedMap = objKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Address::getStreetAddress)))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("SortedMap for Key :: " + sortedMap);
	}
	
	public void sortedAndOrderedMapForKeyMaintained(Map<Address,String> objKeyMap) {
		Map<Address, String> sortedMap = objKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Address::getStreetAddress)))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue)->oldValue, LinkedHashMap::new));
		System.out.println("SortedMap for Key Maintained :: " + sortedMap);
	}
	
	public void sortedAndOrderedMapForValueMaintained(Map<String,Address> objValueMap) {
		Map<String, Address> sortedMap = objValueMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Address::getStreetAddress)))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue)->oldValue, LinkedHashMap::new));
		System.out.println("SortedMap for Value Maintained :: " + sortedMap);
	}
	
	public void listToMap(List<Address> objList) {
		Map<String, Integer> mapForList = objList.stream().collect(Collectors.toMap(Address::getStreetAddress, Address::getPinCode));
		System.out.println("listToMap :: " + mapForList);
	}	
	
	public void listToMapWithDuplicateKey(List<Address> objList) {
		Map<String, Integer> mapForList = objList.stream().sorted(Comparator.comparing(Address::getStreetAddress)).collect(Collectors.toMap(Address::getStreetAddress, Address::getPinCode));
		System.out.println("listToMap Duplicate Key :: " + mapForList);
	}
	
	public void listToMapWithDuplicateKeyHandled(List<Address> objList) {
		Map<String, Integer> mapForList = objList.stream().sorted(Comparator.comparing(Address::getStreetAddress)).collect(Collectors.toMap(Address::getStreetAddress, Address::getPinCode, (oldValue, newValue) -> oldValue));
		System.out.println("listToMap Duplicate Key Handled :: " + mapForList);
	}
	
	public void listToSortedMap(List<Address> objList) {
		Map<String, Integer> sortedMap = objList.stream().sorted(Comparator.comparing(Address::getStreetAddress)).collect(Collectors.toMap(Address::getStreetAddress, Address::getPinCode));
		System.out.println("listToMap sorted :: " + sortedMap);
	}
	
	public void listToSortedMapMaintainted(List<Address> objList) {
		Map<String, Integer> sortedMap = objList.stream().sorted(Comparator.comparing(Address::getStreetAddress)).collect(Collectors.toMap(Address::getStreetAddress, Address::getPinCode, (oldValue, newValue)->oldValue, LinkedHashMap::new));
		System.out.println("listToMap sorted Maintained:: " + sortedMap);
	}

	public void listToSortedMapMaintaintedForObjectValue(List<Address> objList) {
		Map<String, Address> sortedMap = objList.stream().sorted(Comparator.comparing(Address::getStreetAddress)).collect(Collectors.toMap(Address::getStreetAddress, Address::getAddressObj, (oldValue, newValue)->oldValue, LinkedHashMap::new));
		System.out.println("listToMap sorted Maintained with Address as value:: " + sortedMap);
	}


}




package com.example.demo.utils;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class DemoUtil {

	public static String getExtension(String url) {
		String extension = "";
		if (isEmpty(url)) {
			return extension;
		}

		if (url.contains(".")) {
			extension = url.substring(url.lastIndexOf(".")+1, url.length());
		}
		return extension;
	}

	public static Timestamp getCurrentTimeStamp() {
		Date today = new Date();
		return new Timestamp(today.getTime());
	}

	public static boolean isEmpty(String data) {
		if (data == null || data.trim().length() <= 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String[] dataArray) {
		boolean isArrayEmpty = true;
		for (String data : dataArray) {
			if (!isEmpty(data)) {
				isArrayEmpty = false;
				break;
			}
		}	
		return isArrayEmpty;
	}

	public static boolean isEmpty(Collection collection) {
		if (collection == null || collection.size() <= 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Map<?, ?> map) {
		if (map == null || map.size() <= 0) {
			return true;
		}
		return false;
	}
}




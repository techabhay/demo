package com.example.demo.RestCallAndDownloadImage;

import java.util.HashMap;
import java.util.Map;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class SeggregateURL {
	
	public static void main(String[] args) {
		System.out.println("File Path : " + getStorePictureAzureFilePath());
	}
	
	private static Map<String,String> getStorePictureAzureFilePath() {
		Map<String, String> filePathMap = new HashMap<String, String>();
		String path = "";
		String fileName = "";
		String url = "https://gsrnonprodv2.blob.core.windows.net/gsruat3/STORE_PICTURE/170/170_102_2020_w1_b1.jpg";
		if (url.contains("STORE_PICTURE")) {
			path =  url.substring(url.indexOf("STORE_PICTURE"), url.lastIndexOf("/"));
			fileName = url.substring(url.lastIndexOf("/")+1);
			filePathMap.put("path", path);
			filePathMap.put("fileName", fileName);
		}
		return filePathMap;
	}
}




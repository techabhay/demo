package com.example.demo.webmonitor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.validator.routines.UrlValidator;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class TestResponseCode {
	
	public static void main(String[] args) {
		String url = "https://www.w3schools.com";
		int timeout = 1000;
		System.out.println("isAccessable() :: " + isAccessable(url, timeout));
		System.out.println("is ValidURL :: " + isValidUrl(url));
	}
	
	public static boolean isAccessable(String url, int timeout) {
	   // url = url.replaceFirst("https", "http"); // Otherwise an exception may
	                                                // be thrown on invalid SSL
	                                                // certificates.

	    try {
	        HttpURLConnection connection = (HttpURLConnection) new URL(url)
	                .openConnection();
	        connection.setConnectTimeout(timeout);
	        connection.setReadTimeout(timeout);
	        connection.setRequestMethod("GET");
	        int responseCode = connection.getResponseCode();
	        if (responseCode != 200) {
	            return false;
	        }
	    } catch (IOException exception) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isValidUrl(String url) {
		UrlValidator urlValidator = new UrlValidator();
		return urlValidator.isValid(url);
	}
}




package com.example.demo.RestCallAndDownloadImage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class RestCallToApi {
	
	public static void main(String[] args) {
		//StorePictureResponse response = callApi();
		getFormattedDate();
	}
	
	public static StorePictureResponse callApi() {
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "https://cdar-nicuat3.nielsen.com/dct/GenerateSessionToken";
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("jsonString", "{\"CountryId\":\"170\"}");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Stream.of(MediaType.APPLICATION_JSON).collect(Collectors.toList()));
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		StorePictureResponse response = restTemplate.postForObject(uri, request,  StorePictureResponse.class);
		
		System.out.println("response : " + response);
		System.out.println("AccountName :::::::: " + response.getAccountName());
		return response;
	}
	
	public static void getFormattedDate() {
		String dateStr = "Mon Jun 01 12:23:09 UTC 2020";
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date date = null;
		try {
			date = (Date)formatter.parse(dateStr);
			System.out.println("DTC End Date ::: " + date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date currentDate = new Date();
		//System.out.println("Time : " + date.getHours()); 
		System.out.println("current Date : " + currentDate);
		System.out.println("IsValid : " + isFirstDateBeforeSecondDate(currentDate, date));
		System.out.println("IsValid Equal : " + isFirstDateEqualOrBeforeSecondDate(currentDate, date));
	}
	
	public static boolean isFirstDateEqualOrBeforeSecondDate(Date firstDate, Date secondDate) {
		boolean isFirstDateBeforeSecondDate = false;
		try {
			if (firstDate != null && secondDate != null) {
				isFirstDateBeforeSecondDate = firstDate.before(secondDate) || firstDate.equals(secondDate);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return isFirstDateBeforeSecondDate;
		}
		return isFirstDateBeforeSecondDate;
	}
	
	public static boolean isFirstDateBeforeSecondDate(Date firstDate, Date secondDate) {
		boolean isFirstDateBeforeSecondDate = false;	
		try {
			if (firstDate != null && secondDate != null) {				
				isFirstDateBeforeSecondDate = firstDate.before(secondDate);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return isFirstDateBeforeSecondDate;
		}
		return isFirstDateBeforeSecondDate;
	}
}




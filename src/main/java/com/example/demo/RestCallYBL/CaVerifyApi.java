package com.example.demo.RestCallYBL;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class CaVerifyApi {
	
	public static void main(String[] args) {
		CaVerifyResponse response = callApi();
		//getFormattedDate();
	}
	
	public static CaVerifyResponse callApi() {
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "https://uatsky.yesbank.in/app/uat/CAAccountCheckWrapper/v1";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.setAccept(Stream.of(MediaType.APPLICATION_JSON).collect(Collectors.toList()));
		headers.put("x-ibm-client-id", Stream.of("0a74476d-f5e9-4584-97d5-b54125f3077b").collect(Collectors.toList()));
		headers.put("x-ibm-client-secret", Stream.of("wM0xK0uH8hH6eY6nM3xM4iI1xU7tE8fU1wN5nD6nU3mK8pH8pH").collect(Collectors.toList()));
	//	headers.put("Authorization", Stream.of("Basic dGVzdGNsaWVudDpPeFljb29sQDEyMw==").collect(Collectors.toList()));
		//String reqString = "{ \"CAAccountCheckReq\": { \"ReqRefNum\" : \"454656\", \"CustomerId\": \"982114\" } }";
		HttpEntity<CaVerifyRequest> request = new HttpEntity<CaVerifyRequest>(getCaVerifyRequest(), headers);
		CaVerifyResponse response = restTemplate.postForObject(uri, request,  CaVerifyResponse.class);
		
		System.out.println("response : " + response);
		System.out.println("AccountName :::::::: " + response.getCAAccountCheckRes());
		return response;
	}
	
	/*
	 * public static String getCaVerifyRequestString() { CaVerifyRequest
	 * caVerifyRequest = getCaVerifyRequest(); String caVerifyRequestString = "";
	 * ObjectMapper mapper = new ObjectMapper(); try { caVerifyRequestString =
	 * mapper.writeValueAsString(caVerifyRequest); } catch (JsonProcessingException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * System.out.println("caVerifyRequestString :: " + caVerifyRequestString);
	 * return caVerifyRequestString; }
	 */
	
	public static CaVerifyRequest getCaVerifyRequest() {
		CaVerifyRequest caVerifyRequest = new CaVerifyRequest();
		
		CaAccountChkRequest caAccountChkRequest = new CaAccountChkRequest();
		caAccountChkRequest.setCustomerId("982114");
		caAccountChkRequest.setReqRefNum("454656");
		
		caVerifyRequest.setCAAccountCheckReq(caAccountChkRequest);
		return caVerifyRequest;
	}
}




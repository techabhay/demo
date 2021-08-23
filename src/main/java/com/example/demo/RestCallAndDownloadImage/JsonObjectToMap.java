package com.example.demo.RestCallAndDownloadImage;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class JsonObjectToMap {
	
	public static void main(String[] args) throws IOException {
		String jsonString = "{\"WAVE\": \"w1\", \"YEAR\":2019, \"BLOCK\":222767764, \"STORE_PICTURE\":\"https://cdarlhhtblobnonprod001.blob.core.windows.net/data-dct/UAT3/SurveyResponses/356/15513/100073036/100073036_STOREPICTURE_1580386508.jpg\"}";
		String convertedJsonString = "";
		Map<String, Object> jsonMap = null;
		try {
			jsonMap = getMapFromJson(jsonString);
			convertedJsonString = getJsonStringFromMap(jsonMap);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("STORE_____PICTURE :: " + jsonMap.get("STORE_PICTURE"));
		System.out.println("ConvertedJsonString :: " + convertedJsonString);
	}
	
	public static Map<String, Object> getMapFromJson(String jsonString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap= mapper.readValue(jsonString, Map.class);
		return jsonMap;
	}
	
	public static String getJsonStringFromMap(Map<?,?> dataMap) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(dataMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}




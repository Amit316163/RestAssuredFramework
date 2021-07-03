package com.qa.api.gorest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
	public static String getSerializedJSON(Object obj) {
		
		
		ObjectMapper mapper =new ObjectMapper();
		String jsonString=null;
		try {
			jsonString=mapper.writeValueAsString(obj);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
		
		
	}
	
	public int parserStringToInt(String stringValue) {
		
		int num=Integer.parseInt(stringValue.substring(0,stringValue.indexOf(".")));
		return num;
	}

}

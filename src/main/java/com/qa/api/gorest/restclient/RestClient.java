package com.qa.api.gorest.restclient;

import java.util.Map;

import com.qa.api.gorest.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestClient {

	//HTTP Methods: Get,Post,Put and Delete

	public static Response doPost(String baseURI,String basePath,String token,String contentType, 
			Map<String ,String >paramsMap,boolean log,Object obj) {

		if(setBaseURI(baseURI)) {
		RequestSpecification request=createRequest(token, contentType, paramsMap, log);
		addRequestPayload(request,obj);
		return getResponse("POST", request, basePath);
	}
		return null;
	}
	
	public static Response doGet(String baseURI,String basePath,String token,String contentType, 
			Map<String ,String >paramsMap,boolean log) {

		if(setBaseURI(baseURI)) {
		RequestSpecification request=createRequest(token, contentType, paramsMap, log);
		return getResponse("GET", request, basePath);
	}
		return null;
	}
	
	private static boolean setBaseURI(String baseURI) {
		if(baseURI==null || baseURI.isEmpty()) {
			System.out.println("Enter the correct base URI either it is null or empty");
			return false;
		}
		try {
			RestAssured.baseURI = baseURI;
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured while assigning base URI");
			return false;
		}
	}
	

	
	private static RequestSpecification createRequest(String token,String contentType, Map<String ,String >paramsMap,boolean log) {

		RequestSpecification request;
		if (log) {
			request=RestAssured.given().log().all();
		} else {
			request=RestAssured.given();
		}

		if (token !=null) {
			request.header("Authorization","Bearer "+token);
		}

		if (!(paramsMap==null)) {
			request.queryParams(paramsMap);
		}

		if (contentType.equalsIgnoreCase("JSON")) {
			request.contentType(ContentType.JSON);
		} else if (contentType.equalsIgnoreCase("XML")){
			request.contentType(ContentType.XML);
		} else if (contentType.equalsIgnoreCase("Text")){
			request.contentType(ContentType.TEXT);
		} 

		return request;

	}

	private static Response getResponse(String httpMethod, RequestSpecification request,String basePath) {

		return executeAPI(httpMethod, request, basePath);
	}

	private static Response executeAPI(String httpMethod, RequestSpecification request,String basePath) {

		Response response=null;
		switch (httpMethod) {
		case "GET":
			response =request.get(basePath);
			break;
		case "POST":
			response =request.post(basePath);
			break;
		case "PUT":
			response =request.put(basePath);
			break;
		case "DELETE":
			response =request.delete(basePath);
			break;

		default:
			System.out.println("Please pass the correct http method");
			break;
		}
		return response;
	}
	
	public static void addRequestPayload(RequestSpecification request,Object obj) {
		String jsonPayload=TestUtil.getSerializedJSON(obj);
		request.body(jsonPayload);
	}











}

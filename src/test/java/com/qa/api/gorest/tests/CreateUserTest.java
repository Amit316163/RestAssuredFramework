package com.qa.api.gorest.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;

import io.restassured.response.Response;

public class CreateUserTest {
	
	
	String baseURI="https://gorest.co.in";
	String basePath="/public-api/users";
	String token="a0f3faa03639654ad8215aea7d17e289e2feaf83f34c84cd0808303fdf7aef91";
	
	@DataProvider
	public Object[][] getUserData() throws InvalidFormatException {
		Object userData[][] = ExcelUtil.getTestData("userdata");
		return userData;
	}
	
	@Test(dataProvider="getUserData")
	public void createUserTest(String firstname, String lastname, String gender, String dob, String email,
			String phonenumber, String website, String address, String status) {
	/*	User user=new User("Amit", "Singh", "male", "20-07-93", "amit@gmail.com", "5588555", "http//amit.com",
				"Pune","active");*/
		
		User user=new User(firstname, lastname, gender, dob, email, phonenumber, website, address, status);
		
		Response response=RestClient.doPost(baseURI, basePath, token, "JSON", null, true, user);
		System.out.println("Status code-->"+response.statusCode());
		System.out.println("Response body-->"+response.prettyPrint());
		
		
		
		
	
	}

}

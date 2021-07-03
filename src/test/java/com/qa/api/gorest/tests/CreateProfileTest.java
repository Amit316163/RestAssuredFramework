package com.qa.api.gorest.tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;
import com.qa.api.pojo2.Profile;
import com.qa.api.pojo2.SetLimits;

import io.restassured.response.Response;

public class CreateProfileTest {

	
	String baseURI="https://gorest.co.in";
	String basePath="/public-api/users";
	String token="a0f3faa03639654ad8215aea7d17e289e2feaf83f34c84cd0808303fdf7aef91";
	
	
	
	//Above baseURI and path are invalid -Here i am only try to generate the json in hard code way
	@Test()
	public void createProfileTest() {
		
		//this is one data set of list
		SetLimits set1=new SetLimits("channelABC", 5, 1, 10, "Raj");
		
		//Second data set of list
		SetLimits set2=new SetLimits("automation", 3, 3, 5, "Naveen");
		
		//create a list now
		List<SetLimits> allSet=new ArrayList<SetLimits>();
		allSet.add(set1);
		allSet.add(set2);
		
		//main pojo class constructor
		Profile profile=new Profile("USA", "XYZ", "automationlab", allSet);
		
		//Here i am only printing the json 
		Response response=RestClient.doPost(baseURI, basePath, token, "JSON", null, true, profile);
		
		//All data are passed as hard coded way...these data i want to pass it from excel using pojo classes
		//This api end point is invalid only my focus here for data driven approach for complex api--how we can do it
		//Please guide me Sir ...if you think is there any other approach --please create a video on youtube 
		//it will help all of us
		
		
		
		
	}
	
}

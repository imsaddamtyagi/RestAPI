package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {
	
	RestClient restClient;
	TestBase testBase;
	String serviceUrl;
	String apiUrl ;
	String url;
	
	
	@BeforeMethod
	public void setUP()
	{
		System.out.println("Inside Before Method");
		 testBase = new TestBase();	   // Getting data from properties file.
		 serviceUrl= prop.getProperty("SERVICEURL");   //    "https://reqres.in"
		 apiUrl = prop.getProperty("APIURL");         // "/api/users"		
		 url = serviceUrl+apiUrl;  												
	}
	
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException
	{
	    restClient  = new RestClient();
		restClient.get(url);	
		
	}
	

}

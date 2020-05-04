package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	
	//1.GET Method	
	public void get(String url) throws ClientProtocolException, IOException
	{		
	CloseableHttpClient httpClient = HttpClients.createDefault();   // create one client connection and will return an object.
    HttpGet httpget = new HttpGet(url);   // creates a request  GET connection with the URL.
    CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpget);   // "Hit the GET URL" It will return one closeable HTTP response.     
    int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
    System.out.println("Status code is: "+statusCode);     
    
    
    // Json String
   String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
   JSONObject responseJson = new JSONObject(responseString);	
   
   System.out.println("Response JSON from API: "+responseJson);
     
     // All Headers
    Header[] headersArray =closeableHttpResponse.getAllHeaders(); 
    HashMap<String,String> allHeaders = new HashMap<String,String>();  
    
    for(Header header:headersArray )
     {
    	 allHeaders.put(header.getName(), header.getValue());   	 
     }
     
        
        
		
	}
	

}

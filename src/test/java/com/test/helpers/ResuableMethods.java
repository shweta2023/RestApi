package com.test.helpers;

import java.util.concurrent.TimeUnit;

import com.tests.models.AddUserPOJO;

import io.restassured.response.Response;

public class ResuableMethods {
    public static AddUserPOJO user;
    
    public static AddUserPOJO getUserDataToAdd() {
    	user = new AddUserPOJO();
    	user.setAccountno("TA-Aug2207");
    	user.setDepartmnetno("1");
    	user.setSalary("12000");
    	user.setPincode("124124");
    	return user;
    	
    }
    
    public int getStatusCode(Response response) {
    	return response.getStatusCode();
    	
    }
    
    public String getContentType(Response response) {
    	return response.getContentType();
    
    }
    
    public long getResponseTimeIn(Response response,TimeUnit unit) {
    	return response.getTimeIn(unit);
    
    }
    public static void  verifyStatusCodeIs(Response response,int statuscode) {
    	 response.then().statusCode(statuscode); 
    
    }
   // public String getJsonPathData(Response response,) {
    	
}

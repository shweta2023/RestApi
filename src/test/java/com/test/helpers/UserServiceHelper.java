package com.test.helpers;


import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.test.tests.CommonUtilities;
import com.tests.constants.Endpoints;
import com.tests.models.AddUserPOJO;
import com.tests.models.LoginObjectPojo;
import com.tests.models.UserPOJO;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
public class UserServiceHelper {
	private static Response response;
	private static String token = null;
	public static CommonUtilities CU = new CommonUtilities();
    public static  Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
    
    public static String getBaseUri() {
    	String baseURI = CU.getApplicationProperty("baseurl",applicationPropertiesFile);
    	return baseURI;
    }
    
    public static Response LoginToApplication() {
    	
    	String username = CU.getApplicationProperty("username",applicationPropertiesFile);
    	String password = CU.getApplicationProperty("password",applicationPropertiesFile);
    	LoginObjectPojo ob = new LoginObjectPojo();
    	ob.setUsername(username);
    	ob.setPassword(password);
    	response =RestAssured.
    			 given().
    			 contentType("application/json").
    			 body(ob).
    			 when().
    			 post(Endpoints.LOGIN);
    			 
        return response;

    }
    public static String getToken() {
    	response = LoginToApplication();
    	token = response.jsonPath().get("[0].token");
    	return token;
    	
    }
    
    public static List<UserPOJO> getUserData(){
    	Header header =new Header("token",token);
    	System.out.println("user dsata token===="+ token);
    	response = RestAssured.given().header(header)
    			   .when()
    			   .get(Endpoints.GET_DATA);
    	UserPOJO[] userarray = response.as(UserPOJO[].class);
    	List<UserPOJO> list = Arrays.asList(userarray );
    	response.then().statusCode(200);
    	System.out.println("number of records="+response.jsonPath().get("$.size()"));
    	return list;	
    	
    }
    public static Response addUserData() {
    	Header header = new Header("token",token);
    	AddUserPOJO user = ResuableMethods.getUserDataToAdd();
    	response = RestAssured.given().contentType("appplication/json").header(header)
    			   .body(user)
    			   .when()
    	           .post(Endpoints.ADD_DATA);
    	
    	return response;
    	
    }
    
    public static Response updateUserdata() {
    	UserPOJO updateUser = new UserPOJO();
    	List<UserPOJO> listOfUsers = getUserData();
    	for(UserPOJO userToBeUpdated:listOfUsers) {
    		if(userToBeUpdated.getAccountno().equals(ResuableMethods.user.getAccountno())) {
    			updateUser =userToBeUpdated;
    			updateUser.setDepartmentno("");
    		
    			}
    }
    	Header header = new Header("token",token);
    	response = RestAssured.given().contentType("appplication/json").header(header)
 			   .body(updateUser)
 			   .when()
 	           .put(Endpoints.UPDATE_DATA);
 	
 	return response;
    	
    }
    
   public static void deleteUserdata() {
    	String id = null;
    	String userId = null;
    	if(token==null) {
    		getToken();
    	}
    	List<UserPOJO> listOfUsers = getUserData();
    	
    	
    	}
    }
               
    
    
    
    
    


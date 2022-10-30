package com.test.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.helpers.ResuableMethods;
import com.test.helpers.UserServiceHelper;
import com.tests.models.UpdateUserPojo;
import com.tests.models.UserPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TekarchApiTestScript extends UserServiceHelper {
	@BeforeMethod
	public static void setUp() {
		RestAssured.baseURI=  getBaseUri();
	}
	@Test(enabled=false)
	public static  void TC_01_validLogin() {
		String token = getToken();
		System.out.println("token======"+ token);
		
		
	}
	
	@Test(enabled=false)
	public static  void TC_02_getUserData() {
		String token = getToken();
		List<UserPOJO> listOfUsers = getUserData();
		System.out.println("first account no="+listOfUsers.get(0).getAccountno());
		}	
	
	@Test(enabled=true)
	public static  void TC_03_addUserData() {
		//String token = getToken();	
    Response res = addUserData();
    ResuableMethods.verifyStatusCodeIs(res,200);
    res.then().body("status",Matchers.equalTo("success"));
	
	}		
	
	
	
	@Test(enabled=false)
	public static  void TC_04_updateUserData() {
		
    Response res = updateUserdata();
    ResuableMethods.verifyStatusCodeIs(res,200);
    System.out.println("data been updated........");
    res.then().body("status",Matchers.equalTo("success"));
	
	}		
	
	@Test(enabled=false)
	public static  void TC_0f_deleteUserData() {
		
   // Response res = deleteUserdata();
   // ResuableMethods.verifyStatusCodeIs(res,200);
   // System.out.println("deleted successfully");
   // res.then().body("status",Matchers.equalTo("success"));
	
	}		
	
}

	
	
	

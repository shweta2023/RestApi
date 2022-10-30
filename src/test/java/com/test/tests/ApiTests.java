package com.test.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.tests.models.RequestPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ApiTests {
	
	
	@Test(enabled=false)
	public void test_01Get(){
		
		given().
		 get("https://reqres.in/api/users?page=2").
		 then().
		 statusCode(200).
		 body("data.id[0]",equalTo(7)).
		log().all();
	}
@Test(enabled=false)

public void test_2Post() {
	RequestPojo ob = new RequestPojo();
      ob.setName("morpheus");
      ob.setJob("leader");
      System.out.println(ob.toString());
    			given().
    			body(ob).
    			contentType(ContentType.JSON).
    			when().
    			post("https://reqres.in/api/users").
    			then().
    		    statusCode(201).
    		    log().all();
	
}

	
@Test(enabled=false)

public void test_3Put() {
	RequestPojo ob = new RequestPojo();
      ob.setName("morpheus");
      ob.setJob("Zion Resident");
      System.out.println(ob.toString());
    			given().
    			body(ob).
    			contentType(ContentType.JSON).
    			when().
    			put("https://reqres.in/api/users/2").
    			then().
    		    statusCode(200).
    		    log().all();
	
}	
@Test

public void test_3delete() {
	
    			when().
    			delete("https://reqres.in/api/users/2").
    			then().
    		    statusCode(204).
    		    log().all();
	
}	








}

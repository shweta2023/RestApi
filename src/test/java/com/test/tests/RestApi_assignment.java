package com.test.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.tests.models.RequestPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestApi_assignment {
	
	@Test(enabled=true)
	public void test_01(){
		RequestSpecification req= RestAssured.given();
		
		Response res= req.when().get("https://dummy.restapiexample.com/api/v1/employees");
		res.prettyPrint();
		res.then().body("status",Matchers.equalTo("success")).
		
		log().all();
		System.out.println("num of data ="+res.jsonPath().get("data.size()"));
		//validate employee name=Herrod Chandler whose id is 7
		String employeename =res.path("data.find{it.id==7}.employee_name");
		System.out.println("Employeename:"+employeename);
		//res.then().body("data.find{it.id==7}.employee_name",equalTo("Herrod Chandler"));
		//extract all employee details whose salary is >300000
	    ArrayList<Map<String,?>> allemployeesalary  = res.path("data.findAll{ it.employee_salary>30000 }");
		System.out.println("All the employee salaryis greater then 30000\n"+allemployeesalary);
		//List<String> name = res.path("data.findall{it.employee_salary>30000}.employee_name");
		//for(int i=0;i<name.size();i++) {
		//	System.out.println("employee name are :"+name.get(i));
		}
		
		
	}
	

		
		
		


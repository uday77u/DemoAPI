package com.api.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;

import static io.restassured.RestAssured.*; //improves the readability --no need to use class name(RestAssured) before method
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAPI {
	@Test
	public void loginTest() {
	    /*//basics
		RestAssured.baseURI="http://64.227.160.186:8080";
	    RequestSpecification x=RestAssured.given();
	    RequestSpecification y=x.header("Content-Type", "application/json");
	    RequestSpecification z=y.body("{\"username\": \"uday1234\" ,\"password\": \"uday1234\"}");
	    Response response=z.post("/api/auth/login");	
	    System.out.println("response: "+response.asPrettyString());
	    
	    assertEquals(response.statusCode(), 200);
	    */
		
		//Optimize the code
		/*
		Response response=given().baseUri("http://64.227.160.186:8080")
										.header("Content-Type", "application/json")
										.body("{\"username\": \"uday1234\" ,\"password\": \"uday1234\"}")
										.post("/api/auth/login");
		
		    System.out.println("response: "+response.asPrettyString());
		    
		    assertEquals(response.statusCode(), 200);
		    */
		/*
		//hardcoded payload
		AuthService authService=new AuthService();
		Response response =authService.login("{\"username\": \"uday1234\" ,\"password\": \"uday1234\"}");
		System.out.println(response.asPrettyString());
		
		assertEquals(response.statusCode(), 200);
		*/
		
		LoginRequest loginRequest=new LoginRequest("uday1234", "uday1234");
		AuthService authService=new AuthService();
		Response response =authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		
		assertEquals(response.statusCode(), 401);
		
}
	
	
}

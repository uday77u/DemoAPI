package com.api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.api.filters.ApiLoggingFilter;

import io.restassured.RestAssured;

public class BaseTest {
	public static Logger logger;
	
	@BeforeSuite
	public void setup1() {

	    RestAssured.filters(new ApiLoggingFilter());
	}

	@BeforeClass
	public void setup() {
		logger=LogManager.getLogger(this.getClass());
		logger.debug("**** Logging test cases started ****");
	}
	
	
}

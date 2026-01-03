package com.api.filters;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;
import com.api.utilities.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Fakestoreapi_baseService {
/*
	  protected RequestSpecification requestSpecification;
	    protected Logger logger;

	    public Fakestoreapi_baseService() {
	        logger = LogManager.getLogger(this.getClass());

	        requestSpecification = given()
	                .baseUri(ConfigManager.getProperty("baseURI"))
	                .contentType(ContentType.JSON)
	                .filter(new LoggingFilter(logger));
	    }*/
}

package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
//import io.restassured.filter.FilterableRequestSpecification;
//import io.restassured.filter.FilterableResponseSpecification;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
/*
    private final Logger logger;

    public LoggingFilter(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext context) {

        // Log Request
        logger.info("REQUEST:");
        logger.info("URI: " + requestSpec.getURI());
        logger.info("Method: " + requestSpec.getMethod());
        logger.info("Headers: " + requestSpec.getHeaders());
        logger.info("Body: " + requestSpec.getBody());

        Response response = context.next(requestSpec, responseSpec);

        // Log Response
        logger.info("RESPONSE:");
        logger.info("Status Code: " + response.getStatusCode());
        logger.info("Headers: " + response.getHeaders());
        logger.info("Body: " + response.asPrettyString());

        return response;
    }*/
}

package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
//import io.restassured.filter.FilterableRequestSpecification;
//import io.restassured.filter.FilterableResponseSpecification;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import org.apache.logging.log4j.Logger;

public class ConditionalLoggingFilter implements Filter {

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
/*
    private final Logger logger;

    public ConditionalLoggingFilter(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext context) {

        Response response = context.next(requestSpec, responseSpec);

        if (response.getStatusCode() >= 400) {
            logger.error("REQUEST FAILED");
            logger.error("URI: " + requestSpec.getURI());
            logger.error("Method: " + requestSpec.getMethod());
            logger.error("Headers: " + requestSpec.getHeaders());
            logger.error("Body: " + requestSpec.getBody());

            logger.error("RESPONSE:");
            logger.error("Status Code: " + response.getStatusCode());
            logger.error("Headers: " + response.getHeaders());
            logger.error("Body: " + response.asPrettyString());
        }
        return response;
    }*/
}

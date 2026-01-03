package com.api.utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;

public class AssertionsUtil {
public Logger logger;
public  AssertionsUtil() {
	logger=LogManager.getLogger(getClass());
}
    public static void assertStatusCode(Response response, int expectedStatus, Logger logger) {
        int actualStatus = response.getStatusCode();
        logger.info("Status Code: " + actualStatus);
        assertEquals(actualStatus, expectedStatus,
                "Expected status code " + expectedStatus + " but got " + actualStatus);
    }

    public static void assertStatusLine200(Response response, Logger logger) {
        String expected = ConfigManager.getProperty("expectedStatusLine200");
        String actual = response.getStatusLine();
        logger.info("Status Line: " + actual);
        assertEquals(actual, expected, "Unexpected status line");
    }

    public static void assertStatusLine201(Response response, Logger logger) {
        String expected = ConfigManager.getProperty("expectedStatusLine201");
        String actual = response.getStatusLine();
        logger.info("Status Line: " + actual);
        assertEquals(actual, expected, "Unexpected status line");
    }
    public static void assertResponseTime(Response response, Logger logger) {
        int warnThreshold = ConfigManager.getIntProperty("warnResponseTime");
        int failThreshold = ConfigManager.getIntProperty("failResponseTime");

        long responseTime = response.getTime();
        logger.info("Response Time: " + responseTime + " ms");

        if (responseTime > warnThreshold) {
            logger.warn("Response time is high: " + responseTime + " ms");
        }

        assertTrue(responseTime < failThreshold,
                "Response time exceeds " + failThreshold + " ms ==> " + responseTime + " ms");
    }

    public static void assertContentType(Response response, String expected, Logger logger) {
        String actualContentType = response.getContentType();
        logger.info("Content-Type: " + actualContentType);
        assertTrue(actualContentType.contains(expected),
                "Expected Content-Type containing '" + expected + "' but got: " + actualContentType);
    }

    public static void assertServerType(Response response, Logger logger) {
        String expected = ConfigManager.getProperty("expectedServer");
        String actual = response.getHeader("Server");
        logger.info("Server: " + actual);
        assertEquals(actual, expected, "Unexpected server type");
    }
}

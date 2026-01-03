package com.api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		logger=LogManager.getLogger(this.getClass());
		logger.debug("**** Logging test cases started ****");
	}
	
	
}

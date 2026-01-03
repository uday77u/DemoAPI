package com.api.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("🔹 STARTING TEST: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✅ PASSED TEST: " + result.getMethod().getMethodName()+"\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("❌ FAILED TEST: " + result.getMethod().getMethodName()+"\n");
        if (result.getThrowable() != null) {
            logger.error("Reason: " + result.getThrowable().getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⚠️ SKIPPED TEST: " + result.getMethod().getMethodName()+"\n");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("🚀 Starting TestNG Suite: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("🏁 Finished TestNG Suite: " + context.getName());
    }
}

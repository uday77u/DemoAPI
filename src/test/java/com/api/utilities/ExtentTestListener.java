package com.api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import java.awt.Desktop;
import java.io.File;

public class ExtentTestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(ExtentTestListener.class);
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("===== STARTING TEST: {} =====", result.getMethod().getMethodName());
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("===== TEST PASSED: {} =====", result.getMethod().getMethodName());
        testReport.get().log(Status.PASS, "Test Passed");
/*
        try {
            Object instance = result.getInstance();
            if (instance instanceof BaseTest) {
                String responseBody = ((BaseTest) instance).response.getBody().asString();
                logResponseInline(responseBody, Status.PASS);
            }
        } catch (Exception e) {
            logger.error("Error capturing response for passed test", e);
        }*/
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("===== TEST FAILED: {} =====", result.getMethod().getMethodName());
        testReport.get().log(Status.FAIL, result.getThrowable());
/*
        try {
            Object instance = result.getInstance();
            if (instance instanceof com.api.test.BaseTest) {
                String responseBody = ((com.api.test.BaseTest) instance).response.getBody().asString();

                // Save response to file
                String filePath = ReportUtils.saveResponseToFile(responseBody);
                if (filePath != null) {
                    testReport.get().fail("Full API Response saved")
                            .addScreenCaptureFromPath(filePath);
                }

                logResponseInline(responseBody, Status.FAIL);
            }
        } catch (Exception e) {
            logger.error("Error capturing API response for failed test", e);
        }*/
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("===== TEST SKIPPED: {} =====", result.getMethod().getMethodName());
        testReport.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("===== ALL TESTS FINISHED =====");
        extent.flush();

        try {
            File reportFile = new File(ExtentManager.getReportPath());
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
                logger.info("Latest Extent Report opened: {}", reportFile.getAbsolutePath());
            }

            File dashboardFile = new File("target/extent-report/index.html");
            if (dashboardFile.exists()) {
                Desktop.getDesktop().browse(dashboardFile.toURI());
                logger.info("Dashboard Report opened: {}", dashboardFile.getAbsolutePath());
            }
        } catch (Exception e) {
            logger.error("Failed to open Extent Report", e);
        }
    }

    // 🔹 Helper method to log inline response body
    private void logResponseInline(String responseBody, Status status) {
        if (responseBody != null) {
            String snippet = responseBody.length() > 500
                    ? responseBody.substring(0, 500) + "... [truncated]"
                    : responseBody;
            testReport.get().log(status, "Response Body: " + snippet);
        }
    }
}

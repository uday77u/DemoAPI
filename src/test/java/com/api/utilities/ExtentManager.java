package com.api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportPath;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    public static ExtentReports createInstance() {
        // 📌 Folder for all reports
        String reportDir = "target/extent-report/";

        // 📌 Unique report file with timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        reportPath = reportDir + "extent-report-" + timestamp + ".html";

        // Main Spark Reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        // 📌 Dashboard "index.html" that aggregates all reports
        ExtentSparkReporter dashboard = new ExtentSparkReporter(reportDir + "index.html");

        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setDocumentTitle("fakestoreapi API Test Report");
        sparkReporter.config().setReportName("API Test Results - " + timestamp);
        sparkReporter.config().setTheme(Theme.STANDARD);

        dashboard.config().setDocumentTitle("fakestoreapi - Dashboard");
        dashboard.config().setReportName("Execution Dashboard (All Runs)");
        dashboard.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter, dashboard);

        return extent;
    }

    // 🔑 Getter for latest report file path
    public static String getReportPath() {
        return reportPath;
    }
}

package com.kraftechnologie.tests.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtendReportDemo {
    // This class is used for starting and building reports
    ExtentReports report;
    //This class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;
    //This will define a test, enable adding logs, authors and steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //initialize the class
        report =new ExtentReports();
        //create  a report path
        //get the project path of local
        String projectPath = System.getProperty("user.dir");
        String path=projectPath+"/test-output/report.html";

        //initialize the html report to the report path
        htmlReporter=new ExtentHtmlReporter(path);
        //attach the html report with the report path
        report.attachReporter(htmlReporter);
        //title in report
        htmlReporter.config().setReportName("kraftechnologie Smoke Test");
        //set environment information
        report.setSystemInfo("Environment","Stage");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","YY");

    }

    @Test
    public void t_reportInfo() {
        //give a name to the current test
        extentLogger=report.createTest("TC001 Login Test");
        //Test step
        extentLogger.info("Open The Browser");
        extentLogger.info("Go to url https://www.krafttechexlab.com/login");
        extentLogger.info("Login as Mike");
        extentLogger.info("Enter mike email");
        extentLogger.info("Enter mike password");
        extentLogger.info("Click Login Button");
        extentLogger.info("Verify logged in");
        extentLogger.pass("TC001 Login Test is Passed");
    }

    @AfterMethod
    public void tearDown() {
        report.flush();
    }
}

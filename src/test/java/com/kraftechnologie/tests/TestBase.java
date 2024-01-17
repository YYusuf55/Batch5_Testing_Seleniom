package com.kraftechnologie.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    // This class is used for starting and building reports
    protected ExtentReports report;
    //This class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;
    //This will define a test, enable adding logs, authors and steps
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest() {
        //initialize the class
        report = new ExtentReports();
        //create  a report path
        //get the project path of local
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";
       // String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
      //  String path = projectPath + "/test-output/report"+date+".html";


        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("kraftechnologie Smoke Test");
        //set environment information
        report.setSystemInfo("Environment", "Stage");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "YY");

    }

    @AfterTest
    public void tearDownTest() {
        report.flush();
    }


    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        //driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            //Record the name of the failed test
            extentLogger.fail(result.getName());
            //Take the screenshot and return the location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //Add the screenshot to the rapor
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //Capture the exception and put  inside the report
            extentLogger.fail(result.getThrowable());
        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}

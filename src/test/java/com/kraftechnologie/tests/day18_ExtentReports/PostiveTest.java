package com.kraftechnologie.tests.day18_ExtentReports;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PostiveTest extends TestBase {

    @Test
    public void t_loginTest() {
        LoginPage loginPage=new LoginPage();
        extentLogger=report.createTest("Positive Login Test");
        extentLogger.info("navigates to "+ ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter "+ ConfigurationReader.get("name") +"'s valid credentials");
        loginPage.login();

    }
}

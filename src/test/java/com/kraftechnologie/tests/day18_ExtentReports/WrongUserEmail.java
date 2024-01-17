package com.kraftechnologie.tests.day18_ExtentReports;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUserEmail extends TestBase {

    @Test
    public void t_wrongUserEmail() {
        extentLogger= report.createTest("Wrong User Email Test 1");
        LoginPage loginPage=new LoginPage();

        extentLogger.info("navigates to "+ ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("enter wrong email");
        loginPage.l_emailInputBox.sendKeys("wrong@gmail.com"); // wrong email
        extentLogger.info("enter "+ConfigurationReader.get("name")+" password");
        loginPage.l_passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        extentLogger.info("Click Login Button");
        loginPage.l_loginBtn.click();

        String actualMessage=loginPage.l_wrongEmailMessage.getText();

        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Email address is incorrect. Please check");

        extentLogger.pass("PASSED");

    }
    @Test
    public void t_wrongUserPassword() {
        extentLogger= report.createTest("Wrong User Password Test 2");
        LoginPage loginPage=new LoginPage();

        extentLogger.info("navigates to "+ ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("enter "+ConfigurationReader.get("name")+" email");
        loginPage.l_emailInputBox.sendKeys(ConfigurationReader.get("email"));
        extentLogger.info("enter wrong password");
        loginPage.l_passwordInputBox.sendKeys("wrong password"); // wrong password
        extentLogger.info("Click Login Button");
        loginPage.l_loginBtn.click();

        String actualMessage=loginPage.l_wrongPasswordMessage.getText();

        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Password is incorrect. Please check");

        extentLogger.pass("PASSED");
    }
}

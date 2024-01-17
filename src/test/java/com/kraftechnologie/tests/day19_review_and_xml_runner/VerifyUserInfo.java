package com.kraftechnologie.tests.day19_review_and_xml_runner;

import com.kraftechnologie.pages.*;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.bouncycastle.jcajce.provider.asymmetric.EXTERNAL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /** Class Task d19 01
     *  navigate to kraft login page
     *  Login as a mike
     *  Verify that login is successfully
     *  Click on My Profile button
     *  Click on Edit Profile button
     *  Verify that job is QA Test Engineer
     *  Click on go back button
     *  Verify that Dashboard page is displayed
     */

    @Test
    public void t1_userInfo() {
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        OverviewPage overviewPage=new OverviewPage();
        EditProfilePage editProfilePage=new EditProfilePage();

        extentLogger=report.createTest("User Info Verification");
        extentLogger.info("navigate to "+ ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter"+ConfigurationReader.get("name")+" email ");
        loginPage.l_emailInputBox.sendKeys(ConfigurationReader.get("email"));
        extentLogger.info("Enter "+ConfigurationReader.get("name")+" password");
        loginPage.l_passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        extentLogger.info("Click login button");
        loginPage.l_loginBtn.click();
        extentLogger.info("Verify that login is successfull");
        BrowserUtils.waitFor(2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.krafttechexlab.com/index");
        extentLogger.info("Verify that login is succersful from dashboard page and account name is "
                +ConfigurationReader.get("name"));
        String actualAccountName = dashboardPage.getAccountName(ConfigurationReader.get("name"));
        System.out.println("actualAccountName = " + actualAccountName);
        Assert.assertEquals(actualAccountName,ConfigurationReader.get("name"));

        extentLogger.info("Click on My Profile button");
        dashboardPage.navigateToModule(ConfigurationReader.get("name"),"My Profile");
        extentLogger.info(" Click on Edit Profile button");
        overviewPage.navigateToMenu("Edit Profile");
        String jobName="QA Test Engineer";
        extentLogger.info("Verify that job is"+jobName);
        System.out.println("editProfilePage.jobDropDownMenu.getText() = " + editProfilePage.getJobName());
        Assert.assertEquals(editProfilePage.getJobName(),jobName);
        extentLogger.info("Click on go back button");
        driver.navigate().back();

        //HW verify email, company and finish the task
        extentLogger.info("Passed");







    }
}

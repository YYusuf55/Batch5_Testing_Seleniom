package com.kraftechnologie.tests.day16_POM2;

import com.kraftechnologie.pages.BasePage;
import com.kraftechnologie.pages.DashboardPage;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardTest extends TestBase {


    @Test
    public void basicDashboardMenuTest() {
        /**

         login with Mike
         verify that you are on the dashboard:
         "About" is visible
         "Profile Page" is visible
         Verify followings with BrowserUtils method
         Dashboard
         Developers
         Components
         Forms
         JavaScript
         mike
         */

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        String actual = dashboardPage.aboutElement.getText();
        String expected = "About";
        Assert.assertEquals(actual, expected);


        String actualProfile = BrowserUtils.getElementText(dashboardPage.profileDetails);
        String expectedProfile = "Profile Details";

        Assert.assertEquals(actualProfile, expectedProfile);

        //verify uptitles;
        List<String> actualTitles = BrowserUtils.getElementsText(dashboardPage.upTitles);
        List<String> expectedTitles = new ArrayList<>(Arrays.asList("Dashboard", "Developers", "Components", "Forms", "JavaScript", "mike"));
        Assert.assertEquals(actualTitles, expectedTitles);

    }

    @Test
    public void navigateMenu1() {
        /**

         login with Mike
         go to 'developers' tab via navigateToModule()
         validate that you are on the right page through url*/

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        loginPage.navigateToModule("Developers");

        BrowserUtils.waitFor(2);
        String actual = driver.getCurrentUrl();
        String expected="https://www.krafttechexlab.com/developers";
        Assert.assertEquals(actual,expected);
    }

    //method OVERLODİNG
    @Test
    public void navigateMenu2() {
        /**

         login with Mike
         go to 'Components --> Modal' submodule via navigateToModule()
         validate that you are on the right page through url*/

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        loginPage.navigateToModule("Components","Modal");

        BrowserUtils.waitFor(2);
        String actual = driver.getCurrentUrl();
        String expected="https://www.krafttechexlab.com/components/modal";
        Assert.assertEquals(actual,expected);
    }





}


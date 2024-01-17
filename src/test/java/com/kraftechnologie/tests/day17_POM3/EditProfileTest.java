package com.kraftechnologie.tests.day17_POM3;

import com.kraftechnologie.pages.EditProfilePage;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.pages.OverviewPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfileTest extends TestBase {
    /**
     * Class Task
     * THIS TASK WILL BE IMPLEMENTED USING POM
     * which means we will have one test class for the test
     * and one corresponding page having all locators and actions for the page
     * go to https://www.krafttechexlab.com/login
     * enter valid credentials
     * --> john@gmail.com
     * --> John1234.
     * go to John --> myProfile
     * create a method that navigate you to specific module based on the given parameter
     * go to Edit Profile page using the method just mentioned above
     * fill out the fields
     * -->about --> SDET programme , graduated from KraftTech
     * -->Company --> Apple
     * -->Job  --> QA Automation Engineer
     * -->Website --> www.google.com
     * -->Location --> Istanbul
     * -->Skills --> Java,Selenium, TestNG
     * click save changes button
     * verify that "profile updated" appears
     */

    @Test
    public void test() {

        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();

        //create an object from LoginPage class
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("email2"), ConfigurationReader.get("password2"));

        //go to My Profile
        loginPage.navigateToModule("John", "My Profile");

        //create an object from Overview class
        OverviewPage overviewPage = new OverviewPage();
        overviewPage.navigateToMenu("Edit Profile");

        BrowserUtils.waitFor(3);

        //create an object from EditProfile page
        EditProfilePage editProfilePage = new EditProfilePage();
        editProfilePage.aboutTextBox.sendKeys("SDET programme , graduated from KraftTech");
        editProfilePage.companyTextBox.sendKeys("Apple");


        //select QA Actumatin enginer from dropdown menu
        //Select select=new Select(editProfilePage.jobDropDownMenu);
        // select.selectByVisibleText("QA");

        editProfilePage.selectJob("QA");

        editProfilePage.webSiteTexbox.sendKeys("www.apple.com");
        editProfilePage.locationTextBox.sendKeys("Ankara");
        editProfilePage.skillsTextBox.sendKeys("Java, Selenium, TestNG, Cucumber, SQL, API, KARATE, Cypress, JMeter");

        //click on save button
        //editProfilePage.saveButton.click();
        //BrowserUtils.clickWithJS(editProfilePage.saveButton);
        editProfilePage.clickOnSaveButton();

        //verification
        String actual = BrowserUtils.getElementText(overviewPage.profileUpdated);
        String expected = "Profile Updated";
        Assert.assertEquals(actual,expected);

        BrowserUtils.waitFor(3);



    }
}

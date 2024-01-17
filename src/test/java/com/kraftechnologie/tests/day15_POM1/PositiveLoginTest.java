package com.kraftechnologie.tests.day15_POM1;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    /**
     * Class Task 2 wrong username
     * go to kraft login page
     * provide valid credentials
     * verify that login successfully
     */
    LoginPage loginPage;

    @Test
    public void t1_loginTest() throws InterruptedException {

        driver.get(ConfigurationReader.get("url"));
        loginPage = new LoginPage();
        loginPage.l_emailInputBox.sendKeys(ConfigurationReader.get("email"));
        loginPage.l_passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.l_loginBtn.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.krafttechexlab.com/index");

    }

    /**
     * Class Task 2 wrong username
     * go to kraft login page
     * login as a mike
     * verify that login successfully
     */

    @Test
    public void t2_loginTest() throws InterruptedException {

        driver.get(ConfigurationReader.get("url"));
        loginPage = new LoginPage();
        loginPage.login();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.krafttechexlab.com/index");

    }

    /**
     * Class Task 2 wrong username
     * go to kraft login page
     * enter "john@gmail.com"
     * enter password as "John1234."
     * verify that login successfully
     */
    @Test
    public void t3_loginTest() throws InterruptedException {

        driver.get(ConfigurationReader.get("url"));
        loginPage = new LoginPage();
        loginPage.login("john@gmail.com", "John1234.");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.krafttechexlab.com/index");

    }


}

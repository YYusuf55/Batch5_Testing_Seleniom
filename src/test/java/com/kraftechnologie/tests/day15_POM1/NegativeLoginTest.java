package com.kraftechnologie.tests.day15_POM1;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage;

    /**
     * Class Task 1 wrong password
     * go to kraft login page
     * provide right userEmail
     * provide wrong password
     * click login button
     * verify that "Password is incorrect. Please check" message is displayed
     */
    @Test
    public void t1_wrongPassword() {
        driver.get(ConfigurationReader.get("url"));
//        WebElement emailInputBox = driver.findElement(By.id("email"));
//        WebElement passwordInputBox = driver.findElement(By.id("yourPassword"));
//        emailInputBox.sendKeys(ConfigurationReader.get("email"));
//        passwordInputBox.sendKeys("somePassword");
//        driver.findElement(By.cssSelector("[type='submit']")).click();
//        WebElement warningMessage = driver.findElement(
//                By.xpath("//*[contains(text(),'Password is incorrect. Please check')]"));
//        Assert.assertEquals(warningMessage.getText(),
//                "Password is incorrect. Please check",
//                "Verify that user is NOT login.");

       // LoginPage loginPage = new LoginPage();
        loginPage = new LoginPage();
        loginPage.l_emailInputBox.sendKeys(ConfigurationReader.get("email"));
        loginPage.l_passwordInputBox.sendKeys("somePassword");
        loginPage.l_loginBtn.click();
        Assert.assertEquals(loginPage.l_wrongPasswordMessage.getText(),
                "Password is incorrect. Please check");

    }

    /**
     * Class Task 2 wrong username
     * go to kraft login page
     * provide wrong userEmail
     * provide right password
     * click login button
     * verify that "Email address is incorrect. Please check" message is displayed
     */

    @Test
    public void t2_wrongEmail() {
        driver.get(ConfigurationReader.get("url"));
        loginPage = new LoginPage();
        loginPage.l_emailInputBox.sendKeys("someEmail");
        loginPage.l_passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.l_loginBtn.click();
        Assert.assertEquals(loginPage.l_wrongEmailMessage.getText(),
                "Email address is incorrect. Please check");
    }

}

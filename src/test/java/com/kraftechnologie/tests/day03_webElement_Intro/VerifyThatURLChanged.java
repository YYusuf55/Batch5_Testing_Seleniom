package com.kraftechnologie.tests.day03_webElement_Intro;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLChanged {
    /**
     * Class Task D302
     * open chrome browser
     * go to https://www.krafttechexlab.com/login
     * enter email as mike@gmail.com
     * enter password as mike1234
     * click login btn
     * verify that Url has changed
     */
    public static void main(String[] args) throws InterruptedException {
          WebDriver driver= WebDriverFactory.getDriver("chrome");
          driver.get("https://www.krafttechexlab.com/login");
          String email="mike@gmail.com";
          String password="mike1234";
        //enter email
        WebElement emailInputBox = driver.findElement(By.id("email"));
        // sendKeys(...) => to type in input element
        //emailInputBox.sendKeys("mike@gmail.com");
        emailInputBox.sendKeys(email);

        // enter password
        WebElement passwordInputBox = driver.findElement(By.id("yourPassword"));
        passwordInputBox.sendKeys(password);

        //click login button
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        String expectedUrl="https://www.krafttechexlab.com/index";
        String actualUrl= driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);
        System.out.println("actualUrl = " + actualUrl);

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
        }

        Thread.sleep(2000);
        driver.close();
    }
}

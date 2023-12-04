package com.kraftechnologie.tests.day03_webElement_Intro;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmationMessage {

    /**
     * Class Task D303
     * open chrome browser
     * go to https://www.krafttechexlab.com/login  page
     * enter email as mike@gmail.com
     * enter password as mike1234
     * click login button
     * verify that username is "mike"
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        String email="mike@gmail.com";
        String password="mike1234";
        String expectedProfilUsername="mike";
        //enter email
        WebElement emailInputBox = driver.findElement(By.id("email"));
        emailInputBox.sendKeys(email);

        // enter password
        WebElement passwordInputBox = driver.findElement(By.id("yourPassword"));
        passwordInputBox.sendKeys(password);

        //click login button
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();

        // 2 ways to get text from web element
        // 1. way => getText() --> it will work %99 , it returns String
        //2. way => getAttribute("name")--> it returns String and it will get attribute value

        Thread.sleep(2000);
        WebElement profilUsername = driver.findElement(By.cssSelector("[class='d-none d-md-block dropdown-toggle ps-2']"));
        String actualProfilUsername= profilUsername.getText();
        System.out.println("actualProfilUsername = " + actualProfilUsername);

        if (expectedProfilUsername.equals(actualProfilUsername)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
        }

        Thread.sleep(2000);
       // driver.close();
    }
}

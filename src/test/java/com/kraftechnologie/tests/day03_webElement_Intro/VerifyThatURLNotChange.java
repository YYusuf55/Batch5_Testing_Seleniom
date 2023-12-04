package com.kraftechnologie.tests.day03_webElement_Intro;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLNotChange {
    /**
     * Class Task D301
     * open the chrome browser
     * go to https://www.krafttechexlab.com/login page
     * click login button
     * verify that url did NOT changed
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);
        String expectedUrl= driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);
        // findElement() and click()
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();

        //String expectedUrl = "https://www.krafttechexlab.com/login";
        String actualUrl = driver.getCurrentUrl();
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

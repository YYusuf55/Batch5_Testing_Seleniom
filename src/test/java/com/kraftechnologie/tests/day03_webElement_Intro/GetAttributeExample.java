package com.kraftechnologie.tests.day03_webElement_Intro;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttributeExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement emailInputBox = driver.findElement(By.id("email"));
        String value=emailInputBox.getAttribute("type");
        System.out.println("value = " + value);
        System.out.println("emailInputBox.getAttribute(\"name\") = " + emailInputBox.getAttribute("name"));
        System.out.println("emailInputBox.getAttribute(\"class\") = " + emailInputBox.getAttribute("class"));


        Thread.sleep(2000);
        //driver.close();

    }
}

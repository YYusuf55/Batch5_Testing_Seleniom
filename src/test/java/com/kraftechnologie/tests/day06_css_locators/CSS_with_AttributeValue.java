package com.kraftechnologie.tests.day06_css_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_AttributeValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        //css with attrıbute&value
        WebElement emailInputBox = driver.findElement(By.cssSelector("[name='email']"));
        emailInputBox.sendKeys("mike@gmail.com");


        //css with taagName and attribute & value => xpath ("//input[@type='password']")
        WebElement passwordInputBox = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInputBox.sendKeys("mike1234");


        Thread.sleep(3000);
        driver.close();


    }

}

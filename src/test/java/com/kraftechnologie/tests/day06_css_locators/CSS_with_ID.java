package com.kraftechnologie.tests.day06_css_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_ID {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        //driver.manage().window().maximize();

        WebElement emailInputBox = driver.findElement(By.cssSelector("#email"));
        emailInputBox.sendKeys("mike@gmail.com");

        Thread.sleep(2000);
        driver.close();

    }
}

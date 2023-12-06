package com.kraftechnologie.tests.day06_css_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_Class {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");


        WebElement logintitleText = driver.findElement(By.cssSelector(".card-title.text-center.pb-0.fs-4"));
        System.out.println("logintitleText.getText() = " + logintitleText.getText());


        WebElement emailInputBox = driver.findElement(By.cssSelector(".form-control"));
        emailInputBox.sendKeys("mike@gmail.com");

        Thread.sleep(2000);
        driver.close();


    }
}

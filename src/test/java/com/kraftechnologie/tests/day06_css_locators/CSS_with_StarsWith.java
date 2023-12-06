package com.kraftechnologie.tests.day06_css_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_StarsWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        // h5[class^='card-title']  without tagName [class^='card-title']
        WebElement loginTitleText = driver.findElement(By.cssSelector("h5[class^='card-title']"));
        System.out.println("loginTitleText.getText() = " + loginTitleText.getText());

        // starts with by xpath ("//input[starts-with(@id,'em')]")
        // css with starts-with ^ => ("input[id^='ema']")
        driver.findElement(By.cssSelector("input[id^='ema']")).sendKeys("mike@gmail.com");
        driver.findElement(By.cssSelector("input[id^='yourP']")).sendKeys("mike1234");
        // starts-with by xpath => //button[starts-with(@class,'btn')]
        driver.findElement(By.cssSelector("[class^='btn']")).click();


        Thread.sleep(2000);
        driver.quit();

    }
}

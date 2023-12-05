package com.kraftechnologie.tests.day04_basic_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Class_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();
        WebElement emailBox=driver.findElement(By.id("email"));
        emailBox.sendKeys("test@test.com");
        Thread.sleep(2000);
        WebElement passwordBox= driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys("12345678");
        Thread.sleep(2000);
        WebElement lgnBtn=driver.findElement(By.tagName("button"));
        lgnBtn.click();

        Thread.sleep(2000);
        //locate Dashboard webElement with class attribute
        WebElement dasboard = driver.findElement(By.className("afm"));

        //get text of Dashboard webElement
        String actual=dasboard.getText();
        String expected="Dashboard";
        if (actual.equals(expected))
            System.out.println("pass");
        else
            System.out.println("fail");

        driver.quit();

    }
}
//TASK
//go to https://www.krafttechexlab.com/login and login with the valid credentials
//email --> test@test.com
//password --> 12345678
//locate the dashboard button by "class name"
//VERIFY dashboard string
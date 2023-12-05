package com.kraftechnologie.tests.day04_basic_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkText_5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();

        //locate webElement by linkText method
        WebElement createAnAccount=driver.findElement(By.linkText("Create an account"));
        Thread.sleep(2000);
        //click on create acoount button
        createAnAccount.click();
        Thread.sleep(2000);

        String actualURL=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/register";

        if (actualURL.equals(expectedUrl)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
driver.quit();
    }

}
/*
         *TASK

go to https://www.krafttechexlab.com/login
locate "Create an account" button by linktext
click on the button
verify that url is "https://www.krafttechexlab.com/register"*/
package com.kraftechnologie.tests.day04_basic_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartialLinkText_6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();

        //locate web Element with partiallinktext method
        WebElement createnAnAccount=driver.findElement(By.partialLinkText("an account"));
        Thread.sleep(2000);

        createnAnAccount.click();
        Thread.sleep(2000);
        String actual= driver.getCurrentUrl();
        String expected="https://www.krafttechexlab.com/register";

        if (actual.equals(expected)){
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
locate "Create an account" button by partialLinkText
click on the button
verify that url is "https://www.krafttechexlab.com/register"*/


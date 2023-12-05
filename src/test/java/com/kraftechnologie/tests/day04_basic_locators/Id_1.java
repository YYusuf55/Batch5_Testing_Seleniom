package com.kraftechnologie.tests.day04_basic_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Id_1 {
    public static void main(String[] args) throws InterruptedException {
        /**

         TASK
         go to https://www.krafttechexlab.com/login
         locate the email box by id
         locate password box by id
         enter data:
         1.email --> test@test.com
         2.password --> 12345678
         VERIFY THAT INPUT BOXES HAVE THE SAME VALUE
         */

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();

        //locate webelement (email input box)
        WebElement emailInputbot=driver.findElement(By.id("email"));
        //Send test@test.com
        emailInputbot.sendKeys("test@test.com");
        Thread.sleep(1000);

        //locate webElement(password box)
        WebElement passwordInputBox=driver.findElement(By.id("yourPassword"));
        passwordInputBox.sendKeys("12345678");
        Thread.sleep(1000);

       String actualValue_Email = emailInputbot.getAttribute("value");
       String expectedValue_Email="test@test.com";

       String actualValue_Password=passwordInputBox.getAttribute("value");
        String expectedValue_Password="12345678";

        if (actualValue_Email.equals(expectedValue_Email)&& actualValue_Password.equals(expectedValue_Password)){

            System.out.println("pass");
        }else {
            System.out.println("fail");
        }


        driver.quit();





    }
}

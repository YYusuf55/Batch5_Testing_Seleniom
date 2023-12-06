package com.kraftechnologie.tests.day06_css_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_MultipleAttributes {
    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");



        // css with multiple Attributs => ("[type='text'][name='email']")
        driver.findElement(By.cssSelector("[type='text'][name='email']")).sendKeys("mike@gmail.com");
        driver.findElement(By.cssSelector("[type='password'][name='password']")).sendKeys("mike1234");
        driver.findElement(By.cssSelector("[type='submit'][class='btn btn-primary w-100']")).click();

        Thread.sleep(2000);
        driver.quit();


    }
}

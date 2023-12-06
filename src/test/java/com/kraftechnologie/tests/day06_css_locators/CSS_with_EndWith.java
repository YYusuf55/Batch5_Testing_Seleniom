package com.kraftechnologie.tests.day06_css_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_EndWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        // h5[class$='fs-4'] $ without tagName [class$='fs-4']
        WebElement loginTitleText = driver.findElement(By.cssSelector("h5[class$='fs-4']"));
        System.out.println("loginTitleText.getText() = " + loginTitleText.getText());

        // Ends with by xpath can NOT use with chrome
        // css with Ends-with $ => ("input[id$='mail']")
        driver.findElement(By.cssSelector("input[id$='mail']")).sendKeys("mike@gmail.com");
        driver.findElement(By.cssSelector("input[id$='Password']")).sendKeys("mike1234");
        driver.findElement(By.cssSelector("button[class$='w-100']")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}

package com.kraftechnologie.tests.day06_css_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_ChildElement {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        //css with child element tagName>tagName>  xpath=//form/div/input
        WebElement emailInputBox = driver.findElement(By.cssSelector("form>div>input"));
        emailInputBox.sendKeys("mike@gmail.com");
        // xpath => //section//h5           // css with Descendant element=>   section h5
        WebElement loginTitleText = driver.findElement(By.cssSelector("section h5"));
        System.out.println("loginTitleText.getText() = " + loginTitleText.getText());
        //css parent to child with attribute value [class="col-12"]>[type='password']
        driver.findElement(By.cssSelector("[class=\"col-12\"]>[type='password']")).sendKeys("mike1234");
        driver.findElement(By.cssSelector("form[method='post'] button[type='submit']")).click();

    Thread.sleep(2000);
        driver.close();


    }
}

package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class isDisplayed {

    @Test
    public void displayedTest() throws InterruptedException {
        /**

         go to https://the-internet.herokuapp.com/dynamic_loading/1
         validate that Start button is displayed*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        Thread.sleep(2000);
        WebElement StartBttn = driver.findElement(By.xpath("//button[.='Start']"));
        System.out.println("StartBttn.isDisplayed() = " + StartBttn.isDisplayed());
        Assert.assertTrue(StartBttn.isDisplayed());


        /**

         validate that 'Hello World' webElement is not displayed before click on Start button*/

        WebElement hellowordl= driver.findElement(By.xpath("//h4[.='Hello World!']"));
        System.out.println("hellowordl.isDisplayed() = " + hellowordl.isDisplayed());
        Assert.assertFalse(hellowordl.isDisplayed());

        /**
         * validate that Hello World webElement is displayed after click on Start button
         */
        StartBttn.click();
        System.out.println("hellowordl.isDisplayed() = " + hellowordl.isDisplayed());
        Thread.sleep(5000);
        Assert.assertTrue(hellowordl.isDisplayed());


        driver.quit();
    }
}

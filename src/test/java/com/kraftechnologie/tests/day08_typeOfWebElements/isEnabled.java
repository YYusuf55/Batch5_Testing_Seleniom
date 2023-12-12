package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class isEnabled {

    @Test
    public void disabledElements() throws InterruptedException {
        /**

         go to https://the-internet.herokuapp.com/dynamic_controls
         validate that uninteractable button is disabled*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        Thread.sleep(2000);
        //validation
        WebElement textBox= driver.findElement(By.cssSelector("input[type='text']"));
        System.out.println("textBox.isEnabled() = " + textBox.isEnabled());
        Assert.assertFalse(textBox.isEnabled());
        WebElement enable=driver.findElement(By.xpath("//*[.='Enable']"));
        enable.click();
        Thread.sleep(4000);
        Assert.assertTrue(textBox.isEnabled());

        driver.quit();

    }

}

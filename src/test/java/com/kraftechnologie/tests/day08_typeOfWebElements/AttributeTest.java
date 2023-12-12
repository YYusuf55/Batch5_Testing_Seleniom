package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {


    @Test
    public void attributeTest() throws InterruptedException {
        /**

         go to https://demoqa.com/text-box
         locate FullName webElement and get all values of webElement with getAttribute method*/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(3000);
        WebElement fullname = driver.findElement(By.cssSelector("label#userName-label"));
        //get value of tagname
        System.out.println("fullname.getAttribute(\"tagName\") = " + fullname.getAttribute("tagName"));
        //get vaule of class attribute
        System.out.println("fullname.getAttribute(\"class\") = " + fullname.getAttribute("class"));
        //get value of id
        System.out.println("fullname.getAttribute(\"id\") = " + fullname.getAttribute("id"));
        //if given attribute does not exist--> NULL
        System.out.println("fullname.getAttribute(\"alperen\") = " + fullname.getAttribute("alperen"));
        //get all data
        System.out.println("fullname.getAttribute(\"outerHTML\") = " + fullname.getAttribute("outerHTML"));
        //get text of webElement
        //fullname.getText();
        //fullname.getAttribute("value");
        System.out.println("fullname.getAttribute(\"innerHTML\") = " + fullname.getAttribute("innerHTML"));

        driver.quit();
    }

    @Test
    public void attributeTestRealScenario() throws InterruptedException {
        /**

         go to https://demo.aspnetawesome.com/
         validate that class name of "Celery" is o-chkm(unChecked) default*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        WebElement celery = driver.findElement(By.cssSelector(".awe-display.o-ochk>ul>li:nth-of-type(1)"));
        //validation
        String actual = celery.getAttribute("class").trim();
        String expected = "o-chkm";
        Assert.assertEquals(actual, expected);

        /**

         click on celery checkbox
         validate tha class name of "Celery" is o-chkm o-chked(checked)*/

        celery.click();
        Thread.sleep(3000);
        String actual1 = celery.getAttribute("class").trim();
        String expected1 = "o-chkm o-chked";
        Assert.assertEquals(actual1, expected1);

        driver.quit();

    }
}

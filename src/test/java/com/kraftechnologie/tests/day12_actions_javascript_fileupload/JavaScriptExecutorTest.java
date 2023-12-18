package com.kraftechnologie.tests.day12_actions_javascript_fileupload;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void clickWithJS() {
        /**

         ANOTHER CLİCK METHOD
         go to "https://www.krafttechexlab.com/components/listgroup"
         locate Fifth Checkbox
         try to select it with Selenium click() method
         try to select it with JS and validate that it is selected*/
        driver.get("https://www.krafttechexlab.com/components/listgroup");
        //locate checkbox
        WebElement targetCheckBox=driver.findElement(By.xpath("(//input[@class='form-check-input me-1'])[5]"));
        //click with Selenium
        //targetCheckBox.click();


        JavascriptExecutor JavascriptExecutor= (JavascriptExecutor) driver;
        //click with JSE
        JavascriptExecutor.executeScript("arguments[0].click;",targetCheckBox);
        //verify the checkbox is clicked
        Assert.assertTrue(targetCheckBox.isSelected());


    }

    @Test
    public void typeWithJS() {
        /**

         ANOTHER TYPE METHOD
         go to "https://the-internet.herokuapp.com/dynamic_controls"
         type "Hello World" in to disabled text box with JS*/
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //locate disabled text box
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        //send date with JS
        String text = "Hello World";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].setAttribute('value', '" + text +"')", textBox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        /**

         go to https://www.amazon.com.tr/
         scroll the page down and up with JS*/


        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.cssSelector("#sp-cc-accept")).click();
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;

        for (int i=0; i<10; i++){
            //scroll down the page
            javascriptExecutor.executeScript("window.scrollBy(0,500)");
            Thread.sleep(1000);
        }
        for (int i=0; i<10; i++){
            //scroll down the page
            javascriptExecutor.executeScript("window.scrollBy(0,-500)");
            Thread.sleep(1000);
        }

    }

    @Test
    public void ScrollToElement() {
        /**

         go to https://www.amazon.com.tr/
         scroll the page to target element(Almanya) in one shot with JS*/

        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.cssSelector("#sp-cc-accept")).click();

        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        WebElement germany=driver.findElement(By.xpath("(//*[.='Almanya'])[2]"));

        //scroll to target webElement in one shot
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",germany);

    }
}

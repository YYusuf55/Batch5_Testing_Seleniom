package com.kraftechnologie.tests.day10_typeOfWebElements_3;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void t_iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        // NoSuchElementException => iframe
        //driver.findElement(By.cssSelector("#tinymce")).sendKeys("KraftTech B5 is here");

        // How to switch the frame
        // first way : using name or ID
        driver.switchTo().frame("mce_0_ifr");
        WebElement textArea=driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();
        textArea.sendKeys("KraftTech B5 is here");

        //Second way : switching index
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("KraftTech B5 is here again");

        driver.switchTo().parentFrame();
        // Third way : using web element
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("KraftTech B5 is here third times");
    }

    @Test
    public void t_nestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // switch the middle frame and  get MIDDLE text

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.id(\"content\")).getText() = " + driver.findElement(By.id("content")).getText());

        //go to Right frame and get text
        // driver.switchTo().parentFrame(); // switch to parent
        // driver.switchTo().frame(2);
        driver.switchTo().defaultContent(); // switch to directly top
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());

        // go to bottom frame and get text
        driver.switchTo().defaultContent();// to go to default HTML
        //driver.switchTo().frame(1);
        driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());

    }
}

package com.kraftechnologie.tests.day11_waits;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,15);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void t1_ExplicitWait_Visible() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();
        //WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(hello));
        Assert.assertEquals(hello.getText(), "Hello World!");
    }

    @Test
    public void t2_ExplicitWait_Clickable() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        //ElementNotInteractableException: element not interactable
       // driver.findElement(By.cssSelector("input[type='text']")).sendKeys("B5 is here");
        //WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement inputbox = driver.findElement(By.cssSelector("input[type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputbox));
        inputbox.sendKeys("B5 is here now");

        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's enabled!");

    }

    @Test
    public void t3_ExplicitWait_Alert() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("timerAlertButton")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        Assert.assertEquals(alert.getText(),"This alert appeared after 5 seconds");
    }
}

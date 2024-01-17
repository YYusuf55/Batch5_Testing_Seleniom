package com.kraftechnologie.tests.day19_review_and_xml_runner;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElement extends TestBase {

    //StaleElementReferenceException:
    @Test
    public void t1_staleProblem() throws InterruptedException {
        BrowserUtils.waitFor(2);
        driver.get("https://freecrm.com/");
        WebElement loginBtn=driver.findElement(By.xpath("//a[.='Log In']"));
        loginBtn.click();

        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("email@gmail.com");
        Thread.sleep(2000);
        WebElement passwordInput=driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345");
        driver.navigate().refresh();
        BrowserUtils.waitFor(2);
        emailInput.sendKeys("email@gmail.com");

    }

    @Test
    public void t2_staleFix() {

        driver.get("https://freecrm.com/");
        BrowserUtils.waitFor(2);
        WebElement loginBtn = driver.findElement(By.xpath("//a[.='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("Email@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345");
        driver.navigate().refresh();
        BrowserUtils.waitFor(2);

        try {
            emailInput.sendKeys("Email@gmail.com");
        } catch (StaleElementReferenceException e) {
            emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("Email@gmail.com");
            passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("12345");
        }
    }
}

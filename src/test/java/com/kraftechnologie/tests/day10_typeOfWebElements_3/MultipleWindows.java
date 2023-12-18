package com.kraftechnologie.tests.day10_typeOfWebElements_3;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void t_twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        Thread.sleep(2000);

//        String titleAfterClick= driver.getTitle();
//        System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab = driver.getWindowHandle();
        System.out.println("currentTab = " + currentTab);
        //window ID = 2ADD3F3BBDF792ED2520B6BE7B89DE46
        //window ID = FC76AC5EB0EE60E6DB170FC0D3445AF1

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) { // go and check one by one
            System.out.println("tab = " + tab);
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test
    public void t_multipleWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());


        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        Thread.sleep(2000);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
//            if (driver.getTitle().equals("New Window")) {
//                Thread.sleep(2000);
//                System.out.println("driver.getTitle() = " + driver.getTitle());
//                System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
//                break;
//            }
            if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")){
                break; // stop on this window
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
}

package com.kraftechnologie.tests.day09_findElements_dropDowns;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownMenu_WithoutSelectTag {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test_getOneOptionWithFindElement() throws InterruptedException {
        // go to https://demoqa.com/select-menu
        // locate the "Select Title" web element
        // click on it
        // click on 'Mrs.'

        //locate dropdown menu
        WebElement selectTitle= driver.findElement(By.xpath("//div[text()='Select Title']"));

        selectTitle.click();

        Thread.sleep(3000);

        //locate Mrs. webElement
        WebElement mrs= driver.findElement(By.cssSelector("#react-select-3-option-0-2"));

        //click on it
        mrs.click();

        //validate that Mrs. is seen on the dropdown me

        WebElement firstOption_Mrs= driver.findElement(By.cssSelector(".css-1uccc91-singleValue"));
        String actual=firstOption_Mrs.getText();
        String expected="Mrs.";
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void test_getAllOptionnsWithFindElements() {
        // go to https://demoqa.com/select-menu
        // locate the "Select Title" web element
        // click on it
        // get all options with findElements()

        //locate dropdown menu
        WebElement selectTitle= driver.findElement(By.xpath("//div[text()='Select Title']"));

        selectTitle.click();

        //get all webElement and put them into a list
        List<WebElement> elements = driver.findElements(By.cssSelector("div[id^='react-select-3-option-0-']"));

        //validate that size of list 6
        Assert.assertEquals(elements.size(),6);

        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }

    }
}

package com.kraftechnologie.tests.day09_findElements_dropDowns;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownMenu_SelectTag {

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
    public void test_getOptions() {
        // go to https://demoqa.com/select-menu
        // Old Style Select Menu
        // get all options(web elements) as a list
        //verify that the number of webElement is 11

        //locate the dropdown menu
        WebElement dropDownMenu= driver.findElement(By.cssSelector("#oldSelectMenu"));

        //create a select object (comes from Selenium)
        Select select=new Select(dropDownMenu);

        //get all webElements with getOptions() methods
        List<WebElement> options = select.getOptions();

        //print size of options
        System.out.println("options.size() = " + options.size());

        //validate that size of options is 11
        Assert.assertEquals(options.size(),11);
    }

    @Test
    public void test_SelectByVisibleText() {
        // Old Style Select Menu
        // get the blue thru visible text option and make verification

        //locate dropdow menu
        WebElement dropDownMenu= driver.findElement(By.cssSelector("#oldSelectMenu"));

        //create a select object
        Select select=new Select(dropDownMenu);

        //select blue option with visible text
        select.selectByVisibleText("Blue");

        //get selected webElement and put it into a bucket

        WebElement firstSelectedOption = select.getFirstSelectedOption();

        //validate that text of firstSelecttedOption is 'Blue'
        String actual=firstSelectedOption.getText();
        String expected="Blue";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test_SelectByIndexNumber() {
        // Old Style Select Menu
        // get the green option thru visible index number and make verification

        //locate dropdow menu
        WebElement dropDownMenu= driver.findElement(By.cssSelector("#oldSelectMenu"));

        //create a select object
        Select select=new Select(dropDownMenu);

        //select the green option by index number

        select.selectByIndex(2);

        //get the green option and put it in to a bucket
        WebElement firstSelectedOption = select.getFirstSelectedOption();

        //validate that text is 'Green'
        String actual=firstSelectedOption.getText();
        String expected="Green";
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void test_selectByValueAttribute() {
        // Old Style Select Menu
        // get the voilet thru value option and make verification

        //locate dropdow menu
        WebElement dropDownMenu= driver.findElement(By.cssSelector("#oldSelectMenu"));

        //create a select object
        Select select=new Select(dropDownMenu);

        //select voilet webElement by value attribute
        select.selectByValue("7");

        //get webElement
        WebElement firstSelectedOption = select.getFirstSelectedOption();

        //validate that text is 'Voilet'
        String actual=firstSelectedOption.getText();
        String expected="Voilet";
        Assert.assertEquals(actual,expected);
    }
}

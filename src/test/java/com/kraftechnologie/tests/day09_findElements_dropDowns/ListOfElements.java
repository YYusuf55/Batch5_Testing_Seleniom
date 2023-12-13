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

public class ListOfElements {

    //instance(object)
    //static(class)
    //local(method)

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/javascript/clicks");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 2)  // priorty testin sırasını belirler
    public void findElementsWithCorrectFormula() throws InterruptedException {
        /*

go to https://www.krafttechexlab.com/javascript/clicks
get all buttons into a list*/

        //get all related webElement and put them into a list
        List<WebElement> elements = driver.findElements(By.cssSelector(".btn.btn-primary"));
        //print size of list
        System.out.println("elements.size() = " + elements.size());
        //validate that size of list is 4
        Assert.assertEquals(elements.size(), 4);

        //verify that the of 3rd element is 'click me'
        WebElement thirdElement = elements.get(2);
        System.out.println("thirdElement.getText() = " + thirdElement.getText());
        Assert.assertEquals(thirdElement.getText(), "Click Me");
        //click on 4th element
        elements.get(3).click();
        Thread.sleep(2000);

        //print all texts of webElements
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test(priority = 1)
    public void findElementsWithoutCorrectFormula() throws InterruptedException {
        /*

go to https://www.krafttechexlab.com/javascript/clicks
try to locate any web element with findElements() method with a wrong formula
see how it behaves*/

        List<WebElement> wronggFormula = driver.findElements(By.xpath("wrıbgFormula"));
        //print to see how many webElements wrongFormula list have
        System.out.println("wronggFormula.size() = " + wronggFormula.size());
        //validation of size
        Assert.assertEquals(wronggFormula.size(), 0);
        Assert.assertTrue(wronggFormula.isEmpty());


    }
}

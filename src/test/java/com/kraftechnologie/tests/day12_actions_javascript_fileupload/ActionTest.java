package com.kraftechnologie.tests.day12_actions_javascript_fileupload;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {

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
    public void hoverOver(){
        /**
         * 1th Main Action (Hover Over)
         * go to "https://the-internet.herokuapp.com/hovers"
         * hover mouse over first image
         * verify that "name: user" is visible
         * verify the text
         */
        driver.get("https://the-internet.herokuapp.com/hovers");
        //create an actions object

        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));

        //hover the mouse over the target webElement
        actions.moveToElement(element).perform();

        WebElement element1 = driver.findElement(By.xpath("//h5[contains(text(),'user1')]"));
        Assert.assertTrue(element1.isDisplayed());
    }

    @Test
    public void dragAndDrop(){
        /**
         * 2nd Main Action (Drag and Drop)
         * go to https://demoqa.com/droppable
         * take "Drag me" webElement, move it on to "Drop here" and leave on it
         * verify that 'Dropped!' webElement is visible
         */
        driver.get("https://demoqa.com/droppable");

        //locate source webElement
        WebElement source = driver.findElement(By.xpath("//div[.='Drag me']"));
        //locate target webElement
        WebElement target = driver.findElement(By.xpath("(//p[.='Drop here'])[1]"));

        //create an actions object
        Actions actions = new Actions(driver);

        //drag source and drop it in to target
        actions.dragAndDrop(source,target).perform();

        WebElement dropped = driver.findElement(By.xpath("//p[.='Dropped!']"));
        Assert.assertEquals(dropped.getText(), "Dropped!");
    }

    @Test
    public void dragAndDrop2(){
        /**
         * 2nd Main Action (Drag and Drop)
         * go to https://demoqa.com/droppable
         * take "Drag me" webElement, move it on to "Drop here" and leave on it
         * verify that 'Dropped!' webElement is visible
         */
        driver.get("https://demoqa.com/droppable");

        //locate source webElement
        WebElement source = driver.findElement(By.xpath("//div[.='Drag me']"));
        //locate target webElement
        WebElement target = driver.findElement(By.xpath("(//p[.='Drop here'])[1]"));

        //create an actions object
        Actions actions = new Actions(driver);

        //go to source webElement, click and hold, move it on to target webElement, hold 3000 second and release
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();

        WebElement dropped = driver.findElement(By.xpath("//p[.='Dropped!']"));
        Assert.assertEquals(dropped.getText(), "Dropped!");
    }

}

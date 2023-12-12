package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    @Test
    public void checkBoxDifferentCases() throws InterruptedException {
        /**

         go to "https://demoqa.com/automation-practice-form"
         validate that sports checkBox is not selected default*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);
        WebElement sportscheckbox= driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
        System.out.println("sportscheckbox.isSelected() = " + sportscheckbox.isSelected());
        Assert.assertFalse(sportscheckbox.isSelected());

        //click on sportsCheckBox webElement
       // sportscheckbox.click();
        WebElement parentSportsCheckBox= driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']/.."));
        parentSportsCheckBox.click();
        Thread.sleep(2000);
        /**
         * validate that sportsCheckBox is selected
         */
        Assert.assertTrue(sportscheckbox.isSelected());

        Thread.sleep(2000);

        driver.quit();

    }
}

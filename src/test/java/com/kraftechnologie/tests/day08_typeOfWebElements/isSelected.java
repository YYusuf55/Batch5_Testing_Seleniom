package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class isSelected {

    @Test
    public void radioButton() throws InterruptedException {
        /**

         go to https://www.krafttechexlab.com/forms/radio
         validate that "Checked Radio 1" is already selected*/

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/radio");
       Thread.sleep(2000);

        WebElement radioButton1=driver.findElement(By.cssSelector("#gridRadios1"));
        System.out.println("radioButton1.isSelected() = " + radioButton1.isSelected());
        //validation
        Assert.assertTrue(radioButton1.isSelected());

        /**

         validate that "Radio 2" is not selected*/

        WebElement radioButton2= driver.findElement(By.cssSelector("#gridRadios2"));
        System.out.println("radioButton2.isSelected() = " + radioButton2.isSelected());
        Assert.assertFalse(radioButton2.isSelected());

        /**

         click on "Radio 2" button
         validate that "Radio 2" is selected*/

        radioButton2.click();
        System.out.println("radioButton2.isSelected() = " + radioButton2.isSelected());
        Assert.assertTrue(radioButton2.isSelected());


        driver.quit();


    }

    @Test
    public void checkBoxes() throws InterruptedException {
        /**

         go to https://www.krafttechexlab.com/forms/checkbox
         validate that "Checkbox1" is not selected
         validate that "Checkbox2" is already selected*/

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        Thread.sleep(2000);

        WebElement checkBox1= driver.findElement(By.cssSelector("#gridCheck1"));
        Assert.assertFalse(checkBox1.isSelected());

        WebElement checkBox2= driver.findElement(By.cssSelector("#gridCheck2"));
        Assert.assertTrue(checkBox2.isSelected());
        Assert.assertEquals(checkBox2.isSelected(),true);
        Assert.assertFalse(!checkBox2.isSelected());

        driver.quit();
    }


}

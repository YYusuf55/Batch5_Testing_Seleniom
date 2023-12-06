package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath_4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/components/modal");
        Thread.sleep(2000);
        //first syntax
        WebElement basicModalButton = driver.findElement(By.xpath("//button[@type='button' and @data-bs-target='#basicModal']"));
        //second syntax
        WebElement basicModalButton1 = driver.findElement(By.xpath("//button[@type='button'][@data-bs-target='#basicModal']"));
        String actual = basicModalButton.getText();
        String actual1 = basicModalButton1.getText();
        String expected = "Basic Modal";
        if (actual.equals(expected) && actual1.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        //2. örnek
        driver.get("https://www.krafttechexlab.com/components/tabs");
        Thread.sleep(2000);
        WebElement messageButton = driver.findElement(By.xpath("//button[@id='v-pills-messages-tab' or @data-bs-target='#v-pills-messages' ]"));
        String actualMessageButton=messageButton.getText();
        String expectedMessageButton="Messages";
        if (actualMessageButton.equals(expectedMessageButton)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }


        driver.quit();
    }
}
//AND LOGIC
//go to "https://www.krafttechexlab.com/components/modal"
//get the "Basic Modal" button with AND logic and verify the text


//OR LOGIC
//go to https://www.krafttechexlab.com/components/tabs
//get Messages webElement with OR logic and verify the text
package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath_2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/input");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement password= driver.findElement(By.xpath("//label[starts-with(@for,'inputP')]"));
        String actualpasswordText= password.getText();
        String expectedpasswordText="Password";
        if(actualpasswordText.equals(expectedpasswordText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

        //2. örnek
        WebElement password1 = driver.findElement(By.xpath("//label[starts-with(text(),'Password')]"));
        String actualPasswordText1=password1.getText();
        if (actualPasswordText1.equals(expectedpasswordText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
driver.quit();
    }

}
/**

 go to https:"www.krafttechexlab.com/forms/input"
 locate password webElement with starts-with(@attribute, value)
 validate that text is Password*/




/**

 locate password webElement with starts-with(text(), value)
 validate that text is Password*/
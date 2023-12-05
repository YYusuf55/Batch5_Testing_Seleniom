package com.kraftechnologie.tests.day04_basic_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.naming.ldap.LdapReferralException;

public class Tagname_3 {
    public static void main(String[] args) throws InterruptedException {

        /*
         *TASK

go to https://www.krafttechexlab.com/login
locate login button by tag name
click on login button
VERIFY that URL is still same*/

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();

        //locate login button with tagname
        WebElement loginbutton=driver.findElement(By.tagName("button"));

        String urlBeforeClick=driver.getCurrentUrl();

        Thread.sleep(1000);
        loginbutton.click();
        Thread.sleep(1000);
        String urlAfterClicking=driver.getCurrentUrl();

        if(urlBeforeClick.equals(urlAfterClicking)){
            System.out.println("pass");
        }else{
            System.out.println("faıl");
        }


        driver.quit();
    }
}

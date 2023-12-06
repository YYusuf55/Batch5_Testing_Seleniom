package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath_1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        WebElement cerezAccept = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        cerezAccept.click();
        //locate search bar
        WebElement searcBar=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searcBar.sendKeys("selenium");
        //locate search button
        WebElement searcButton= driver.findElement(By.xpath("//input[@type='submit']"));
        searcButton.click();

        Thread.sleep(2000);

        //locate selenium webElement with
        WebElement seleniumText= driver.findElement(By.xpath("//span[text()='\"selenium\"']"));
        WebElement seleniumText2= driver.findElement(By.xpath("//span[.='\"selenium\"']"));
        String actualText1=seleniumText.getText();
        String actualText2=seleniumText2.getText();
        String expectedText="\"selenium\"";
        if (actualText1.equals(expectedText)&&actualText2.equals(expectedText)){
            System.out.println("pass");
        }else
            System.out.println("faıl");

        driver.quit();



    }
}
//go to amazon.com.tr
//locate search bar with xpath
//locate search button with xpath
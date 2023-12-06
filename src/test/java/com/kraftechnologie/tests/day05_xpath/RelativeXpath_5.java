package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath_5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/input");
        Thread.sleep(3000);

        //1.parent to child --> mainXpathFormula/tagName
        WebElement element1= driver.findElement(By.xpath("//div[@class='row mb-3'][1]/label"));

        //2.child to parent --> mainXpathFormula/..
        WebElement element2=driver.findElement(By.xpath("(//input[@type='text'])[1]/../../label"));
        //3.from sibling to previous sibling --> 




    }
}
//go to "https://www.krafttechexlab.com/forms/input"
//get the text webElement with the following features
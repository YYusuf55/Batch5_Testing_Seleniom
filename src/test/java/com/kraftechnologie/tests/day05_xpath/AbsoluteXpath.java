package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsoluteXpath {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");
        driver.manage().window().maximize();

        //locate home webElement by absolute xpath
        WebElement homeElement= driver.findElement(By.xpath("/html/body/main/div/nav/ol/li/a"));
        String actualHomeText=homeElement.getText();
        String expectedHometext="Home";

        if (actualHomeText.equals(expectedHometext)){
            System.out.println("pass");
        }else{
            System.out.println("faıl");
        }

        //locate dashboard webElement by absolute xpath
        WebElement dashboardElement= driver.findElement(By.xpath("/html/body/main/div/nav/ol/li[2]"));
        String actualDashboardText=dashboardElement.getText();
        String expectedDasBoardText="Dashboard";
        if (actualDashboardText.equals(expectedDasBoardText)){
            System.out.println("pass");
        }else
            System.out.println("fail");
    }


}
/*

TASK
go to https://www.krafttechexlab.com/
get the 'Home' webElement by absolute xpath
get the 'Dashboard' webElement by absolute xpath
validate text of webElements*/
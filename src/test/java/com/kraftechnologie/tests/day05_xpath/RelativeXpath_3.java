package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath_3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/elements");
        WebElement colorPicker= driver.findElement(By.xpath("//label[contains(@for,'Color')]"));
        String actualValue = colorPicker.getText();
        String expecteValue = "Color Picker";
        if (actualValue.equals(expecteValue)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        Thread.sleep(2000);

        WebElement colorpicker2= driver.findElement(By.xpath("//label[contains(text(),'Picker')]"));
        String actualValue2=colorpicker2.getText();
        if(actualValue2.equals(expecteValue)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();


    }
}
/**

 go to "https://www.krafttechexlab.com/forms/elements"
 get Color Picker webElement with contains(@attribute, 'value')
 validate text*/

/**

 get Color Picker webElement with contains(text(), 'value')
 validate text*/
package com.kraftechnologie.tests.day04_basic_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.TableHeaderUI;

public class name_2 {
    /*
         *TASK

go to https://www.krafttechexlab.com/login(chrome)
locate email box by name
locate password box by name
enter data:
email --> test@test.com
password box --> 12345678
VERIFY THAT INPUT BOXES HAVE THE SAME VALUES
*/
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //go to kraft
        driver.navigate().to("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();

        //locate email input box web element with name
        WebElement emailInputBox= driver.findElement(By.name("email"));
        emailInputBox.sendKeys("test@test.com");
        Thread.sleep(1000);

        //locate password İnput box web element with name
        WebElement passwordInputBox=driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("12345678");

        String actualValue_Email = emailInputBox.getAttribute("value");
        String expectedValue_Email="test@test.com";

        String actualValue_Password=passwordInputBox.getAttribute("value");
        String expectedValue_Password="12345678";

        if (actualValue_Email.equals(expectedValue_Email)&& actualValue_Password.equals(expectedValue_Password)){

            System.out.println("pass");
        }else {
            System.out.println("fail");
        }


        driver.quit();






    }
}

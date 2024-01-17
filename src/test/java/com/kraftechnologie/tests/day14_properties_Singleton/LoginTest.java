package com.kraftechnologie.tests.day14_properties_Singleton;

import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    // send to the TestBase class
//    WebDriver driver;

//    @BeforeMethod
//    public void setUp(){
//      driver= Driver.get();
//      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//    }
//
//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(2000);
//        Driver.closeDriver();
//    }

    @Test
    public void t_positiveLoginTest() {
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("email"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.xpath("// button[.='Login']")).click();

    }

    @Test
    public void t_anotherLoginTest() {
        driver.get(ConfigurationReader.get("url"));
        WebElement emailInputBox = driver.findElement(By.id("email"));
        WebElement passwordInputBox = driver.findElement(By.id("yourPassword"));
        emailInputBox.sendKeys(ConfigurationReader.get("email"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password")+Keys.ENTER);
        //passwordInputBox.sendKeys(ConfigurationReader.get("password")+ Keys.TAB+Keys.TAB+Keys.TAB+Keys.ENTER);
       // driver.findElement(By.xpath("// button[.='Login']")).click();
    }
}

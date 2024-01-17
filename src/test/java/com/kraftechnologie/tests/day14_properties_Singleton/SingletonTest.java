package com.kraftechnologie.tests.day14_properties_Singleton;

import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

//    @Test
//    public void testName1() {
//        String s1=Singleton.getInstance();
//        String s2=Singleton.getInstance();
//        System.out.println(s1);
//        System.out.println(s2);
//    }
//
//    @Test
//    public void t_newDriverWithSingleton() throws InterruptedException {
////        WebDriver driver1=WebDriverFactory.getDriver("chrome");
////        WebDriver driver2=WebDriverFactory.getDriver("chrome");
//        WebDriver driver1= Driver.get();
//        WebDriver driver2=Driver.get();
//
//        driver1.get("https://www.krafttechexlab.com/login");
//        Thread.sleep(2000);
//        driver2.findElement(By.id("email")).sendKeys("selenium");
//
//    }

    @Test
    public void testName3() {
       // WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver=Driver.get();
        driver.get("https://www.google.com/");
        Driver.closeDriver();
    }

    @Test
    public void testName4() {
       // WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver=Driver.get();
        driver.get("https://www.amazon.com/");
        Driver.closeDriver();
    }
    @Test
    public void testName5() {
        //WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver=Driver.get();
        driver.get("https://demoqa.com/select-menu");
        Driver.closeDriver();
    }
}

package com.kraftechnologie.tests.day02_webdriver_basics;

import com.kraftechnologie.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.TreeMap;

public class CallWebDriverFactory {

    /**
     * TASK
     * go to "https://www.krafttechexlab.com/" with chrome by using getDriver() method
     * verify that the url is "https://www.krafttechexlab.com/"
     */

    public static void main(String[] args) throws InterruptedException {

        // WebDriverManager.chromedriver().setup();
        //  WebDriver driver=new ChromeDriver();
        // driver.get(https://www.krafttechexlab.com/);

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://www.krafttechexlab.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver.quit();

    }
}

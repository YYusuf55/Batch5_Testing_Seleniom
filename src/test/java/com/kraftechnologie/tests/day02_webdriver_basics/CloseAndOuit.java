package com.kraftechnologie.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.chrono.ThaiBuddhistEra;

public class CloseAndOuit {
    /**

     TASK-1
     open safari browser
     go to "https://www.krafttechexlab.com/"
     close the browser with close() method
     *
     TASK-2
     go to "https://www.amazon.com/"
     close the browser with quit() method
     */
    public static void main(String[] args) throws InterruptedException {

       // WebDriverManager.chromedriver().setup();
       // WebDriverManager.edgedriver().setup();
        //WebDriverManager.safaridriver().setup();
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://www.krafttechexlab.com");

        Thread.sleep(2000);

        //quit() --> browserı kapat
        //close()--> geçerli sekmeyi kapatır
        driver.close();

        WebDriver driver1= new FirefoxDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.amazon.com/");

        //quit()-->browserı kapat
        //quit()--> bütün sekmeleri kapatır.
        //pratikte her zaman için quit() methodu kullanıcaz
        driver1.quit();




    }
}

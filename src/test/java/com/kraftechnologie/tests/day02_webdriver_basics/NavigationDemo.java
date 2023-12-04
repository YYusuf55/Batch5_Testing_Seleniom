package com.kraftechnologie.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        /**

         TASK
         open chrome and navigate to "https://www.google.com/"
         go to "https://www.amazon.com/"
         go back (google)
         go forward (amazon)
         refresh the page (amazon)
         */


        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        //driver.get("https://www.google.com/");
        //driver.get("https://www.google.com/")
        //navigete.to==get()
        //go to google
        driver.navigate().to("https://www.google.com/");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        //got to amazon
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

        //google a geri dön
        driver.navigate().back();
        Thread.sleep(2000);

        //amazona tekrar git
        driver.navigate().forward();

        Thread.sleep(2000);

        //refresh button
        driver.navigate().refresh();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        //title ı verify edelim
        String actual=driver.getTitle();
        String expected="Amazon.com. Spend less. Smile more.";
        if (actual.equals(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }
}

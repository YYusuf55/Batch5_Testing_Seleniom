package com.kraftechnologie.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettitleAndGetUrl {

        /**

         TASK
         Open chrome and navigate to https://www.krafttechnologie.com/
         get title and display (then verify)
         get current url and display (then verify)
         get pageSource and display*/
        public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();

            WebDriver driver=new ChromeDriver();
            driver.navigate().to("https://www.krafttechnologie.com/");

            //title alıo bir string bucketin içine attık
            String actual=driver.getTitle();
            String expected="Kraft Technologie | Uzaktan Eğitim Merkezi";
            if(actual.equals(expected)){
                System.out.println("title PASS");
            }else{
                System.out.println("title FAIL");
            }

            //sayfanın urlini aldık.
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

            String actualUrl=driver.getCurrentUrl();
            String expectedUrl="https://www.krafttechnologie.com/tr/index";

            if(actual.equals(expectedUrl)){
                System.out.println("url PASS");
            }else {
                System.out.println("url FAIL");
            }

            //webpage in source kodunu aldık.

            System.out.println("driver.getPageSource() = " + driver.getPageSource());
            String sourceCose=driver.getPageSource();



        }
}

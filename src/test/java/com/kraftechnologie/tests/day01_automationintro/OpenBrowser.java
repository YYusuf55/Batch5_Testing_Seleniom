package com.kraftechnologie.tests.day01_automationintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    /**

     TASK
     Go to "https://www.krafttechnologie.com/"
     validate that title is "Kraft Technologie | Uzaktan Eğitim Merkezi"
     Önce MANUEL TEST YAP
     Sonra OTOMASYONUNU YAZ
     */
    public static void main(String[] args) {

        //selenium chrome ile çalışmaya hazır.

        WebDriverManager.chromedriver().setup();
          //driver objesi oluşturduk
          // driver browseri temsil edecek
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com");

        //ekran büyütüldü
        driver.manage().window().maximize();

        //title,ı nasıl alacagız.
        System.out.println("driver.getTitle() = " + driver.getTitle());

        String actual =driver.getTitle(); //actual --> gerçek değer
        String expected="Kraft Technologie | Uzaktan Eğitim Merkezi"; // expected --> beklenen değer

        if (actual.equals(expected)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


    }

}

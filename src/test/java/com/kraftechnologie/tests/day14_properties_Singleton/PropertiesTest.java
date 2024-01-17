package com.kraftechnologie.tests.day14_properties_Singleton;

import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void t1_callProperties() {
        String browser= ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
        String url=ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }

    @Test
    public void t2_openBrowserUsinConfigurationReader() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));

        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testName() {
        WebDriver driver1=WebDriverFactory.getDriver("chrome");
        //driver1.get("https://www.amazon.com/");
        WebDriver driver2=WebDriverFactory.getDriver("chrome");
        //driver2.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium");



    }
}

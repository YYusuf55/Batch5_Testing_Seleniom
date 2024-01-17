package com.kraftechnologie.tests.day12_actions_javascript_fileupload;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test1() {
        /**

         create a file on your Desktop named "test.txt"
         go to https://the-internet.herokuapp.com/upload
         upload the file and validate*/
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));

        //path of target text file
        String path="C:\\Users\\User\\Desktop\\test.txt";

        //upload txt file
        chooseFile.sendKeys(path);

        //locate and click on upload file
        WebElement uploadButton= driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();

        WebElement verificationPoint=driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertTrue(verificationPoint.getText().contains("test.txt"));
    }

    @Test
    public void test2() {

        /**

         create a file on your Desktop named "Selenium.txt"
         move this folder into resources file
         go to https://the-internet.herokuapp.com/upload
         upload the file and validate*/
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/Selenium.txt";
        String fullPath=projectPath+"/"+filePath;

        //upload txt file
        chooseFile.sendKeys(fullPath);

        //locate and click on upload file
        WebElement uploadButton= driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();

        WebElement verificationPoint=driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertTrue(verificationPoint.getText().contains("Selenium.txt"));




    }
}

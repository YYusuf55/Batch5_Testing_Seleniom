package com.kraftechnologie.tests.day06_css_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_with_FollowingSibling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement emailInputBox = driver.findElement(By.cssSelector("form>div>input"));
        emailInputBox.sendKeys("mike@gmail.com");
        // css with following sibling   xpath=> //form/div/following-sibling::div/input
        driver.findElement(By.cssSelector("form>div~div>input")).sendKeys("mike1234");
        // form>div~div~div~div>button
        driver.findElement(By.cssSelector("[method='post']>[class='col-12']~div>button")).click();
        Thread.sleep(2000);
        driver.close();
    }
}

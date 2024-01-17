package com.kraftechnologie.pages;

import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Profile Updated')]")
    public WebElement profileUpdated;

    public void navigateToMenu(String menu){
        String locatarPath="(//button[.='"+ menu +"'])[1]";
        WebElement element= Driver.get().findElement(By.xpath(locatarPath));

        BrowserUtils.clickWithJS(element);

    }

}

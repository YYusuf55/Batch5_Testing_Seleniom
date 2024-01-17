package com.kraftechnologie.pages;

import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[class*=afm],[class*=ps-2]")
    public List<WebElement> upTitles;

    /**
     * SOFT ASSERTION
     */

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboardElement;

    @FindBy(xpath = "//span[.='Developers']")
    public WebElement developersElement;

    @FindBy(xpath = "//span[.='Components']")
    public WebElement componentsElement;


    public void navigateToModule(String menu) {
        String locatorPath = "//span[.='" + menu + "']";
        WebElement element = Driver.get().findElement(By.xpath(locatorPath));
        //click on webElement
        BrowserUtils.clickWithJS(element);
    }
    public void navigateToModule(String menu,String submenu) {
        String locatorPath = "//span[.='" + menu + "']";
        WebElement element = Driver.get().findElement(By.xpath(locatorPath));
        //click on webElement
        BrowserUtils.clickWithJS(element);



        String locatorPath2 = "//span[.='" + submenu + "']";
        WebElement element2 = Driver.get().findElement(By.xpath(locatorPath2));
        BrowserUtils.clickWithJS(element2);

    }
    public String getAccountName(String accountName){
       return Driver.get().findElement(By.xpath("//span[text()='"+accountName+"']")).getText();
    }

    //method overload
    public String getAccountName(){
       return upTitles.get(upTitles.size()-1).getText();
    }

}

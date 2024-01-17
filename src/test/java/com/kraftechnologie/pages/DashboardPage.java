package com.kraftechnologie.pages;

import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends BasePage{


    @FindBy(xpath = "//h5[.='About']")
    public WebElement aboutElement;
    @FindBy(xpath = "//h5[.='Profile Details']")
    public WebElement profileDetails;







}

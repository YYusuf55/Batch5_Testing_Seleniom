package com.kraftechnologie.pages;

import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage extends BasePage {

    @FindBy(css="#about")
    public WebElement aboutTextBox;

    @FindBy(xpath = "(//input[@id='company'])[1]")
    public WebElement companyTextBox;

    @FindBy(css="select#job")
    public WebElement jobDropDownMenu;

    @FindBy(css="#website")
    public WebElement webSiteTexbox;

    @FindBy(xpath = "(//input[@id='location'])[1]")
    public WebElement locationTextBox;



    @FindBy(css = "#skills")
    public WebElement skillsTextBox;

    @FindBy(xpath = "//button[.='Save Changes']")
    public WebElement saveButton;


    public void selectJob(String visibleText) {
        Select select = new Select(jobDropDownMenu);
        select.selectByVisibleText(visibleText);
    }
    public void clickOnSaveButton(){
        BrowserUtils.clickWithJS(saveButton);
    }
    public String getJobName(){
        Select select = new Select(jobDropDownMenu);
        return select.getFirstSelectedOption().getText();
    }

}

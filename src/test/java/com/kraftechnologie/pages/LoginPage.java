package com.kraftechnologie.pages;

import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {



    @FindBy(id = "email")
    public WebElement l_emailInputBox;
    @FindBy(id = "yourPassword")
    public WebElement l_passwordInputBox;
    @FindBy(css = "[type='submit']")
    public WebElement l_loginBtn;
    @FindBy(xpath = "//*[contains(text(),'Password is incorrect. Please check')]")
    public WebElement l_wrongPasswordMessage;
    @FindBy(xpath = "//*[contains(text(),'Email address is incorrect. Please check')]")
    public WebElement l_wrongEmailMessage;

    public void login() {
        String email = ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");
        l_emailInputBox.sendKeys(email);
        l_passwordInputBox.sendKeys(password);
        l_loginBtn.click();
    }

    public void login(String email, String password) {
        l_emailInputBox.sendKeys(email);
        l_passwordInputBox.sendKeys(password);
        l_loginBtn.click();
    }

}

package com.kraftechnologie.tests.day20_ddf;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DataProvider_LoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Book.xlsx","Sheet2");
        String[][] dataArrayWithoutFirstRow = excelUtil.getDataArrayWithoutFirstRow();
        return dataArrayWithoutFirstRow;
    }


    @Test(dataProvider = "userData")
    public void loginTestWithDateProvider(String username,String password,String name) {
        /**
         * validate login functionality with different users
         * by using @DataProvider
         */
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage=new LoginPage();


        //send data to email input box
        loginPage.l_emailInputBox.sendKeys(username);
        //send data to password input box
        loginPage.l_passwordInputBox.sendKeys(password);
        //click on login button
        loginPage.l_loginBtn.click();

        //validate user is logged in
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/index";
        Assert.assertEquals(actualUrl,expectedUrl);

        //
        String actualName=loginPage.getAccountName();
        String expectedName=name;
        Assert.assertEquals(actualName,expectedName);
    }
}

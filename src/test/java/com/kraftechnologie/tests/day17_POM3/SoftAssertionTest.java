package com.kraftechnologie.tests.day17_POM3;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest extends TestBase {

    @Test
    public void hardAssertion() {
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        //HARD ASSERTION
        //ilk assertion'da test patlayacağı için sonraki kod satırları çalışmaz
        //dolayısıyla ikinci ve üçüncü verificationlar yapılamaz
        Assert.assertEquals(loginPage.dashboardElement.getText(), "Dashboarddddd");
        // some coding
        Assert.assertEquals(loginPage.developersElement.getText(), "Developers");
        // some coding
        Assert.assertEquals(loginPage.componentsElement.getText(), "Components");
    }


    @Test
    public void softAssertion() {
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        //SOFT ASSERTION
        //herhangi bir validation geçersizde olsa o satırda kod patlamaz
        //assertAll() methoduna kadar execution devam eder
        //assertAll() satırına kadar assertion logları birikir ve bu satırda sonuç belli olur
        //bütün assertionlar true --> test geçer
        //bir ya da birden fazla assertion fail --> test kalır

        //create a softAssert object
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.dashboardElement.getText(), "Dashboarddddddddddd");
        //some coding
        softAssert.assertEquals(loginPage.developersElement.getText(), "Developersssssssss");
        //some coding
        softAssert.assertEquals(loginPage.componentsElement.getText(), "Components");

        softAssert.assertAll();

    }

}

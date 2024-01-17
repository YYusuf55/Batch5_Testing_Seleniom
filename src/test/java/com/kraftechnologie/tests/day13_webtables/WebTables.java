package com.kraftechnologie.tests.day13_webtables;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void pritTable() {
        //print whole table
        WebElement table= driver.findElement(By.xpath("//table[@id='t01']"));
        System.out.println("table.getText() = " + table.getText());

    }

    @Test
    public void getAllHeaders() {
        //how to get all headers
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='t01']//th"));
        //get size of elements
        System.out.println("elements.size() = " + elements.size());
        //get text of elements
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }


    }

    @Test
    public void printTableSize() {
        //number of rows with header
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='t01']//tr"));
        System.out.println("elements.size() = " + elements.size());

        //number of rows without header
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());
    }

    @Test
    public void getRow() {
        //print the second row
        WebElement row= driver.findElement(By.xpath("//table[@id='t01']//tr[3]"));
        System.out.println("row.getText() = " + row.getText());

        System.out.println(" ");

        //get all rows dynamically and print them one by one
        List<WebElement> allRowsWithhoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        System.out.println("allRowsWithhoutHeader.size() = " + allRowsWithhoutHeader.size());
        for (WebElement element : allRowsWithhoutHeader) {
            System.out.println("element.getText() = " + element.getText());
        }
        System.out.println(" ");
        //get all rows dynamically and print them one by one(with for index loop)
        for (int i = 1; i <= allRowsWithhoutHeader.size(); i++) {
            WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[" + i + "]"));
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void getAllCellInOneRow() {
        //get all cell of first row
        List<WebElement> elements = driver.findElements(By.xpath("(//table[@id='t01']//td/..)[1]/td"));
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void getASingleCellInOneRow() {
        //get the third cell of first row-->45
        WebElement thirdCellOfFirstRow= driver.findElement(By.xpath("(//table[@id='t01']//td/..)[1]//td[3]"));
        System.out.println("thirdCellOfFirstRow.getText() = " + thirdCellOfFirstRow.getText());
        Assert.assertEquals(thirdCellOfFirstRow.getText(),"45");

        //get the second cell of second row--> Jackson
        WebElement secondcellofseconnow= driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]//td[2]"));
        System.out.println("secondcellofseconnow.getText() = " + secondcellofseconnow.getText());
        Assert.assertEquals(secondcellofseconnow.getText(),"Jackson");
    }

    @Test
    public void printAllCellsByIndex() {
        //we would like to write a code that it will print all cells one by one

        int rowNumber = getNumberOfRows();
        int columnNumber=getNumberOfColumns();

        for (int i = 1; i <= rowNumber; i++) {
            for (int j= 1; j <= columnNumber; j++) {

                WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[" + i + "]/td[" + j + "]"));
                System.out.println(i+ "/" +j+ "-->" + element.getText());


            }
        }

    }
    public int getNumberOfRows(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        return elements.size();
    }
    public int getNumberOfColumns(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='t01']//th"));
        return elements.size();
    }

    //here is the METHOD that we aimed to reach during the whole evening
    public WebElement getSpecificCell(int row,int column){
        WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[" + row + "]/td[" + column + "]"));
        return element;
    }

    @Test
    public void test() {
        //validate that value of 3rd rpw and 2nd cell is 'Doe'
        WebElement specificCell = getSpecificCell(3, 2);
        String actual=specificCell.getText();
        String expected="Doe";
        Assert.assertEquals(actual,expected);
    }
}

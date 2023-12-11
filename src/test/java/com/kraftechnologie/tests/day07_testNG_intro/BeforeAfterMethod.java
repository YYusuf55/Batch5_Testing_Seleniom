package com.kraftechnologie.tests.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {


    @BeforeMethod
    public void setUp() {
        System.out.println("****** BEFORE METHOD *******");
        System.out.println("WebDriver, Opening Chrome");

    }

    @Test
    public void test1() {
        System.out.println("First Test Case");
        System.out.println("go to amazon");
        System.out.println("write selenium in the search box ");
        System.out.println("verify that result text has selenium");
    }

   @Test //@Ignore
    public void test2() {
        System.out.println("Second Test Case");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("****** AFTER METHOD *******");
        System.out.println("Closing browser, close");
    }

    @Test
    public void test3() {
        System.out.println("Third Test Case");
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println("****** BEFORE CLASS *******");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("****** AFTER CLASS *******");
    }

}

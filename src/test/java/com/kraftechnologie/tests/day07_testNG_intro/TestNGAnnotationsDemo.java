package com.kraftechnologie.tests.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {
    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");
    }

    @Test
    public void test1() {
        System.out.println("First Test Case");
        Assert.assertEquals("title","title","title is NOT match");
        System.out.println("** second assertion **");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Case");
        Assert.assertEquals("test","test2");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }

    @Test
    public void test3() {
        String expectedTitle="Kraft";
        String actualTitle="KraftTech";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify that title startds with Kraft");
    }

    @Test
    public void test4() {
        String email="batch5@kraftech.com";
//        if(email.contains("@")){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//        }
        Assert.assertTrue(email.contains("@"));
    }

    @Test
    public void testtest5() {
        Assert.assertFalse(0>1,"verify that 0 is not greater that 1");
    }

    @Test
    public void test6() {
        Assert.assertNotEquals("two","one");
    }
}

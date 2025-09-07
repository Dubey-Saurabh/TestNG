package com.testng;

import org.testng.annotations.*;

public class ClassOne {

    @Test(groups = {"regression", "smoke"})
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }

    @BeforeGroups(groups = {"regression", "smoke"})
    public void beforeGroups() {
        System.out.println("beforeGroups");
    }


    @AfterGroups(groups = {"regression", "smoke"})
    public void afterGroups() {
        System.out.println("AfterGroups");
    }

}



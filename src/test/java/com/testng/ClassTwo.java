package com.testng;

import org.testng.annotations.*;

public class ClassTwo {

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @Test(groups = {"regression", "smoke"})
    public void test4(){
        System.out.println("test4");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }







}

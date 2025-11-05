package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting2 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(threadPoolSize = 3, invocationCount = 3)
    public void test3() {
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
        System.out.println(Thread.currentThread().getName() + ": Bootstrap alert Page");
    }

    @Test
    public void test4() {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        System.out.println(Thread.currentThread().getName() + ": Java Script alert Page");
    }
}

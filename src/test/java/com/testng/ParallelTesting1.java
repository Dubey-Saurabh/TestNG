package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting1 {

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

    @Test
    public void test1() {
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-date-picker-demo");
        System.out.println(Thread.currentThread().getName() + ": Jquery Date Picker Demo Page");
    }

    @Test
    public void test2() {
        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");
        System.out.println(Thread.currentThread().getName() + ": Data List Filter Demo Page");
    }
}

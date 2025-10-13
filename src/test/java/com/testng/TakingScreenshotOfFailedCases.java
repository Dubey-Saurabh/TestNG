package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakingScreenshotOfFailedCases {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }


    @Test
    public void testCheckboxDemo() {
        driver.findElement(By.linkText("Simple Form Demo")).click();
        driver.findElement(By.xpath("//p[text()='Enter Message']//following-sibling::input")).sendKeys("Learning is important!");
        driver.findElement(By.cssSelector("#showInput")).click();
        String actualMessage = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualMessage, "Learning is important!!", "Not Matching");
    }

    @AfterMethod
    public void takesScreenshotForFailureTests(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "\\screenshots\\" + testResult.getName() + ".png");

            try {
                FileUtils.copyFile(source, destination);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}

package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedClass {

    WebDriver driver;

    @Parameters({"URL"})
    @BeforeClass
    public void setUp(String url) {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    @Parameters({"Task", "TestResult"})
    public void fileDownloadTest(String task, String result) {
        driver.findElement(By.linkText("File Download")).click();
        driver.findElement(By.id("textbox")).sendKeys(task + "Execution" + result);
        driver.findElement(By.id("create")).click();
        driver.findElement(By.id("link-to-download")).click();
    }


}

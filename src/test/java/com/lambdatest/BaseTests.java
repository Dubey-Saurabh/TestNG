package com.lambdatest;

import com.lambdatest.pages.BasePage;
import com.lambdatest.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private final String Aut_URL = "https://www.lambdatest.com/selenium-playground/";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(Aut_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
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

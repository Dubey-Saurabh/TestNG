package com.testng;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DynamicWaits {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }

    @Test
    public void explicitWaitTest() {
        driver.findElement(By.linkText("Dynamic Data Loading")).click();
        driver.findElement(By.cssSelector("#save")).click();
        By image = By.xpath("//div[@id='loading']/img");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
        boolean imageDisplayed = driver.findElement(image).isDisplayed();
        Assert.assertTrue(imageDisplayed, "Image is not displayed");

    }

    @Test
    public void fluentWaitTest() {
        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.cssSelector("#downloadButton")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement progressBar = driver.findElement(By.xpath("//div[@id='dialog']/div[@class='progress-label']"));
                String progressBarText = progressBar.getText();

                if (progressBarText.equals("Complete!")) {
                    System.out.println("Progress is complete.");
                    return progressBar;
                } else {
                    System.out.println(progressBar.getText());
                    return null;
                }
            }
        });
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}




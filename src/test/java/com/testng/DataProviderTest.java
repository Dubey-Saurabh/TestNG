package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @DataProvider
    public Object[][] getAjaxData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "John Doe";
        data[0][1] = "Tester";
        data[1][0] = "Jane Doe";
        data[1][1] = "Senior Tester";

        return data;
    }

    @Test(dataProvider = "getAjaxData")
    public void testAjaxForm(String Name, String Comment) {
        System.out.println("Name: " + Name);
        System.out.println("Comment: " + Comment);

        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.findElement(By.id("title")).sendKeys(Name);
        driver.findElement(By.id("description")).sendKeys(Comment);
        driver.findElement(By.id("btn-submit")).click();
    }

    @Test(dataProviderClass = DataProviderOnly.class, dataProvider =  "input-provider")
    public void testInputFormData(String Name, String Email, String inputPassword) {
        System.out.println("Name: " + Name);
        System.out.println("Email: " + Email);
        System.out.println("InputNumber: " + inputPassword);

        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.findElement(By.id("name")).sendKeys(Name);
        driver.findElement(By.id("inputEmail4")).sendKeys(Email);
        driver.findElement(By.id("inputPassword4")).sendKeys(inputPassword);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}

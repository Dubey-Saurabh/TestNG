package com.lambdatest;

import com.lambdatest.pages.BootstrapProgressBarPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarTest extends BaseTests {

    SoftAssert softAssert = new SoftAssert();
    BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();

    @Test
    public void progressBarTest() {
        homePage.clickOnBootstrapProgressBar();
        progressBarPage.clickStartDownloadButton();
        String actualMessage = progressBarPage.getCompletedMessage();
        String actualProgressBarPercentage = progressBarPage.getProgressBarPercentage();
        softAssert.assertEquals(actualMessage, "Download completed!", "Message is incorrect");
        softAssert.assertEquals(actualProgressBarPercentage, "100%", "ProgressBar percentage is incorrect");
        softAssert.assertAll();

    }


}

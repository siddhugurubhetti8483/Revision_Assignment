package evl.com.demoqa.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import evl.com.demoqa.Base.BaseTest;

public class InteractionTests extends BaseTest{
    
    @Test(groups = {"Smoke"})
    public void HandlingAlerts(){
        driver.get(baseURL+"/alerts");

        WebElement confBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmButton")));
        confBtn.click();

        Alert alertBtn = wait.until(ExpectedConditions.alertIsPresent());
        alertBtn.accept();

        WebElement confresult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmResult")));

        Assert.assertEquals(confresult.getText().trim(), "You selected Ok");
    }

    @Test(groups = {"Regression"})
    public void HandlingiFrames(){
        driver.get(baseURL+"/frames");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));

        WebElement handing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));

        Assert.assertEquals(handing.getText().trim(), "This is a sample page");

        driver.switchTo().defaultContent();
    }
}

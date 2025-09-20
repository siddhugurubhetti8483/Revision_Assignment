package evl.com.demoqa.test;

import java.time.MonthDay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import evl.com.demoqa.Base.BaseTest;

public class DataDrivenStudentFormTests extends BaseTest{

    @DataProvider(name = "studentData")
    public Object[][] studentData(){
        return new Object[][]{
            {"John", "Doe", "johan@gmail.com", "Male", "9857412589"},
            {"Rohit", "Shah", "rohit@gmail.com", "Male", "9857412589"}
        };
    }
    

    @Test(dataProvider = "studentData", groups = {"Regression"})
    public void DataDrivenFormSubmission(String fName, String lName, String email, String gender, String mobile){
        driver.get(baseURL+"/automation-practice-form");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(fName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys(lName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys(email);

        WebElement gendlable = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
        gendlable.click();

        driver.findElement(By.id("userNumber")).sendKeys(mobile);

        WebElement subBtn = driver.findElement(By.id("submit"));
        subBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        String ExpName = fName+" "+lName;

        String modName = driver.findElement(By.xpath("//td[normalize-space()='John Doe']")).getText();
        String modEmail = driver.findElement(By.xpath("//td[normalize-space()='johan@gmail.com']")).getText();

        Assert.assertEquals(modName.trim(), ExpName);
        Assert.assertEquals(modEmail.trim(), email);

        driver.findElement(By.id("closeLargeModal")).click();

    }
}

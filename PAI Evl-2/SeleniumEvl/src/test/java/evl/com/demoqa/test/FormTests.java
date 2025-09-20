package evl.com.demoqa.test;


import javax.swing.Box;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import evl.com.demoqa.Base.BaseTest;

public class FormTests extends BaseTest {


    @Test(groups = {"Smoke","Regression"})
    public void TextBoxSubmission(){
        driver.get(baseURL+"/text-box");

        WebElement fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
        String name = "John Doe";
        fullName.sendKeys(name);

        String email = "johndoe@gmail.com";

        driver.findElement(By.id("userEmail")).sendKeys(email);

        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", submit);

        WebElement output = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));

        String expected = "Name:"+name+"\nEmail:"+email;

        Assert.assertEquals(output.getText().trim(), expected, "Name/Email should be displayed");
    }

    @Test(groups = {"Regression"})
    public void CheckBoxSelection(){
        driver.get(baseURL+"/checkbox");

        WebElement expBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Expand all']")));
        expBtn.click();

        WebElement docuEle = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='tree-node-documents']")));
        docuEle.click();

        WebElement res = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertTrue(res.getText().toLowerCase().contains("documents"),"Result should be confirm");
    }
}

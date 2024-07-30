package com.herocuapp.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {

    @Test
    public void loginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        String loginPage = "https://the-internet.herokuapp.com/login";
        driver.get(loginPage);
        driver.manage().window().maximize();
        System.out.println("Page is opened");

        WebElement loginFiled = driver.findElement(By.id("username"));
        loginFiled.sendKeys("tomsmith");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        WebElement successMessage = driver.findElement(By.cssSelector("div#flash"));
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://the-internet.herokuapp.com/secure";
        //driver.wait(3000);
        Assert.assertEquals(actualLink, expectedLink, "actual Url is not the same as expected");
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button cannot be found on page");
        Assert.assertTrue(successMessage.isDisplayed(), "Success message cannot be found on page");
        Assert.assertTrue(actualLink.contains(expectedLink), "Actual Url does not match expected");
        driver.close();
    }
}

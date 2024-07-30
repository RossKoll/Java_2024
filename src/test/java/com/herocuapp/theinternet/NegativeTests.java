package com.herocuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    @Test
    public void negativeLogin(){

        WebDriver driver = new ChromeDriver();

        //open login page
        String loginPage = "https://the-internet.herokuapp.com/login";
        driver.manage().window().maximize();
        driver.get(loginPage);
        System.out.println("Login page is opened");

        //set incorrect username
        WebElement loginField = driver.findElement(By.id("username"));
        String incorrectUsername = "incorrectUsername";
        loginField.sendKeys(incorrectUsername);
        System.out.println("username is set as : " + incorrectUsername);

        //set correct password
        WebElement passwordField = driver.findElement(By.name("password"));
        String passwordText = "SuperSecretPassword!";
        passwordField.sendKeys(passwordText);
        System.out.println("password set as : " + passwordText);

        //click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        System.out.println("Login button clicked");

        //field error message text
        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println("Error message found");
        String actualErrorText = errorMessage.getText();
        String expectedErrorText = "Your username is invalid!\n" +
                "×";

        //Check error message text
        Assert.assertEquals(expectedErrorText, actualErrorText, "Test fail as actual error message is :\n " + actualErrorText);
        driver.quit();

        System.out.println("End of the test");

    }
}

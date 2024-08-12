package com.herocuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests {

    private WebDriver driver;
    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    private void setUp(@Optional("chrome") String browser){
        switch (browser){
            case "chrome" -> {
                driver = new ChromeDriver();
                break;
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
                break;
            }
            default -> driver = new ChromeDriver();

        }

        driver.manage().window().maximize();
    }

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeLogin(String username, String password, String expectedMessage){

        //WebDriver driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
       // WebDriver driver = new FirefoxDriver();

        //open login page
        String loginPage = "https://the-internet.herokuapp.com/login";
        //driver.manage().window().maximize();
        driver.get(loginPage);
        System.out.println("Login page is opened");

        //set incorrect username
        WebElement loginField = driver.findElement(By.id("username"));
        String incorrectUsername = username;
        loginField.sendKeys(incorrectUsername);
        System.out.println("username is set as : " + incorrectUsername);

        //set correct password
        WebElement passwordField = driver.findElement(By.name("password"));
        String passwordText = password;
        passwordField.sendKeys(passwordText);
        System.out.println("password set as : " + passwordText);

        //sleep(3000);

        //click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        System.out.println("Login button clicked");

        //field error message text
        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println("Error message found");
        String actualErrorText = errorMessage.getText();
        String expectedErrorText = expectedMessage;
//        "Your username is invalid!\n" +
//                "×";

        //Check error message text
        //Assert.assertEquals(expectedErrorText, actualErrorText, "Test fail as actual error message is :\n " + actualErrorText);
        Assert.assertTrue(actualErrorText.contains(expectedErrorText));

        System.out.println("End of the test");

    }

    @Test(groups = "positiveTest")
    public void loginPositiveTest() {

        String loginPage = "https://the-internet.herokuapp.com/login";
        driver.get(loginPage);
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
    }

    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
    }


    private void sleep(long m){
        try {
            Thread.sleep(m);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

package com.herocuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ExceptionTests {

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
        //driver.manage().window().setPosition(new Point(-1000,200));
    }

    @Test
    public void handlingNoSuchElementException() throws InterruptedException {

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        WebElement addButton = driver.findElement(By.xpath("//button[@id='add_btn']"));

        addButton.click();
        System.out.println("Add button was clicked");

        //Implicit wait
        implicitWaitOfElement(5);

        //WebElement secondInputRow = driver.findElement(By.xpath("(//input[@class='input-field'])[2]"));
        WebElement secondInputRow = driver.findElement(By.xpath("//div[@id='row2']/ input"));

        Assert.assertTrue(secondInputRow.isDisplayed(), "Element : Second Raw was not found");

    }

    private void implicitWaitOfElement(int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }


    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
    }
}

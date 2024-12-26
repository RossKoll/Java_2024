package com.herocuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ExceptionTest {
        private WebDriver driver;

        @Parameters({ "browser" })
        @BeforeMethod(alwaysRun = true)
        private void setUp(@Optional("chrome") String browser) {
//		Create driver
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                default:
                    System.out.println("Do not know how to start " + browser + ", starting chrome instead");
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
            }

            // Move browser window to the left monitor
            //driver.manage().window().setPosition(new Point(-1000,200));

            // maximize browser window
            driver.manage().window().maximize();
        }

        @Test
        public void noSuchElementExceptionTest( ) {
            //Test case 1: NoSuchElementException
            //Open page
            driver.get("https://practicetestautomation.com/practice-test-exceptions/");

            //Click Add button
            WebElement addButtonElement = driver.findElement(By.id("add_btn"));
            addButtonElement.click();

            // Implicit wait
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Explicit wait
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            WebElement row2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));

            //Verify Row 2 input field is displayed
            //WebElement row2Input = driver.findElement(By.xpath("//div[@id='row2']/input"));
            Assert.assertTrue(row2Input.isDisplayed(), "Row 2 is not displayed");
        }

        @AfterMethod(alwaysRun = true)
        private void tearDown() {
            // Close browser
            driver.quit();
        }
    }


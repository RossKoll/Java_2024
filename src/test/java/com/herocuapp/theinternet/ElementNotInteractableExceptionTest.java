package com.herocuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ElementNotInteractableExceptionTest {
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

            //set text
            row2Input.sendKeys("some random text");

            WebElement saveButton = driver.findElement(By.xpath("//div[@id='row2']/button[@id='save_btn']"));
            saveButton.click();

            WebElement confirmationMessage = driver.findElement(By.xpath("//div[@id='confirmation']"));
            String actualMessageText = confirmationMessage.getText();
            Assert.assertEquals(actualMessageText, "Row 2 was saved", "Text is not the same");
            //Verify Row 2 input field is displayed
            //WebElement row2Input = driver.findElement(By.xpath("//div[@id='row2']/input"));
            Assert.assertTrue(row2Input.isDisplayed(), "Row 2 is not displayed");
        }

        @Test
        public void invalidStateException() throws InterruptedException {
            driver.get("https://practicetestautomation.com/practice-test-exceptions/");
            WebElement editButtonRowOne = driver.findElement(By.xpath("//div[@id='row1']/button[@name='Edit']"));

            editButtonRowOne.click();
            WebElement textFiledRowOne = driver.findElement(By.xpath("//div[@id='row1']/input[@class='input-field']"));
            textFiledRowOne.clear();
            textFiledRowOne.sendKeys("New text");

            String savedTextInRowOne = textFiledRowOne.getAttribute("value");

            WebElement saveButtonRowOne = driver.findElement(By.xpath("//div[@id='row1']/button[@id='save_btn']"));
            saveButtonRowOne.click();

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            WebElement confirmationMessageRowOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='confirmation']")));
            //WebElement confirmationMessageRowOne = driver.findElement(By.xpath("//div[@id='confirmation']"));
            String actualConfirmationMessageText = confirmationMessageRowOne.getText();

            Assert.assertEquals(savedTextInRowOne,"New text", " Text inside field One is different");
            Assert.assertEquals(actualConfirmationMessageText, "Row 1 was saved", "Message is not equals");

        }

        @AfterMethod(alwaysRun = true)
        private void tearDown() {
            // Close browser
            driver.quit();
        }
    }


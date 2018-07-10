package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", "/Users/xx/Desktop/testy drivers/testy/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://google.pl");
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("q")).sendKeys("JavaStart");
        driver.findElement(By.name("q")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }



    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
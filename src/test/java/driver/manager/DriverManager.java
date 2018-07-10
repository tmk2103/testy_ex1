package driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "/Users/xx/Desktop/testy drivers/testy/geckodriver");
            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
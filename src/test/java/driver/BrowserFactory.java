package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "/Users/xx/Desktop/testy drivers/testy/geckodriver");
                return new FirefoxDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}
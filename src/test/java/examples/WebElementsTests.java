package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class WebElementsTests {
    private WebDriver driver;


    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", "/Users/xx/Desktop/testy/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://przyklady.javastart.pl/test/full_form.html");

    }

    @Test
    public void typingIntoWebElementTest()  {

        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("username");
        String typeUserNameValue = userNameField.getAttribute("value");
        assertEquals(typeUserNameValue,"username");

    }

    @Test
    public void filePickingTest()  {

        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("/Users/xx/Desktop/testy/test.txt");

    }

    @Test
    public void checkRadioButtonTest()  {

        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        maleRadioButton.click();
        Assert.assertTrue(maleRadioButton.isSelected());
        Assert.assertFalse(femaleRadioButton.isSelected());

    }


    @AfterTest
    public void afterTest() {

        driver.close();
    }
}

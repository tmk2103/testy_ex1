package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class ProductPage {

    private Logger logger = LogManager.getRootLogger();


    @FindBy(xpath = "//*[contains(text(), 'Add to Cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='Cart']//h2")
    private WebElement shoppingCartHeader;

    public ProductPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public ProductPage clickAddToCart() {
        addToCartButton.click();
        logger.info("Click add to cart");
        return new ProductPage();
    }

    public ProductPage checkingTheCurrentHeader() {
        String actualTitle = shoppingCartHeader.getText();
        assertEquals(actualTitle, "Shopping Cart");
        return this;
    }
}


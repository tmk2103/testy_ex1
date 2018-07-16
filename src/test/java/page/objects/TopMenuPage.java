package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import waits.WaitForElement;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TopMenuPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signInLink;

    @FindBy(xpath = "//a[contains(text(),'Sign Out')]")
    private WebElement signOutLink;

    @FindBy(xpath = "//div[@id='SearchContent']//form//input[1]")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='SearchContent']//form//input[2]")
    private WebElement searchButton;

    @FindBy(xpath = "//tbody[1]/tr[2]/td[3]")
    private WebElement productNameFirstRow;

    @FindBy(xpath = "//tbody//tr[2]//td[2]//b[1]")
    private WebElement productIdFirstRow;



    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage clickOnSignInLink(){
        WaitForElement.waitUntilElementIsClickable(signInLink);
        signInLink.click();
        logger.info("Clicked on Sign In Link");
        return new LoginPage();
    }

    public LoginPage clickOnSignOutLink(){
        WaitForElement.waitUntilElementIsClickable(signOutLink);
        signOutLink.click();
        logger.info("Clicked on Sign out Link");
        assertEquals(signOutLink.getText(),"Sing Out");
        return new LoginPage();

    }



    public TopMenuPage typeIntoSearchField(String searchText){
        WaitForElement.waitUntilElementIsVisible(searchField);
        searchField.sendKeys(searchText);
        logger.info("Type text into search Field");
        return new TopMenuPage();
    }

    public TopMenuPage clickOnSearchButton(){
        searchButton.click();
        logger.info("Click on search button");
        return new TopMenuPage();
    }

    public TopMenuPage isProductVisibleAfterSearching(String product){
        String prodName = productNameFirstRow.getText();
        assertTrue(prodName.contains(product));
        logger.info("Product is visible after search");
        return new TopMenuPage();
    }

    public TopMenuPage clickOnFirstProduct(){
        WaitForElement.waitUntilElementIsVisible(productNameFirstRow);
        productIdFirstRow.click();
        logger.info("Go to product page");
        return new TopMenuPage();
    }


}
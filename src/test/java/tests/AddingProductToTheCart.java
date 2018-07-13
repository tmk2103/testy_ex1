package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.ProductPage;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.HOMEPAGE_URL;

public class AddingProductToTheCart extends TestBase {

    @Test
    public void isTheProductInTheCart() throws InterruptedException {
        DriverUtils.navigateToPage(HOMEPAGE_URL);

        SearchEngineTests searchEngineTests = new SearchEngineTests();
        searchEngineTests.displayingProductAfterEnteringNameInSearchEngine();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnFirstProduct();

        ProductPage productPage = new ProductPage();
        productPage
                .clickAddToCart()
                .checkingTheCurrentHeader();


        //Thread.sleep(3000);

    }

}
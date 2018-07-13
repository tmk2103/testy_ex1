package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.HOMEPAGE_URL;
import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class SearchEngineTests extends TestBase {

    @Test
    public void displayingProductAfterEnteringNameInSearchEngine()  {
        DriverUtils.navigateToPage(HOMEPAGE_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .typeIntoSearchField("fish")
                .clickOnSearchButton()
                .isProductVisibleAfterSearching("fish");

    }

}
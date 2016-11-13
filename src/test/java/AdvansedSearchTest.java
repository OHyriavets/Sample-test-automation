import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchInformationPage;


public class AdvansedSearchTest extends BaseTest {

    public HomePage homePage;


    @BeforeClass
    public void beforeTest(){
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        homePage = loginRegistrationPage.loginFormFillAndSubmit("", "");
        Assert.assertTrue(homePage.isPageLoaded());
    }

    @DataProvider(name = "SearchTerms")
    public Object[][] searchTermData() {
        return new Object[][] {
                { "HR", "HR" },
                { "hr", "hr"},
        };
    }

    @Test(dataProvider = "SearchTerms")
    public void AdvancedSearchTest(String searchTerm, String expectedContaintedTerm) {
        SearchInformationPage advancedSearchPage = homePage.clikAdvancedSearchBtn();
        Assert.assertTrue(advancedSearchPage.AdvancedSearchPageIsLoaded());
        advancedSearchPage.fillClickSearchForm(searchTerm);
        Assert.assertEquals(advancedSearchPage.getSearchResultOnPage(),10, "Actual results on page number is wrong");
        Assert.assertTrue(advancedSearchPage.getDescriptionStringList().get(0).contains(expectedContaintedTerm), "Expected search term is not found");

    }
}

import org.testng.Assert;
import org.testng.annotations.*;
import page.AdvancedSearchPage;
import page.HomePage;
import page.LoginRegistrationPage;

/**
 * Created by Rost on 12.11.2016.
 */
public class AdvancedSearchTests extends BaseTest{

    public  HomePage homePage;

    /**
     * Pre conditions for all advanced search tests
     */
    @BeforeClass
    public void beforeTest(){
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        homePage = loginRegistrationPage.loginFillandClick("r_belyaev@i.ua", "Ivanov2910");
        Assert.assertTrue(homePage.isPageLoaded());
    }

    /**
     * Data provider which consists of varies input and expected data for AdvancedSearchTest.
     * @return
     */
    @DataProvider(name = "searchTerms")
    public Object[][] searchTermData() {
        return new Object[][] {
                { "HR","HR"},
                { "hr","hr"},
        };
    }

    /**
     * Advanced search test. Filling and submit advanced search form than check results.
     * @param searchTerm
     * @param expectedContainedTerm
     */
    @Test(dataProvider = "searchTerms")
    public void AdvancedSearchTest(String searchTerm, String expectedContainedTerm) {
        AdvancedSearchPage advancedSearchPage = homePage.clikAdvancedSearchBtn();
        Assert.assertTrue(advancedSearchPage.AdvancedSearchPageIsLoaded());
        advancedSearchPage.fillClickSearchForm(searchTerm);
        Assert.assertEquals(advancedSearchPage.getSearchResultsOnPageCount(), 10, "Expected and Actual doesn't equal");
        Assert.assertTrue(advancedSearchPage.isKeyWordsPresentInTitle(expectedContainedTerm), "The found result and key word doesn't equal");

    }
}

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Fill and click advanced search page.
 */
public class AdvancedSearchPage extends BasePage {

    @FindBy(id = "advs")
    private WebElement advancedSearchBox;

    @FindBy(id = "advs-keywords")
    private WebElement keyWordsField;

    @FindBy(className = "submit-advs")
    private WebElement submitAdvancedSeardBtn;

    @FindBy(xpath = "//div[@class='description']/b")
    private List<WebElement> searchResultDescriptionsList;

    @FindBy(xpath = "//div[@class='search-info']/p[contains(text(),'результата для') or contains(text(),'результатов для')or contains(text(),'результат для')]")
    private WebElement resultsForInfoText;

    @FindBy(xpath = "//div[@class='description']/b")
    private WebElement resultFromFoundList;


    /**
     * Constructor which extends driver from base test
     * Initialization all elements
     * @param driver
     */
    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        WaitUntilElementDisplayed(advancedSearchBox);
    }

    /**
     * Verifivation that the advancedSearchform is displayed,
     *
     * @return Verification that is Advanced Search Page Is Loaded
     */
    public boolean AdvancedSearchPageIsLoaded() {
        return WaitUntilElementDisplayed(advancedSearchBox, 10).isDisplayed();
    }

    /**
     * Fill anvanced search form and click.
     * @param Searchterm (key words).
     */
    public void fillClickSearchForm(String Searchterm) {
        WaitUntilElementDisplayed(keyWordsField).clear();
        keyWordsField.sendKeys(Searchterm);
        keyWordsField.submit();
        WaitUntilElementDisplayed(resultsForInfoText, 20);
    }

    /**
     * Creating integer which counts sum of searchResultDescriptionsList.
     * @return sum of searchResultDescriptionsList.
     */
    public int getSearchResultsOnPageCount() {
        return searchResultDescriptionsList.size();
    }

    /**
     * Creating a array massive which gets text from every found result in a page.
     * @return text from every found result in a page.
     */
    public List<String> getDescriptionStringList() {
        List<String> searchResultDescriptionsStringList = new ArrayList<String>();

        for (WebElement searchResultDescriptionsElement : searchResultDescriptionsList) {

            searchResultDescriptionsStringList.add(searchResultDescriptionsElement.getText());
        }
        return searchResultDescriptionsStringList;
    }

    /**
     * Request for title from one of found results.
     * @param resultFromFoundList locating by xpath
     * @return title of resultFromFoundList
     */
    public String getThePersonsTitle(WebElement resultFromFoundList) {
        return resultFromFoundList.getText();
    }
    /**
     * Cheking is key words present in a result from found list.
     * @param keyWords(search term)
     * @return fasle or true result
     */
    public boolean isKeyWordsPresentInTitle(String keyWords) {
        for(WebElement resultFromFoundList : searchResultDescriptionsList) {
            if(!this.getThePersonsTitle(resultFromFoundList).equals(keyWords)) {
                return false;
            }
        }
        return true;
    }
}

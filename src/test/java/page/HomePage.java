package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *Page which concerns only main page
 */
public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@id='main-site-nav']//a[@class='nav-link' and @href='/home?trk=nav_responsive_tab_home']")
    private WebElement homeMenuLink;

    @FindBy(id = "advanced-search")
    private WebElement AdvancedSearchLink;


    /**
     * Constructor which extends driver from base test
     * Initialization all elements
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verification that homeMenuLink is loaded.
     * @return
     */
    public boolean isPageLoaded() {
     return WaitUntilElementDisplayed(homeMenuLink,6).isDisplayed();
    }

    /**
     * ClikAdvancedSearchBtn
     * @return AdvancedSearchPage
     */
    public AdvancedSearchPage clikAdvancedSearchBtn(){
        WaitUntilElementDisplayed(AdvancedSearchLink,20).click();
        return new AdvancedSearchPage(driver);

    }
}

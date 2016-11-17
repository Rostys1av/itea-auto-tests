package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
        protected WebDriver driver;


        public BasePage(WebDriver driver) {  this.driver = driver; }

    /**
     * Navigate to base URL
     * @param URL
     */
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    /**
     * Gets current Browser URL.
     * @return String with current URL value.
     */
    public String getCurrentURL(){
        return driver.getCurrentUrl();

    }

    /**
     * Explisitly waiting fo WebElement visibility.
     * @param element WebElement that will be explicitly waited.
     * @param timeout Maximum waiting time in seconds.
     * @return WebElement that was explicitly waited.
     */
    public WebElement WaitUntilElementDisplayed(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));}

    /**
     * Explisitly waiting fo WebElement visibility.
     * @param element WebElement that will be explicitly waited.
     * @return  WebElement that was explicitly waited.
     */
    public WebElement WaitUntilElementDisplayed(WebElement element){
     return   WaitUntilElementDisplayed(element,10);
   }
}

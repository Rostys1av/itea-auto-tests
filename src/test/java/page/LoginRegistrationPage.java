package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Works with the elements only login-registration page
 */
public class LoginRegistrationPage extends BasePage {

    @FindBy(id = "reg-firstname")
    private WebElement firstNameField;
    @FindBy(id = "reg-lastname")
    private WebElement lastnameField;
    @FindBy(id = "reg-email")
    private WebElement  EmailField;
    @FindBy(id = "reg-password")
    private WebElement  passwordField;
    @FindBy(id = "registration-submit")
    private WebElement  JoinNowButton;
    @FindBy(id = "login-email")
    private WebElement  LoginEmailField;
    @FindBy(id = "login-password")
    private WebElement  LoginPasswordField;
    @FindBy(id = "login-submit")
    private WebElement  LoginSubmitButton;
    @FindBy(className = "alert-content")
    private WebElement  errorMessageBox;

    /**
     * Constructor which extends driver from base test
     * Initialization all elements
     * @param driver
     */
    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Filling the registration form and submit
     * @param firstName Fill firstNameFiled
     * @param lastname Fill lastnameFiled
     * @param Email Fill EmailFiled
     * @param password Fill passwordFiled
     * @return
     */
    public HomePage registrationFormFillSubmit(String firstName, String lastname, String Email, String password) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastnameField.clear();
        lastnameField.sendKeys(lastname);
        EmailField.clear();
        EmailField.sendKeys(Email);
        passwordField.clear();
        passwordField.sendKeys(password);
        JoinNowButton.click();
        return new HomePage(driver);
    }

    /**
     * Filing the login and email field and submit.
     * @param LoginEmail FillLoginEmailFiled
     * @param LoginPassword FillLoginPasswordFiled
     * @return
     */
    public HomePage loginFillandClick (String LoginEmail,String LoginPassword) {
        LoginEmailField.sendKeys(LoginEmail);
        LoginPasswordField.sendKeys(LoginPassword);
        LoginSubmitButton.click();
        return new HomePage(driver);
    }

    /**
     * Get get errormassage text.
     * @return error massage.
     */
    public String getErrormassageText() {
        return errorMessageBox.getText();
    }

}




import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;

/**
 * Class which includes all tests with login-registration page
 */
public class LoginRegistrationTests extends BaseTest {

    /**
     * Data provider which consists of varies input and expected data for errorMassageEmptyFormSubmit test.
     * @return
     */
    @DataProvider(name = "registrationInput")
    public Object[][] registrationInputData() {
        return new Object[][]{
                {"", "last","a@b.com","password","Укажите имя"},
                {"first","","a@b.com","password","Укажите фамилию"},
                {"first", "last","","password","Укажите свой адрес электронной почты"},
                {"first", "last","a@b.com","","Укажите пароль"},
        };
    }

    /**
     * Verification that error massage correctly shows.
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param ErrorMassageTest
     */
    @Test(dataProvider = "registrationInput")
    public void errorMassageEmptyFormSubmit(String firstName, String lastName, String email, String password, String ErrorMassageTest) {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.registrationFormFillSubmit(firstName, lastName,email, password);
        Assert.assertEquals(registrationPage.getErrormassageText(), ErrorMassageTest, "Expected error massage was not found");


    }

    /**
     * Verification that login process works correctly
     */
    @Test(groups = ("loginRegistraionTests"))
    public void loginConfirmationTest() {
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = loginRegistrationPage.loginFillandClick("r_belyaev@i.ua", "Ivanov2910");
        Assert.assertTrue(homePage.isPageLoaded());
    }
}
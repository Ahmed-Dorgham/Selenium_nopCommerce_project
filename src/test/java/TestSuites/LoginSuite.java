package TestSuites;

import Pages.WelcomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import TestBase.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginSuite extends TestBase {

    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;
    private LoginPage loginPageObject;

    /***************************************             Strings        *********************************************/
    String firstName = RandomStringUtils.randomAlphabetic(5);
    private String lastName = RandomStringUtils.randomAlphabetic(5);
    private String email = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    private String invalidEmail = "djf@gmail.com";
    private String password = "123456";
    private String invlaidPassword = "123966";

    /******************************************************************************************************************/

    @BeforeMethod
    private void open_welcome_page() throws InterruptedException {

        welcomePageObject = new WelcomePage(driver);
        welcomePageObject.open_welcome_page();
        if (!(driver.getTitle().contains("nopCommerce demo store"))) {
            open_browser();
            welcomePageObject = new WelcomePage(driver);
            welcomePageObject.open_welcome_page();
        }
    }

    @Test(priority = 1, enabled = true)
    private void login_with_invalid_password_Tc_01() {
        registerPageObject = welcomePageObject.open_register_page();
        welcomePageObject = registerPageObject.register_with_valid_data(firstName, lastName, email, password);
        loginPageObject = welcomePageObject.open_login_page();
        loginPageObject.login_with_invalid_password(email, invlaidPassword);
    }

    @Test(priority = 2, enabled = true)
    private void login_with_invalid_email_Tc_02() {
        loginPageObject = welcomePageObject.open_login_page();
        loginPageObject.login_with_invalid_email(invalidEmail, password);
    }

    @Test(priority = 3, enabled = true)
    private void login_with_empty_email_Tc_03() {
        loginPageObject = welcomePageObject.open_login_page();
        loginPageObject.login_with_empty_email(password);
    }

    @Test(priority = 4, enabled = true)
    private void login_with_empty_password_Tc_04() {
        loginPageObject = welcomePageObject.open_login_page();
        loginPageObject.login_with_empty_password(email);
    }

    @Test(priority = 5, enabled = true)
    private void login_with_empty_password_and_email_Tc_05() {
        loginPageObject = welcomePageObject.open_login_page();
        loginPageObject.login_with_empty_password_and_email();
    }

    @Test(priority = 6, enabled = true)
    private void login_with_valid_data_Tc_06() {
        loginPageObject = welcomePageObject.open_login_page();
        loginPageObject.login_with_valid_data(email, password);
    }

}

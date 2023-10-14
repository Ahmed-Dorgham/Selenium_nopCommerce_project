package TestCases;

import Pages.WelcomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import TestBase.TestBase;
import org.testng.annotations.Test;

public class login_valid_data_TC extends TestBase {

    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;
    private LoginPage loginPageObject;

    /*************************************** ........strings...........  *********************************************/
    String firstName = "aedfed";
    String lastName = "dafceddhf";
    String email = "daddef@gmail.com";
    String password = "123456";

    /*************************************************************************************************/
    @Test (priority = 1)
    private void open_homepage() {
        welcomePageObject = new WelcomePage(driver);
        welcomePageObject.open_welcome_page();
    }
    @Test (priority = 2)
    private void register_with_valid_data() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_valid_data(firstName, lastName, email, password);
    }
    @Test (priority = 3)
    private void login_with_valid_data() {
     loginPageObject = registerPageObject.open_login_page();
     loginPageObject.login_with_valid_data(email, password);
    }
}

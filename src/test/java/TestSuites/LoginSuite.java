package TestSuites;

import Pages.WelcomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import TestBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login_valid_data_TC extends TestBase {

    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;
    private LoginPage loginPageObject;

    /*************************************** ........strings...........  *********************************************/
    String firstName = "aedfed";
    String lastName = "dafcfeddhf";
    String usedEmail = "daddeff@gmail.com";
    String password = "123456";

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
    private void register_with_valid_data_Tc_01() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_valid_data(firstName, lastName, usedEmail, password);
        loginPageObject = registerPageObject.open_login_page();
        loginPageObject.login_with_valid_data(usedEmail, password);
    }

}

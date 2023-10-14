package TestCases;

import Pages.WelcomePage;
import Pages.RegisterPage;
import TestBase.TestBase;
import org.testng.annotations.Test;


public class register_valid_data_TC extends TestBase {

    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;

    /***************************************... strings ...*********************************************/
    String firstName = "dadexh";
    String lastName = "adsdeexh";
    String email = "adsedxh@gmail.com";
    String password = "123456";
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
}

package TestCases;

import Pages.WelcomePage;
import Pages.RegisterPage;
import TestBase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class register_with_valid_data_Tc_01 extends TestBase {

    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;

    /**********************************************... strings ...*************************************************/
    String firstName = "dadexh";
    String lastName = "adsdeexh";
    String email = "adsedxh@gmail.com";
    String invalidEmail = "adsedxh@gmail.com";
    String password = "123456";


    /*****************************************************************************************************************/
  @BeforeClass
    private void open_homepage() {
        welcomePageObject = new WelcomePage(driver);
        welcomePageObject.open_welcome_page();
    }
    @Test(priority = 1)
    private void register_with_invalid_data_Tc_01() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_invalid_data(firstName, lastName, invalidEmail, password);
    }
    @Test (priority = 2)
    private void register_with_valid_data_Tc_02() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_valid_data(firstName, lastName, email, password);
    }

}

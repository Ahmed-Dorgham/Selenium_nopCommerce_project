package TestSuites;

import Pages.WelcomePage;
import Pages.RegisterPage;
import TestBase.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterationSuite extends TestBase {


    /**********************************************... strings ...*************************************************/

    private String firstName = RandomStringUtils.randomAlphabetic(5);
    private String email = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    ;
    private String lastName = RandomStringUtils.randomAlphabetic(5);

    private String existedEmail;
    private String password = "123456";
    private String differentPassword = "123986";
    private String registerationSuccessfulMsg = "Your registration completed";



    /*****************************************************  WebElements  ************************************************************/
    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;

    /*****************************************************************************************************************/
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
        email = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
        existedEmail = email;
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_valid_data(firstName, lastName, email, password);
    }

    @Test(priority = 2, enabled = true)
    private void register_with_existed_email_Tc_02() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_existed_email(firstName, lastName, existedEmail, password);
    }

    @Test(priority = 3, enabled = true)
    private void register_with_not_matching_passwords_Tc_03() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_not_matching_passwords(firstName, lastName, email, password, differentPassword);
    }

    @Test(priority = 4, enabled = true)
    private void register_without_entering_first_name_Tc_04() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_without_entering_first_name(lastName, email, password);
    }

    @Test(priority = 5, enabled = true)
    private void register_without_entering_last_name_Tc_05() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_without_entering_last_name(firstName, email, password);
    }

    @Test(priority = 6, enabled = true)
    private void register_without_entering_email_Tc_06() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_without_entering_email(firstName, lastName, password);
    }

    @Test(priority = 7, enabled = true)
    private void register_without_entering_password_Tc_07() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_without_entering_password(firstName, lastName, email, password);
    }

    @Test(priority = 8, enabled = true)
    private void register_without_entering_confirm_password_Tc_08() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_without_entering_confirm_password(firstName, lastName, email, password);
    }

    @Test(priority = 9, enabled = true)
    private void register_without_entering_all_mandatory_fields_Tc_09() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_without_entering_all_mandatory_fields();
    }

}

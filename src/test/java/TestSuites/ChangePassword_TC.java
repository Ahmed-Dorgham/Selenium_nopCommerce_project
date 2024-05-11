package TestSuites;

import Pages.*;
import TestBase.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePassword_TC extends TestBase {
    /*************************************** ........Strings...........  *********************************************/
    private String firstName = RandomStringUtils.randomAlphabetic(5);
    private String lastName = RandomStringUtils.randomAlphabetic(5);
    private String email = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    String oldPassword = "123456";
    String newPassword = "147258";

    /*************************************** ........WebElements...........  *********************************************/
    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private ChangePasswordPage changePasswordPageObject;
    private MyAccountPage myAccountPageObject;

    /*************************************************************************************************/

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

    @Test(priority = 1)
    public void change_password_and_login_with_new_one_TC() throws InterruptedException {

        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_valid_data(firstName, lastName, email, oldPassword);
        loginPageObject = registerPageObject.open_login_page();
        homePageObject = loginPageObject.login_with_valid_data(email, oldPassword);
        myAccountPageObject = homePageObject.open_my_account_page();
        changePasswordPageObject = myAccountPageObject.open_change_password_page();
        changePasswordPageObject.change_password(oldPassword, newPassword);
        Assert.assertTrue(changePasswordPageObject.get_msg_after_changing_password_successfully().isDisplayed());
        welcomePageObject = changePasswordPageObject.click_on_logout_link();
        loginPageObject = welcomePageObject.open_login_page();
        homePageObject = loginPageObject.login_with_valid_data(email, newPassword);
        Assert.assertTrue(homePageObject.get_logout_element_in_homepage().isDisplayed());
    }

}

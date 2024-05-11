package TestSuites;

import Pages.*;
import TestBase.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToWishList_TC extends TestBase {
    /*************************************** ........Strings...........  *********************************************/
    private String firstName = RandomStringUtils.randomAlphabetic(5);
    private String lastName = RandomStringUtils.randomAlphabetic(5);
    private String email = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    String password = "123456";
    String cityName = "egypt";
    String address = "egypt";
    String postalCode = "12345";
    String phoneNumber = "123456789";
    /*************************************** ........WebElements...........  ****************************************/
    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private DesktopsPage desktopsPageObject;
    private LenovoPage lenovoPageObject;
    private WishListPage wishListPageObject;
    private ShoppingCartPage shoppingCartPageObject;
    private CheckoutPage checkoutPageObject;

    /***********************************************************************************************************/

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
    public void add_product_to_wishlist_TC(){
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_valid_data(firstName, lastName, email, password);
        loginPageObject = registerPageObject.open_login_page();
        homePageObject = loginPageObject.login_with_valid_data(email, password);
        desktopsPageObject = homePageObject.open_desktops_page();
        desktopsPageObject.add_lenovo_to_my_wishlist();
        wishListPageObject = desktopsPageObject.open_wishlist_page();
        Assert.assertTrue(wishListPageObject.get_lenovoDesktop_name_in_wishlist_page().isDisplayed());
    }

}

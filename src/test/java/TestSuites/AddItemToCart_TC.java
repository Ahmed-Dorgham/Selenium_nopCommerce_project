package TestSuites;

import Pages.*;
import TestBase.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart_TC extends TestBase {
    /***************************************        Strings            *********************************************/
    private String firstName = RandomStringUtils.randomAlphabetic(5);
    private String lastName = RandomStringUtils.randomAlphabetic(5);
    private String email = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    String password = "123456";
    String cityName = "egypt";
    String address = "egypt";
    String postalCode = "12345";
    String phoneNumber = "123456789";
    /***************************************     WebElements     *********************************************/
    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private DesktopsPage desktopsPageObject;
    private LenovoPage lenovoPageObject;
    private ShoppingCartPage shoppingCartPageObject;
    private CheckoutPage checkoutPageObject;

    /**************************************************************************************************************/
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
    public void add_item_to_cart_TC() {
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_valid_data(firstName, lastName, email, password);
        loginPageObject = registerPageObject.open_login_page();
        homePageObject = loginPageObject.login_with_valid_data(email, password);
        desktopsPageObject = homePageObject.open_desktops_page();
        lenovoPageObject = desktopsPageObject.open_lenovo_desktop_page();
        shoppingCartPageObject = lenovoPageObject.add_lenovo_desktop_to_cart();
        checkoutPageObject = shoppingCartPageObject.open_checkout_page();
        checkoutPageObject.enter_data_to_billing_address_section(cityName, address, postalCode, phoneNumber);
        checkoutPageObject.enter_data_to_shipping_method_section();
        checkoutPageObject.enter_data_to_payment_method_section();
        checkoutPageObject.enter_data_to_payment_information_section();
        Assert.assertTrue(checkoutPageObject.get_total_price_value_before_confirmation()
                .contains(shoppingCartPageObject.get_total_price_value_in_shopping_cart()));
        System.out.println("total value before confirmation is " + checkoutPageObject.get_total_price_value_before_confirmation() +
                " and this equal to the total price in table which existed in shopping cart page which value is "
                + shoppingCartPageObject.get_total_price_value_in_shopping_cart());
        checkoutPageObject.confirm_payment_process();
    }

}

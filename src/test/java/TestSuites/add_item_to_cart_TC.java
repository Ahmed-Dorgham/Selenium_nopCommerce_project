package TestSuites;

import Pages.*;
import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class add_item_to_cart_TC extends TestBase {
    /*************************************** ........strings...........  *********************************************/
    String firstName = "asdddchde";
    String lastName = "dbdcdsh";
    String email = "scff@gmail.com";
    String password = "123456";
    String cityName = "egypt";
    String address = "egypt";
    String postalCode = "12345";
    String phoneNumber = "123456789";
    /*************************************** ........strings...........  *********************************************/
    private WelcomePage welcomePageObject;
    private RegisterPage registerPageObject;
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private DesktopsPage desktopsPageObject;
    private LenovoPage lenovoPageObject;
    private ShoppingCartPage shoppingCartPageObject;
    private CheckoutPage checkoutPageObject;

    /*************************************************************************************************/
    @Test(priority = 1)
    public void open_homepage() {
        welcomePageObject = new WelcomePage(driver);
        welcomePageObject.open_welcome_page();
        registerPageObject = welcomePageObject.open_register_page();
        registerPageObject.register_with_valid_data(firstName, lastName, email, password);
        loginPageObject = registerPageObject.open_login_page();
        homePageObject = loginPageObject.login_with_valid_data(email, password);
    }

    @Test(priority = 2)
    public void open_desktops_page() {
        desktopsPageObject = homePageObject.open_desktops_page();
        lenovoPageObject = desktopsPageObject.open_lenovo_desktop_page();
    }

    @Test(priority = 3)
    public void add_lenovo_to_shopping_cart() {
        shoppingCartPageObject = lenovoPageObject.add_lenovo_desktop_to_cart();
    }

    @Test(priority = 4)
    public void checkingout() {
        checkoutPageObject = shoppingCartPageObject.open_checkout_button();
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

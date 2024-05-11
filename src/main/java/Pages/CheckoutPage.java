package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage extends UtilitiesMethods {
    private WebDriver driver;
    JavascriptExecutor js;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************     Strings  *************************************************/
    String checkoutPageTitle = "nopCommerce demo store. Checkout";

    /***************************************   WebElements   *********************************************/
    private Select select;
    private WebElement cityField;
    private WebElement addressField;
    private WebElement postalCodeField;
    private WebElement phoneNumberField;
    private WebElement continueBtn;
    private WebElement confirmButton;

    /********************************************************************************************************************/

    public void enter_data_to_billing_address_section(String cityName, String address, String postalCode, String phoneNumber) {
        wait_title_to_contain_specific_text(this.driver, checkoutPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Checkout"));
        // System.out.println("now i am in Checkout page ");
        wait_for_element_with_locator_to_be_visible(this.driver, By.id("BillingNewAddress_CountryId"));
        select = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        select.selectByIndex(2);
        cityField = driver.findElement(By.id("BillingNewAddress_City"));
        enter_text_to_input_field(cityField, cityName);
        addressField = driver.findElement(By.id("BillingNewAddress_Address1"));
        enter_text_to_input_field(addressField, address);
        postalCodeField = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        enter_text_to_input_field(postalCodeField, postalCode);
        phoneNumberField = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        enter_text_to_input_field(phoneNumberField, phoneNumber);
        continueBtn = driver.findElement(By.className("new-address-next-step-button"));
        click_on_element(continueBtn);
    }

    public void enter_data_to_shipping_method_section() {
        wait_for_element_with_locator_to_be_visible(this.driver, By
                .xpath("//label[contains(text(),'Ground ($0.00)')]"));
        continueBtn = driver.findElement(By.className("shipping-method-next-step-button"));
        click_on_element(continueBtn);
    }

    public void enter_data_to_payment_method_section() {
        wait_for_element_with_locator_to_be_visible(this.driver, By
                .xpath("//label[contains(text(),'Check / Money Order')]"));
        continueBtn = driver.findElement(By.className("payment-method-next-step-button"));
        click_on_element(continueBtn);
    }

    public void enter_data_to_payment_information_section() {
        wait_for_element_with_locator_to_be_visible(this.driver, By
                .xpath("//b[contains(text(),'NOP SOLUTIONS')]"));
        continueBtn = driver.findElement(By.className("payment-info-next-step-button"));
        click_on_element(continueBtn);
    }

    public void confirm_payment_process() {
        wait_for_element_with_locator_to_be_visible(this.driver, By.className("confirm-order-next-step-button"));
        confirmButton = driver.findElement(By.className("confirm-order-next-step-button"));
        click_on_element(confirmButton);
        wait_for_element_with_locator_to_be_visible(this.driver, By
                .xpath("//div[@class='page-title']//h1[contains(text(),'Thank you')]"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Thank you"));
        System.out.println("Your order has been successfully processed!");
        System.out.println(driver.findElement(By
                .xpath("//div[@class='order-number']//strong")).getText());
    }

    public String get_total_price_value_before_confirmation() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2000)");
        wait_for_element_with_locator_to_be_visible(this.driver, By
                .xpath("//span[@class='value-summary']//strong"));
        return driver.findElement(By.xpath("//span[@class='value-summary']//strong")).getText();
    }
}

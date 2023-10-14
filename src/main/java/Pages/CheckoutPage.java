package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {

    /*************************************** ........strings...........  *********************************************/
    String totalValueBeforeConfirmation;

    /*************************************** ........strings...........  *********************************************/
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Select select;
    private Select select2;
    private WebElement cityField;
    private WebElement addressField;
    private WebElement postalCodeField;
    private WebElement phoneNumberField;
    private WebElement continueButton;
    private WebElement confirmButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enter_data_to_billing_address_section(String cityName, String address, String postalCode, String phoneNumber) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains("nopCommerce demo store. Checkout"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Checkout"));
        System.out.println("now i am in Checkout page ");
        select = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        select.selectByIndex(2);

        cityField = driver.findElement(By.id("BillingNewAddress_City"));
        cityField.sendKeys(cityName);
        addressField = driver.findElement(By.id("BillingNewAddress_Address1"));
        addressField.sendKeys(address);
        postalCodeField = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        postalCodeField.sendKeys(postalCode);
        phoneNumberField = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phoneNumberField.sendKeys(phoneNumber);
        continueButton = driver.findElement(By.className("new-address-next-step-button"));
        continueButton.click();
    }

    public void enter_data_to_shipping_method_section() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//label[contains(text(),'Ground ($0.00)')]")));
        continueButton = driver.findElement(By.className("shipping-method-next-step-button"));
        continueButton.click();
    }

    public void enter_data_to_payment_method_section() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//label[contains(text(),'Check / Money Order')]")));
        continueButton = driver.findElement(By.className("payment-method-next-step-button"));
        continueButton.click();
    }

    public void enter_data_to_payment_information_section() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//b[contains(text(),'NOP SOLUTIONS')]")));
        continueButton = driver.findElement(By.className("payment-info-next-step-button"));
        continueButton.click();
    }

    public void confirm_payment_process() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .className("confirm-order-next-step-button")));
        confirmButton = driver.findElement(By.className("confirm-order-next-step-button"));
        confirmButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[@class='page-title']//h1[contains(text(),'Thank you')]")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Thank you"));
        System.out.println("Your order has been successfully processed!");
        System.out.println(driver.findElement(By
                .xpath("//div[@class='order-number']//strong")).getText());

    }

    public String get_total_price_value_before_confirmation() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js.executeScript("scrollBy(0,2000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//span[@class='value-summary']//strong")));
        return driver.findElement(By.xpath("//span[@class='value-summary']//strong")).getText();
    }
}

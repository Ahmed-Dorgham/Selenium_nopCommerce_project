package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends UtilitiesMethods {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************************  Strings   ******************************************************/
    String loginPageTitle = "nopCommerce demo store. Login";

    /******************************************************** WebElements *********************************************/
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement loginMsg;

    /********************************************************************************************************************/
    public HomePage login_with_valid_data(String email, String password) {
        wait_title_to_contain_specific_text(driver, loginPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Welcome, Please Sign In!"));
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        wait_for_element_with_locator_to_be_clickable(driver, By.className("login-button"));
        loginButton = driver.findElement(By.className("login-button"));
        click_on_element(loginButton);
        return new HomePage(driver);
    }

    public void login_with_invalid_password(String email, String password) {
        wait_title_to_contain_specific_text(driver, loginPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Welcome, Please Sign In!"));
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        wait_for_element_with_locator_to_be_clickable(driver, By.className("login-button"));
        loginButton = driver.findElement(By.className("login-button"));
        click_on_element(loginButton);
        wait_for_element_with_locator_to_be_visible(driver, By
                .xpath("//div[@class='message-error validation-summary-errors']"));
        loginMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        System.out.println(loginMsg.getText());
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().refresh();

    }

    public void login_with_invalid_email(String email, String password) {
        wait_title_to_contain_specific_text(driver, loginPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Welcome, Please Sign In!"));
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        wait_for_element_with_locator_to_be_clickable(driver, By.className("login-button"));
        loginButton = driver.findElement(By.className("login-button"));
        click_on_element(loginButton);
        wait_for_element_with_locator_to_be_visible(driver, By
                .xpath("//div[@class='message-error validation-summary-errors']"));
        loginMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        System.out.println(loginMsg.getText());
    }

    public void login_with_empty_email(String password) {
        wait_title_to_contain_specific_text(driver, loginPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Welcome, Please Sign In!"));
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        wait_for_element_with_locator_to_be_clickable(driver, By.className("login-button"));
        loginButton = driver.findElement(By.className("login-button"));
        click_on_element(loginButton);
        wait_for_element_with_locator_to_be_visible(driver, By.id("Email-error"));
        loginMsg = driver.findElement(By.id("Email-error"));
        System.out.println(loginMsg.getText());
    }

    public void login_with_empty_password(String email) {
        wait_title_to_contain_specific_text(driver, loginPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Welcome, Please Sign In!"));
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        wait_for_element_with_locator_to_be_clickable(driver, By.className("login-button"));
        loginButton = driver.findElement(By.className("login-button"));
        click_on_element(loginButton);
        wait_for_element_with_locator_to_be_visible(driver, By.xpath("//div[@class='message-error validation-summary-errors']"));
        loginMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        System.out.println(loginMsg.getText());

    }

    public void login_with_empty_password_and_email() {
        wait_title_to_contain_specific_text(driver, loginPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Welcome, Please Sign In!"));
        wait_for_element_with_locator_to_be_clickable(driver, By.className("login-button"));
        loginButton = driver.findElement(By.className("login-button"));
        click_on_element(loginButton);
        wait_for_element_with_locator_to_be_visible(driver, By.id("Email-error"));
        loginMsg = driver.findElement(By.id("Email-error"));
        System.out.println(loginMsg.getText());
    }
}

package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage extends UtilitiesMethods {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************************   Strings   ****************************************************/
    private String welcomePageTitle = "nopCommerce demo store";
    private String reigsterPageTitle = "nopCommerce demo store. Register";

    /****************************************************************************************************************/
    private WebDriverWait wait;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement confirmPasswordField;
    private WebElement registerButton;
    private WebElement loginLink;
    private WebElement registrationMsg;


    public WelcomePage register_with_valid_data(String firstName, String lastName, String email, String password) {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        firstNameField = driver.findElement(By.id("FirstName"));
        enter_text_to_input_field(firstNameField, firstName);
        lastNameField = driver.findElement(By.id("LastName"));
        enter_text_to_input_field(lastNameField, lastName);
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        enter_text_to_input_field(confirmPasswordField, password);
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);
        wait_for_element_with_locator_to_be_visible(driver, By.xpath
                ("//div[contains(text(),'Your registration completed')]"));
        registrationMsg = driver.findElement(By.xpath
                ("//div[contains(text(),'Your registration completed')]"));
        System.out.println(registrationMsg.getText());
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, welcomePageTitle);
        return new WelcomePage(driver);
    }

    public void register_with_existed_email(String firstName, String lastName, String email, String password) {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        firstNameField = driver.findElement(By.id("FirstName"));
        enter_text_to_input_field(firstNameField, firstName);
        lastNameField = driver.findElement(By.id("LastName"));
        enter_text_to_input_field(lastNameField, lastName);
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        enter_text_to_input_field(confirmPasswordField, password);
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);
        wait_for_element_with_locator_to_be_visible(driver, By.xpath
                ("//li[contains(text(),'The specified email already exists')]"));
        registrationMsg = driver.findElement(By.xpath
                ("//li[contains(text(),'The specified email already exists')]"));
        System.out.println(registrationMsg.getText());
        driver.navigate().back();
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
    }

    public void register_without_entering_first_name(String lastName, String email, String password) {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        lastNameField = driver.findElement(By.id("LastName"));
        enter_text_to_input_field(lastNameField, lastName);
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        enter_text_to_input_field(confirmPasswordField, password);
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);
        wait_for_element_with_locator_to_be_visible(driver, By.id("FirstName-error"));
        registrationMsg = driver.findElement(By.id("FirstName-error"));
        System.out.println(registrationMsg.getText());
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
    }

    public void register_without_entering_last_name(String firstName, String email, String password) {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        firstNameField = driver.findElement(By.id("FirstName"));
        enter_text_to_input_field(firstNameField, firstName);
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        enter_text_to_input_field(confirmPasswordField, password);
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);
        wait_for_element_with_locator_to_be_visible(driver, By.id("LastName-error"));
        registrationMsg = driver.findElement(By.id("LastName-error"));
        System.out.println(registrationMsg.getText());
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
    }

    public void register_without_entering_email(String firstName, String lastName, String password) {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        firstNameField = driver.findElement(By.id("FirstName"));
        enter_text_to_input_field(firstNameField, firstName);
        lastNameField = driver.findElement(By.id("LastName"));
        enter_text_to_input_field(lastNameField, lastName);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        enter_text_to_input_field(confirmPasswordField, password);
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);
        wait_for_element_with_locator_to_be_visible(driver, By.id("Email-error"));
        registrationMsg = driver.findElement(By.id("Email-error"));
        System.out.println(registrationMsg.getText());
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
    }

    public void register_without_entering_password(String firstName, String lastName, String email, String password) {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        firstNameField = driver.findElement(By.id("FirstName"));
        enter_text_to_input_field(firstNameField, firstName);
        lastNameField = driver.findElement(By.id("LastName"));
        enter_text_to_input_field(lastNameField, lastName);
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        enter_text_to_input_field(confirmPasswordField, password);
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);
        wait_for_element_with_locator_to_be_visible(driver, By.id("ConfirmPassword-error"));
        registrationMsg = driver.findElement(By.id("ConfirmPassword-error"));
        System.out.println(registrationMsg.getText());
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
    }

    public void register_without_entering_confirm_password(String firstName, String lastName, String email, String password) {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        firstNameField = driver.findElement(By.id("FirstName"));
        enter_text_to_input_field(firstNameField, firstName);
        lastNameField = driver.findElement(By.id("LastName"));
        enter_text_to_input_field(lastNameField, lastName);
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);

        wait_for_element_with_locator_to_be_visible(driver, By.id("ConfirmPassword-error"));
        registrationMsg = driver.findElement(By.id("ConfirmPassword-error"));
        System.out.println(registrationMsg.getText());
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
    }

    public void register_without_entering_all_mandatory_fields() {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);
        registrationMsg = driver.findElement(By.id("FirstName-error"));
        System.out.println(registrationMsg.getText());
        registrationMsg = driver.findElement(By.id("LastName-error"));
        System.out.println(registrationMsg.getText());
        registrationMsg = driver.findElement(By.id("Email-error"));
        System.out.println(registrationMsg.getText());
        registrationMsg = driver.findElement(By.id("Password-error"));
        System.out.println(registrationMsg.getText());
        registrationMsg = driver.findElement(By.id("ConfirmPassword-error"));
        System.out.println(registrationMsg.getText());
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
    }

    public void register_with_not_matching_passwords(String firstName, String lastName, String email, String password, String differentPassword) {
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        firstNameField = driver.findElement(By.id("FirstName"));
        enter_text_to_input_field(firstNameField, firstName);
        lastNameField = driver.findElement(By.id("LastName"));
        enter_text_to_input_field(lastNameField, lastName);
        emailField = driver.findElement(By.id("Email"));
        enter_text_to_input_field(emailField, email);
        passwordField = driver.findElement(By.id("Password"));
        enter_text_to_input_field(passwordField, password);
        confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        enter_text_to_input_field(confirmPasswordField, differentPassword);
        registerButton = driver.findElement(By.id("register-button"));
        click_on_element(registerButton);
        wait_for_element_with_locator_to_be_visible(driver, By.id("ConfirmPassword-error"));
        registrationMsg = driver.findElement(By.id("ConfirmPassword-error"));
        System.out.println(registrationMsg.getText());
        driver.navigate().refresh();
        wait_title_to_contain_specific_text(driver, reigsterPageTitle);
    }

    public LoginPage open_login_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
        loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        return new LoginPage(driver);
    }
}

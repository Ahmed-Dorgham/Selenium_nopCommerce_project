package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriverWait wait;

    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement confirmPasswordField;
    private WebElement registerButton;
    private WebElement loginLink;



    public void register_with_valid_data(String firstName, String lastName, String email, String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store. Register"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Register"));
        System.out.println("now i am in register page ");
        firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys(firstName);
        lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys(lastName);
        emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys(email);
        passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys(password);
        confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordField.sendKeys(password);
        registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
    }

    public LoginPage open_login_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
        loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        return new LoginPage(driver);
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver ;
    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
    }
    private WebDriverWait wait ;

    private WebElement emailField ;
    private WebElement passwordField;
    private WebElement loginButton;
    public HomePage login_with_valid_data(String email, String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store. Login"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Welcome, Please Sign In!"));
        System.out.println("now i am in login page ");
        emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys(email);
        passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("login-button")));
        loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        System.out.println("now i am in homepage ");
        return new HomePage(driver);
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WelcomePage {

    private WebDriver driver;
    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriverWait wait;

    private WebElement registerLink;
    public void open_welcome_page() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    public RegisterPage open_register_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='topic-block-title']//h2"))
                .getText().contains("Welcome to our store"));
        System.out.println("now i am in welcome page ");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));


        registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        return new RegisterPage(driver);
    }
}

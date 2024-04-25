package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;

import java.time.Duration;

public class WelcomePage extends UtilitiesMethods {

    private WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**********************************************   Strings  **********************************************************/

    private String welcomePageTitle = "nopCommerce demo store";
    private String reigsterPageTitle = "nopCommerce demo store. Register";


    /******************************************************************************************************************/
    public WebDriverWait wait;

    private WebElement registerLink;
    private WebElement loginLink;

    public void open_welcome_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            driver.navigate().to("https://demo.nopcommerce.com/");
            wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));
        } catch (Exception e) {
            System.out.println("welcome page not opened successfully and this is last try to open it ");
        }

    }

    public RegisterPage open_register_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='topic-block-title']//h2"))
                .getText().contains("Welcome to our store"));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
        registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        return new RegisterPage(driver);
    }

    public LoginPage open_login_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_title_to_contain_specific_text(driver, welcomePageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='topic-block-title']//h2"))
                .getText().contains("Welcome to our store"));
        wait_for_element_with_locator_to_be_clickable(driver, By.linkText("Log in"));
        loginLink = driver.findElement(By.linkText("Log in"));
        click_on_element(loginLink);
        return new LoginPage(driver);
    }

}

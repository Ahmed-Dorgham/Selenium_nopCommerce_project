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

    private String demoStorePageTitle = "nopCommerce demo store";
    private String nopcommerceWebsiteLink = "https://demo.nopcommerce.com/";
    private String reigsterPageTitle = "nopCommerce demo store. Register";


    /*****************************************************  WebElements  *****************************************************/
    public WebDriverWait wait;

    private WebElement registerLink;
    private WebElement loginLink;

    /********************************************************************************************************************/
    public void open_welcome_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            driver.navigate().to(nopcommerceWebsiteLink);
            wait_title_to_contain_specific_text(this.driver, demoStorePageTitle);
        } catch (Exception e) {
            System.out.println("welcome page not opened successfully and this is last try to open it ");
        }
    }

    public RegisterPage open_register_page() {

        wait_title_to_contain_specific_text(this.driver, demoStorePageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='topic-block-title']//h2"))
                .getText().contains("Welcome to our store"));
        wait_for_element_with_locator_to_be_clickable(this.driver, By.linkText("Register"));
        registerLink = driver.findElement(By.linkText("Register"));
        click_on_element(registerLink);
        return new RegisterPage(driver);
    }

    public LoginPage open_login_page() {
      /*  wait_title_to_contain_specific_text(driver, demoStorePageTitle);
        wait_for_element_with_locator_to_be_present(this.driver,By.xpath("//div[@class='topic-block-title']//h2"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='topic-block-title']//h2"))
                .getText().contains("Welcome to our store"));*/
        wait_for_element_with_locator_to_be_clickable(driver, By.linkText("Log in"));
        loginLink = driver.findElement(By.linkText("Log in"));
        click_on_element(loginLink);
        return new LoginPage(driver);
    }
}

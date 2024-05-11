package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends UtilitiesMethods {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /*********************************************   Strings *************************************************************/
    String demoStorePageTitle = "nopCommerce demo store";

    /*********************************************   WebElements *************************************************************/

    private WebElement computersLink;
    private WebElement desktopsLink;
    private WebElement myAccountLink;
    private WebElement logoutLink;


    /********************************************************************************************************************/
    public DesktopsPage open_desktops_page() {
        Actions actions = new Actions(driver);
        wait_title_to_contain_specific_text(this.driver, demoStorePageTitle);
        wait_for_element_with_locator_to_be_visible(this.driver, By.
                xpath("(//div//ul//li//a[contains(text(),'Computers ')])[1]"));
        computersLink = driver.findElement(By.
                xpath("(//div//ul//li//a[contains(text(),'Computers ')])[1]"));
        actions.moveToElement(computersLink).build().perform();
        wait_for_element_with_locator_to_be_visible(this.driver, By.
                xpath("(//div//ul//li//a[contains(text(),'Desktops ')])[1]"));
        desktopsLink = driver.findElement(By.
                xpath("(//div//ul//li//a[contains(text(),'Desktops ')])[1]"));
        actions.moveToElement(desktopsLink).click().build().perform();
        return new DesktopsPage(driver);
    }

    public MyAccountPage open_my_account_page() {
        wait_title_to_contain_specific_text(this.driver, demoStorePageTitle);
        wait_for_element_with_locator_to_be_visible(this.driver, By.linkText("My account"));
        myAccountLink = driver.findElement(By.linkText("My account"));
     click_on_element(myAccountLink);
        return new MyAccountPage(driver);
    }
    public WebElement get_logout_element_in_homepage() {
        wait_for_element_with_locator_to_be_visible(this.driver, By
                .linkText("Log out"));
        logoutLink = driver.findElement(By.linkText("Log out"));
        return logoutLink;
    }
}

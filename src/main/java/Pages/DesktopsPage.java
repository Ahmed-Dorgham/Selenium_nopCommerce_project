package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DesktopsPage extends UtilitiesMethods {
    private WebDriver driver;
    JavascriptExecutor js;

    public DesktopsPage(WebDriver driver) {
        this.driver = driver;
    }

    /************************************************* Strings ************************************************/
    private String deskTopsPageTitle = "nopCommerce demo store. Desktops";

    /************************************************* WebElements ************************************************/

    private WebElement lenovoDesktop;
    private WebElement addToWishlistBtn;
    private WebElement wishlistPageLink;

    /********************************************************************************************************************/
    public LenovoPage open_lenovo_desktop_page() {
        wait_title_to_contain_specific_text(this.driver, deskTopsPageTitle);
        wait_for_element_with_locator_to_be_visible(this.driver, By.linkText("Lenovo IdeaCentre 600 All-in-One PC"));
        lenovoDesktop = driver.findElement(By.linkText("Lenovo IdeaCentre 600 All-in-One PC"));
        click_on_element(lenovoDesktop);
        return new LenovoPage(driver);
    }

    public void add_lenovo_to_my_wishlist() {
        js = (JavascriptExecutor) driver;
        wait_title_to_contain_specific_text(this.driver, "nopCommerce demo store. Desktops");
        js.executeScript("scrollBy(0,500)");
        wait_for_element_with_locator_to_be_visible(this.driver, By.linkText("Lenovo IdeaCentre 600 All-in-One PC"));
        addToWishlistBtn = driver.findElement(By.xpath("(//button[@title='Add to wishlist'])[3]"));
        click_on_element(addToWishlistBtn);
    }

    public WishListPage open_wishlist_page() {
        wait_for_element_with_locator_to_be_visible(this.driver, By.linkText("wishlist"));
        wishlistPageLink = driver.findElement(By.linkText("wishlist"));
        click_on_element(wishlistPageLink);
        return new WishListPage(driver);
    }
}

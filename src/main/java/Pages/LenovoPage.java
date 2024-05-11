package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LenovoPage extends UtilitiesMethods {
    private WebDriver driver;

    public LenovoPage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************        Strings  ***************************************************/
    String lenovoTitlePage = "nopCommerce demo store. Lenovo ";
    String itemPriceValue;

    /********************************************* WebElements  ***************************************************/
    private WebElement addToCartButton;
    private WebElement shoppingCartLink;
    private WebElement priceValue;

    /********************************************************************************************************************/
    public ShoppingCartPage add_lenovo_desktop_to_cart() {
        wait_title_to_contain_specific_text(this.driver, lenovoTitlePage);
        //System.out.println("now i am in lenovo desktop page ");
        wait_for_element_with_locator_to_be_visible(this.driver, By.id("add-to-cart-button-3"));
        priceValue = driver.findElement(By
                .xpath("//div[@class='product-price']//span[@id='price-value-3']"));
        itemPriceValue = priceValue.getText();
        System.out.println("price value for this desktop is " + itemPriceValue);
        addToCartButton = driver.findElement(By.id("add-to-cart-button-3"));
        click_on_element(addToCartButton);
        wait_for_element_with_locator_to_be_visible(this.driver, By.linkText("shopping cart"));
        shoppingCartLink = driver.findElement(By.linkText("shopping cart"));
        click_on_element(shoppingCartLink);
        // System.out.println("now i am in Shopping cart page ");
        return new ShoppingCartPage(driver);
    }
}

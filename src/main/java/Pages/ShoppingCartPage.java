package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ShoppingCartPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    /*************************************** ........Strings...........  *********************************************/
    String shoppingCartPageTitle = "nopCommerce demo store. Shopping Cart";

    /*************************************** ........WebElements...........  *********************************************/
    private WebElement termsOfService;
    private WebElement checkoutButton;

    /********************************************************************************************************************/
    public CheckoutPage open_checkout_page() {
        js = (JavascriptExecutor) driver;
        wait_title_to_contain_specific_text(this.driver, shoppingCartPageTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Shopping cart"));
        js.executeScript("scrollBy(0,2000)");
        termsOfService = driver.findElement(By.id("termsofservice"));
        click_on_element(termsOfService);
        Assert.assertTrue(termsOfService.isSelected());
        checkoutButton = driver.findElement(By.id("checkout"));
        click_on_element(checkoutButton);
        return new CheckoutPage(driver);
    }

    public String get_total_price_value_in_shopping_cart() {
        return driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
    }
}
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LenovoPage {
    /*************************************** ........strings...........  *********************************************/
    String itemPriceValue;

    /*************************************** ........strings...........  *********************************************/
    private WebDriver driver;
    private WebElement addToCartButton;
    private WebElement shoppingCartLink;
    private WebElement priceValue;

    public LenovoPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShoppingCartPage add_lenovo_desktop_to_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store. Lenovo "));
        System.out.println("now i am in lenovo desktop page ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button-3")));
        priceValue = driver.findElement(By
                .xpath("//div[@class='product-price']//span[@id='price-value-3']"));
        itemPriceValue = priceValue.getText();
        System.out.println("price value for this desktop is " + itemPriceValue);
        addToCartButton = driver.findElement(By.id("add-to-cart-button-3"));
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("shopping cart")));
        shoppingCartLink = driver.findElement(By.linkText("shopping cart"));
        shoppingCartLink.click();
        System.out.println("now i am in Shopping cart page ");
        return new ShoppingCartPage(driver);
    }
}

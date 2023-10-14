package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ShoppingCartPage {
    /*************************************** ........strings...........  *********************************************/
    String totalValue ;

    /*************************************** ........strings...........  *********************************************/
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement termsOfService;
    private WebElement checkoutButton;
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage open_checkout_button() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store. Shopping Cart"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1"))
                .getText().contains("Shopping cart"));
        js.executeScript("scrollBy(0,2000)");
        termsOfService = driver.findElement(By.id("termsofservice"));
        termsOfService.click();
        Assert.assertTrue(termsOfService.isSelected());
        checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        return new CheckoutPage(driver);
    }
    public String get_total_price_value_in_shopping_cart()
    {
        return  driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
    }
}

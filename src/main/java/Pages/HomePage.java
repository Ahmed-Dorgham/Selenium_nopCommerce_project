package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    public HomePage (WebDriver driver)
    {
        this.driver = driver;
    }
private WebElement computersLink;
private WebElement desktopsLink;
    public DesktopsPage open_desktops_page ()
    {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("(//div//ul//li//a[contains(text(),'Computers ')])[1]")));
        computersLink = driver.findElement(By.
                xpath("(//div//ul//li//a[contains(text(),'Computers ')])[1]"));
        actions.moveToElement(computersLink).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("(//div//ul//li//a[contains(text(),'Desktops ')])[1]")));
        desktopsLink = driver.findElement(By.
                xpath("(//div//ul//li//a[contains(text(),'Desktops ')])[1]"));
        actions.moveToElement(desktopsLink).click().build().perform();
        System.out.println("now i am in desktops page ");
        return new DesktopsPage(driver);

    }
}

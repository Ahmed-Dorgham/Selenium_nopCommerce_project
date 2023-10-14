package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DesktopsPage {
    private WebDriver driver ;
    public DesktopsPage (WebDriver driver)
    {
        this.driver = driver;
    }
  private WebElement lenovoDesktop ;
    public LenovoPage open_lenovo_desktop_page()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store. Desktops"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .linkText("Lenovo IdeaCentre 600 All-in-One PC")));
        lenovoDesktop = driver.findElement(By.linkText("Lenovo IdeaCentre 600 All-in-One PC"));
        lenovoDesktop.click();
        return new LenovoPage(driver);
    }
}

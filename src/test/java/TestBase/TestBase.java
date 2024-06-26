package TestBase;

import UtilitiesMethods.UtilitiesMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase extends UtilitiesMethods {

    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void open_browser() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tear_down() {
        driver.quit();
    }


}

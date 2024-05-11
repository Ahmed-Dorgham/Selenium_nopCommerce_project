package UtilitiesMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class UtilitiesMethods {

    private WebDriverWait wait;
    long seconds = 30;

    public void click_on_element(WebElement element) {
        element.click();
    }

    public void enter_text_to_input_field(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clear_data_from_input_field(WebElement element) {
        element.clear();
    }

    public void wait_for_element_with_locator_to_be_visible(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void wait_for_element_with_locator_to_be_present(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void wait_for_element_to_be_clickable(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void wait_for_element_with_locator_to_be_clickable(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void wait_for_text_to_be_present_in_element(WebDriver driver, WebElement element, String text) {

        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void wait_title_to_contain_specific_text(WebDriver driver, String title) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.titleContains(title));
    }
    public static String read_data_from_properties_file(String filePath, String key) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        prop.getProperty(key);
        return prop.getProperty(key);
    }
}

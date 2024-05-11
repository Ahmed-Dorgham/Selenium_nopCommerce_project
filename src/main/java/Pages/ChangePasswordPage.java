package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************************   Strings   ****************************************************/
    private String wishListPageTitle = "nopCommerce demo store. Wishlist";


    /******************************************************** WebElements ******************************************/
    private WebElement oldPasswordField;
    private WebElement newPasswordField;
    private WebElement confirmNewPasswordField;
    private WebElement changePasswordBtn;
    private WebElement changePasswordMsg;
    private WebElement closeIcon;
    private WebElement logoutLink;
    private WebElement loginLink;

    /**************************************************************************************************************/
    public void change_password(String oldPassword, String newPassword) {

        wait_for_element_with_locator_to_be_visible(this.driver, By.
                xpath("//h1[contains(text(),'My account - Change password')]"));
        oldPasswordField = driver.findElement(By.id("OldPassword"));
        enter_text_to_input_field(oldPasswordField, oldPassword);
        newPasswordField = driver.findElement(By.id("NewPassword"));
        enter_text_to_input_field(newPasswordField, newPassword);
        confirmNewPasswordField = driver.findElement(By.id("ConfirmNewPassword"));
        enter_text_to_input_field(confirmNewPasswordField, newPassword);
        changePasswordBtn = driver.findElement(By.xpath("//button[contains(text(),'Change password')]"));
        click_on_element(changePasswordBtn);
    }

    public WebElement get_msg_after_changing_password_successfully() {
        wait_for_element_with_locator_to_be_visible(this.driver, By
                .xpath("//p[contains(text(),'Password was changed')]"));
        changePasswordMsg = driver.findElement(By.xpath("//p[contains(text(),'Password was changed')]"));
        System.out.println(changePasswordMsg.getText());
        return changePasswordMsg;
    }

    public WelcomePage click_on_logout_link() {
        js = (JavascriptExecutor) driver;
        wait_for_element_with_locator_to_be_present(this.driver, By.xpath("//span[@title='Close']"));
        closeIcon = driver.findElement(By.xpath("//span[@title='Close']"));
        click_on_element(closeIcon);
        wait_for_element_with_locator_to_be_clickable(this.driver, By.linkText("Log out"));
        logoutLink = driver.findElement(By.linkText("Log out"));
        js.executeScript("arguments[0].click();", logoutLink);
        //  click_on_element(logoutLink);
        return new WelcomePage(driver);
    }
}

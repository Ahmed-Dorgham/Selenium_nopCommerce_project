package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends UtilitiesMethods {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************************   Strings   ****************************************************/


    /******************************************************** WebElements ******************************************/
    private WebElement changePasswordLink;

    /**************************************************************************************************************/
    public ChangePasswordPage open_change_password_page() {
        wait_for_element_with_locator_to_be_visible(this.driver, By.linkText("Change password"));
        changePasswordLink = driver.findElement(By.linkText("Change password"));
        click_on_element(changePasswordLink);
        return new ChangePasswordPage(driver);
    }
}

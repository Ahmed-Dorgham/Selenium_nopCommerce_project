package Pages;

import UtilitiesMethods.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends UtilitiesMethods {
    private WebDriver driver;
    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************************   Strings   ****************************************************/
    private String wishListPageTitle = "nopCommerce demo store. Wishlist";

    /******************************************************** WebElements ******************************************/
    private WebElement lenovoDesktop;

    /**************************************************************************************************************/
    public WebElement get_lenovoDesktop_name_in_wishlist_page()
    {
        wait_title_to_contain_specific_text(this.driver,wishListPageTitle);
        wait_for_element_with_locator_to_be_visible(this.driver,By.linkText("Lenovo IdeaCentre 600 All-in-One PC"));
        lenovoDesktop = driver.findElement(By.linkText("Lenovo IdeaCentre 600 All-in-One PC"));
        System.out.println(lenovoDesktop.getText());
        return lenovoDesktop;
    }
}

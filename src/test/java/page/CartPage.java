package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage extends PageObject {
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElementFacade removeCartButton;

    @FindAll(@FindBy(css = ".cart_button"))
    List<WebElementFacade> removeAllCartButton;

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    @FindAll(@FindBy(css = "[data-test='inventory-item']"))
    List<WebElementFacade> cartItems;

    public void clickRemoveCartButton() {
        removeCartButton.click();
    }

    public void clickRemoveAllCartButton() {
        removeAllCartButton.forEach(WebElementFacade::click);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void verifyCartIsEmpty() {
        assertThat(cartItems, empty());
    }
}

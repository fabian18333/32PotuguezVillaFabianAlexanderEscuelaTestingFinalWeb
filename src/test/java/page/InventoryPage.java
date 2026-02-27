package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends PageObject {
    @FindAll(@FindBy(css = ".btn_inventory"))
    List<WebElementFacade> addAllCartButton;

    @FindBy(css = "[data-test='shopping-cart-link']")
    WebElementFacade shoppingCartButton;



    public void clickAddProductForName(String productName) {
        find(By.xpath("//a/div[text()='" + productName + "']/../../../div/button")).click();
    }

    public void clickAddAllCartButton() {
        addAllCartButton.forEach(WebElementFacade::click);
    }

    public void clickShoppingCartButton() {
        shoppingCartButton.click();
    }
}
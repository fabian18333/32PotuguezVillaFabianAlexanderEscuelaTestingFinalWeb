package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/checkout-step-two.html")
public class CheckoutOverviewPage extends PageObject {

    @FindBy(id = "finish")
    WebElementFacade finishButton;

    @FindBy(id = "cancel")
    WebElementFacade cancelButton;

    public void clickFinishButton() {
        finishButton.click();
    }

    public void clickCancelButton() {cancelButton.click();}
}

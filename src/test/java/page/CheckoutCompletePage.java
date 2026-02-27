package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/checkout-complete.html")
public class CheckoutCompletePage extends PageObject {
    @FindBy(css = "[data-test='pony-express']")
    WebElementFacade checkIcon;

    @FindBy(css = "[data-test='complete-header']")
    WebElementFacade checkMenssage;

    public void verifyCheckIcon() {
        checkIcon.shouldBeVisible();
    }

    public void verifyCheckMessage(String mensajeEsperado) {
        checkMenssage.shouldBeVisible();
        checkMenssage.shouldContainText(mensajeEsperado);
    }
}

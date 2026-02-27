package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/checkout-step-one.html")
public class CheckoutInformationPage extends PageObject {
    @FindBy(id = "first-name")
    WebElementFacade firstName;

    @FindBy(id = "last-name")
    WebElementFacade lastName;

    @FindBy(id = "postal-code")
    WebElementFacade postalCode;

    @FindBy(id = "continue")
    WebElementFacade continueButton;

    @FindBy(id = "cancel")
    WebElementFacade cancelButton;

    public void enterFirstName(String firstName) {
        this.firstName.type(firstName);
    }

    public void enterLastName(String lastName) {
        this.lastName.type(lastName);
    }

    public void enterPostalCode(String postalCode) {
        this.postalCode.type(postalCode);
    }

    public void clickContinueButton() { continueButton.click(); }

    public void clickCancelButton() {
        cancelButton.click();
    }
}

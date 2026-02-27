package steps;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Step;
import page.*;

import java.util.ResourceBundle;

public class ShoppingSteps {
    @Managed
    CartPage cartPage;
    @Managed
    CheckoutCompletePage checkoutCompletePage;
    @Managed
    CheckoutInformationPage checkoutInformationPage;
    @Managed
    CheckoutOverviewPage checkoutOverviewPage;
    @Managed
    InventoryPage inventoryPage;

    ResourceBundle bundle = ResourceBundle.getBundle("testdata");

    @Step
    public void clickAddProductForName(String productName) {
        inventoryPage.clickAddProductForName(productName);
    }

    @Step
    public void clickAddAllCartButton() {
        inventoryPage.clickAddAllCartButton();
    }

    @Step
    public void clickShoppingCartButton() {
        inventoryPage.clickShoppingCartButton();
    }

    @Step
    public void clickRemoveCartButton() {
        cartPage.clickRemoveCartButton();
    }

    @Step
    public void clickRemoveAllCartButton() {
        cartPage.clickRemoveAllCartButton();
    }

    @Step
    public void clickCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @Step
    public void verifyCartIsEmpty() { cartPage.verifyCartIsEmpty(); }

    @Step
    public void ingresarMiInformacionComprar() {
        checkoutInformationPage.enterFirstName(bundle.getString("checkout.firstname"));
        checkoutInformationPage.enterLastName(bundle.getString("checkout.lastname"));
        checkoutInformationPage.enterPostalCode(bundle.getString("checkout.zipcode"));
    }

    @Step
    public void clickContinueButton() {
        checkoutInformationPage.clickContinueButton();
    }

    @Step
    public void clickCancelButtonInformationPage() {
        checkoutInformationPage.clickCancelButton();
    }

    @Step
    public void clickFinishButton() {
        checkoutOverviewPage.clickFinishButton();
    }

    @Step
    public void clickCancelButtonOverviewPage() {
        checkoutOverviewPage.clickCancelButton();
    }

    @Step
    public void verifyCheckIcon() {
        checkoutCompletePage.verifyCheckIcon();
    }

    @Step
    public void verifyCheckMessage(String mensajeEsperado) {
        checkoutCompletePage.verifyCheckMessage(mensajeEsperado);
    }
}

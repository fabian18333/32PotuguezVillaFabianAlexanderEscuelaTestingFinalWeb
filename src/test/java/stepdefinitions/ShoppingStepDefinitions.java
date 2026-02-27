package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.ShoppingSteps;

public class ShoppingStepDefinitions {
    @Steps
    ShoppingSteps shoppingSteps;

    @When("agrego el producto {string} al carrito")
    public void agregarProductoAlCarrito(String productName) {
        shoppingSteps.clickAddProductForName(productName);
    }

    @And("navego al carrito")
    public void navegarAlCarrito() {
        shoppingSteps.clickShoppingCartButton();
    }

    @And("realizo clic en el boton Checkout")
    public void clickCheckoutButton() {
        shoppingSteps.clickCheckoutButton();
    }

    @And("ingreso los datos de envio del comprador")
    public void completarInformacionComprador() {
        shoppingSteps.ingresarMiInformacionComprar();
    }

    @And("realizo clic en el boton Continue")
    public void clickContinueButton() {
        shoppingSteps.clickContinueButton();
    }

    @And("realizo clic en el boton Finish")
    public void clickFinishButton() {
        shoppingSteps.clickFinishButton();
    }

    @Then("debo ver el mensaje {string}")
    public void deboVerElMensaje(String mensajeEsperado) {
        shoppingSteps.verifyCheckMessage(mensajeEsperado);
    }

    @When("agrego todos los productos al carrito")
    public void agregarTodosProductosAlCarrito() {
        shoppingSteps.clickAddAllCartButton();
    }

    @And("realizo clic en el boton Remove")
    public void clickRemoveButton() {
        shoppingSteps.clickRemoveCartButton();
    }

    @Then("debo ver vacio el carrito")
    public void verVacioElCarrito() {
        shoppingSteps.verifyCartIsEmpty();
    }

    @And("realizo clic en los botones remove")
    public void clickAllRemoveButtons() {
        shoppingSteps.clickRemoveAllCartButton();
    }

    @And("realizo clic en el boton Cancel en pagina Information Page")
    public void clickCancelButtonInformationPage() {
        shoppingSteps.clickCancelButtonInformationPage();
    }

    @And("realizo clic en el boton Cancel en la pagina OverviewPage")
    public void clickCancelButtonOverviewPage() {
        shoppingSteps.clickCancelButtonOverviewPage();
    }

    @And("debo ver la imagen de Check")
    public void verImagenCheck() {
        shoppingSteps.verifyCheckIcon();
    }
}

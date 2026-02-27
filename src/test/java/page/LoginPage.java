package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade username;

    @FindBy(id = "password")
    WebElementFacade password;

    @FindBy(id = "login-button")
    WebElementFacade loginButton;

    @FindBy(className = "app_logo")
    WebElementFacade appLogo;

    @FindBy(css = "[data-test='error']")
    WebElementFacade errorMessage;

    public void enterUsername(String user) {
        username.type(user);
    }
    public void enterPassword(String pass) {
        password.type(pass);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void verifyLogo() {
        appLogo.shouldBeVisible();}
    public String obtenerUrlActual() { return getDriver().getCurrentUrl(); }

    public void verifyErrorMessage(String mensajeEsperado) {
        errorMessage.shouldBeVisible();
        errorMessage.shouldContainText(mensajeEsperado);
    }
}
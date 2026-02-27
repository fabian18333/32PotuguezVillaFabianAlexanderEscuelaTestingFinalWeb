package steps;

import net.serenitybdd.annotations.Step;
import page.LoginPage;
import page.MenuPage;

import java.util.ResourceBundle;

public class LoginSteps {
    LoginPage loginPage;
    MenuPage menuPage;
    ResourceBundle bundle = ResourceBundle.getBundle("testdata");

    @Step
    public void abrirSauce() { loginPage.open(); }

    @Step
    public void ingresarCredencialesUsuarioEstandar() {
        loginPage.enterUsername(bundle.getString("sauce.user.standard"));
        loginPage.enterPassword(bundle.getString("sauce.password"));
    }

    @Step
    public void ingresarCredencialesUsuarioBloqueado() {
        loginPage.enterUsername(bundle.getString("sauce.user.locked"));
        loginPage.enterPassword(bundle.getString("sauce.password"));
    }

    @Step
    public void ingresarCredencialesUsuarioConProblemas() {
        loginPage.enterUsername(bundle.getString("sauce.user.problem"));
        loginPage.enterPassword(bundle.getString("sauce.password"));
    }

    @Step
    public void ingresarCredencialesUsuarioRendimiento() {
        loginPage.enterUsername(bundle.getString("sauce.user.performance"));
        loginPage.enterPassword(bundle.getString("sauce.password"));
    }

    @Step
    public void ingresarCredencialesUsuarioConError() {
        loginPage.enterUsername(bundle.getString("sauce.user.error"));
        loginPage.enterPassword(bundle.getString("sauce.password"));
    }

    @Step
    public void ingresarCredencialesUsuarioConFalloVisual() {
        loginPage.enterUsername(bundle.getString("sauce.user.visual"));
        loginPage.enterPassword(bundle.getString("sauce.password"));
    }

    @Step
    public void escribirUsuario(String username) { loginPage.enterUsername(username); }

    @Step
    public void enterPassword(String pass) { loginPage.enterPassword(pass); }

    @Step
    public void clickLoginButton() { loginPage.clickLoginButton(); }

    @Step
    public void verifyLogo() { loginPage.verifyLogo(); }

    @Step
    public void verifyErrorMessage(String mensajeEsperado) { loginPage.verifyErrorMessage(mensajeEsperado); }

    @Step
    public String obtenerUrlPagina() { return loginPage.obtenerUrlActual(); }

    @Step
    public void cerrarSesion(){
        menuPage.clickMenuButton();
        menuPage.clickLogoutButton();
    }
}

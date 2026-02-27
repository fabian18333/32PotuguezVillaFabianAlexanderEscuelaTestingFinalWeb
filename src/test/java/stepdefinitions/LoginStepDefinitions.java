package stepdefinitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Steps;
import steps.LoginSteps;

public class LoginStepDefinitions {
    @Steps
    LoginSteps loginSteps;

    @Dado("que el usuario navega a la pagina de SauceDemo")
    public void abrirPagina() {
        loginSteps.abrirSauce();
    }

    @When("ingreso las credenciales del usuario estandar")
    public void ingresarCredencialesEstandar() {
        loginSteps.ingresarCredencialesUsuarioEstandar();
    }

    @When("ingreso las credenciales del usuario bloqueado")
    public void ingresarCredencialesUsuarioBloqueado() {
        loginSteps.ingresarCredencialesUsuarioBloqueado();
    }

    @When("ingreso las credenciales del usuario con problemas")
    public void ingresarCredencialesUsuarioConProblemas() {
        loginSteps.ingresarCredencialesUsuarioConProblemas();
    }

    @When("ingreso las credenciales del usuario de rendimiento")
    public void ingresarCredencialesUsuarioRendimiento() {
        loginSteps.ingresarCredencialesUsuarioRendimiento();
    }

    @When("ingreso las credenciales del usuario con error")
    public void ingresarCredencialesUsuarioConError() {
        loginSteps.ingresarCredencialesUsuarioConError();
    }

    @When("ingreso las credenciales del usuario con fallo visual")
    public void ingresarCredencialesUsuarioConFalloVisual() {loginSteps.ingresarCredencialesUsuarioConFalloVisual();}

    @When("escribo el usuario {string}")
    public void escribirUsuario(String username) {loginSteps.escribirUsuario(username);}

    @And("escribo contrasena {string}")
    public void escribirContrasena(String password) {
        loginSteps.enterPassword(password);
    }

    @And("realizo clic en el boton login")
    public void realizarClicLogin() {
        loginSteps.clickLoginButton();
    }

    @Then("debo ver el logo de la empresa")
    public void verLogo() {
        loginSteps.verifyLogo();
    }

    @And("la URL debe contener {string}")
    public void validarUrl(String textoUrl) {
        assertThat(loginSteps.obtenerUrlPagina(), containsString(textoUrl));
    }

    @Then("debo ver el mensaje de error {string}")
    public void verMensajeError(String mensajeEsperado) {
        loginSteps.verifyErrorMessage(mensajeEsperado);
    }

    @And("cierro sesion de usuario estandar")
    public void cerrarSesion() {
        loginSteps.cerrarSesion();
    }
}
@Regression @Login
Feature: Autenticacion de usuarios en SauceDemo
  Background:
    Given que el usuario navega a la pagina de SauceDemo

  @T-L01 @Happy-Path @Smoke
  Scenario: Login exitoso con credenciales validas
    When ingreso las credenciales del usuario estandar
    And realizo clic en el boton login
    Then debo ver el logo de la empresa
    And la URL debe contener "inventory.html"

  @T-L02 @Happy-Path @Smoke
  Scenario: Cierre de sesion exitoso
    When ingreso las credenciales del usuario estandar
    And realizo clic en el boton login
    And cierro sesion de usuario estandar
    And la URL debe contener ""

  @T-L03 @Unhappy-Path
  Scenario: Login fallido con usuario bloqueado
    When ingreso las credenciales del usuario bloqueado
    And realizo clic en el boton login
    Then debo ver el mensaje de error "Epic sadface: Sorry, this user has been locked out."

  @T-L04 @Unhappy-Path
  Scenario: Login fallido con usuario con problemas
    When ingreso las credenciales del usuario con problemas
    And realizo clic en el boton login
    Then debo ver el logo de la empresa
    And la URL debe contener "inventory.html"

  @T-L05 @Unhappy-Path
  Scenario: Login con usuario de rendimiento degradado
    When ingreso las credenciales del usuario de rendimiento
    And realizo clic en el boton login
    Then debo ver el logo de la empresa
    And la URL debe contener "inventory.html"

  @T-L06 @Unhappy-Path
  Scenario: Login con usuario con error
    When ingreso las credenciales del usuario con error
    And realizo clic en el boton login
    Then debo ver el logo de la empresa
    And la URL debe contener "inventory.html"

  @T-L07 @Unhappy-Path
  Scenario: Login con usuario con fallo visual
    When ingreso las credenciales del usuario con fallo visual
    And realizo clic en el boton login
    Then debo ver el logo de la empresa
    And la URL debe contener "inventory.html"

  @T-L08 @Unhappy-Path
  Scenario Outline: Login fallido con <Descripcion>
    When escribo el usuario "<Username>"
    And escribo contrasena "<Password>"
    And realizo clic en el boton login
    Then debo ver el mensaje de error "<Message>"
    Examples:
      |Username| Password | Message                                                                   | Descripcion                  |
      | user   |          | Epic sadface: Password is required                                        | solo usuario                 |
      |        | password | Epic sadface: Username is required                                        | solo contrasena              |
      | user   | password | Epic sadface: Username and password do not match any user in this service | usuario y contaseña erroneos |
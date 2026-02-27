@Regression @Shopping
Feature: Compras en SauceDemo
  Background:
    Given que el usuario navega a la pagina de SauceDemo
    When ingreso las credenciales del usuario estandar
    And realizo clic en el boton login

  @T-S01 @Happy-Path @Smoke
  Scenario: Compra exitosa de un producto
    When agrego el producto "Sauce Labs Backpack" al carrito
    And navego al carrito
    And realizo clic en el boton Checkout
    And ingreso los datos de envio del comprador
    And realizo clic en el boton Continue
    And realizo clic en el boton Finish
    Then debo ver el mensaje "Thank you for your order!"
    And debo ver la imagen de Check
    And la URL debe contener "checkout-complete.html"

  @T-S02 @Happy-Path
  Scenario: Compra exitosa de un grupo de productos
    When agrego todos los productos al carrito
    And navego al carrito
    And realizo clic en el boton Checkout
    And ingreso los datos de envio del comprador
    And realizo clic en el boton Continue
    And realizo clic en el boton Finish
    Then debo ver el mensaje "Thank you for your order!"
    And debo ver la imagen de Check
    And la URL debe contener "checkout-complete.html"

  @T-S03 @Unhappy-Path
  Scenario: Checkout fallido con datos de envio vacios
    When agrego el producto "Sauce Labs Backpack" al carrito
    And navego al carrito
    And realizo clic en el boton Checkout
    And realizo clic en el boton Continue
    Then debo ver el mensaje de error "Error: First Name is required"

  @T-S04 @Happy-Path
  Scenario: Remover un producto del carrito exitosamente
    When agrego el producto "Sauce Labs Backpack" al carrito
    And navego al carrito
    And realizo clic en el boton Remove
    Then debo ver vacio el carrito

  @T-S05 @Happy-Path
  Scenario: Remover un grupo de productos del carrito exitosamente
    When agrego todos los productos al carrito
    And navego al carrito
    And realizo clic en los botones remove
    Then debo ver vacio el carrito

  @T-S06 @Happy-Path
  Scenario: Cancelar un pedido exitosamente en el Check Out Information
    When agrego el producto "Sauce Labs Backpack" al carrito
    And navego al carrito
    And realizo clic en el boton Checkout
    And realizo clic en el boton Cancel en pagina Information Page
    Then la URL debe contener "cart.html"

  @T-S07 @Happy-Path
  Scenario: Cancelar un pedido exitosamente en la Overview Page
    When agrego el producto "Sauce Labs Backpack" al carrito
    And navego al carrito
    And realizo clic en el boton Checkout
    And ingreso los datos de envio del comprador
    And realizo clic en el boton Continue
    And realizo clic en el boton Cancel en la pagina OverviewPage
    Then la URL debe contener "inventory.html"
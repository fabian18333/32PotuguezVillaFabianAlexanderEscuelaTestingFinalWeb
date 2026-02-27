# Automatización Web con Serenity BDD — SauceDemo

Proyecto de pruebas automatizadas **(17 en total)** desarrollado con el framework [Serenity BDD](https://serenity-bdd.github.io/), orientado a la validación funcional de la aplicación web [SauceDemo](https://www.saucedemo.com/). Las pruebas cubren las reglas de negocio de **Autenticación (Login)** y **Compra (Shopping)**, incluyendo escenarios de camino feliz (*Happy Path*) y caminos alternos (*Unhappy Path*).

---

## Tecnologías Utilizadas

| Tecnología         | Versión   | Propósito                              |
|:-------------------|:---------:|:---------------------------------------|
| Java               |    17     | Lenguaje de programación               |
| Apache Maven       |    3.x    | Gestión de dependencias y ejecución    |
| Serenity BDD       |  4.0.46   | Framework de automatización y reportes |
| Cucumber           |  4.0.46   | Especificación BDD en lenguaje Gherkin |
| JUnit              |  5.10.1   | Motor de ejecución de pruebas          |
| Selenium WebDriver |     -     | Automatización del navegador           |
| Google Chrome      |   145+    | Navegador de ejecución                 |

---

## Requisitos Previos

Antes de ejecutar las pruebas, asegúrese de contar con el siguiente software instalado y correctamente configurado:

- **Java 17** — El proyecto está configurado para esta versión del JDK.
- **Apache Maven** — Utilizado para la gestión de dependencias y ejecución de pruebas.
- **Google Chrome** — Navegador utilizado para la ejecución de las pruebas.

**Variables de entorno requeridas:**

| Variable    | Descripción                                     |
|:------------|:------------------------------------------------|
| `JAVA_HOME` | Ruta al directorio de instalación del JDK 17    |
| `M2_HOME`   | Ruta al directorio de instalación de Maven      |
| `Path`      | Debe incluir las carpetas `bin` de Java y Maven |

---

## Estructura del Proyecto

```
src/
└── test/
    ├── java/
    │   ├── page/                          # Page Objects (POM)
    │   │   ├── LoginPage.java
    │   │   ├── InventoryPage.java
    │   │   ├── CartPage.java
    │   │   ├── CheckoutInformationPage.java
    │   │   ├── CheckoutOverviewPage.java
    │   │   ├── CheckoutCompletePage.java
    │   │   └── MenuPage.java
    │   ├── steps/                         # Lógica de pasos de negocio
    │   │   ├── LoginSteps.java
    │   │   └── ShoppingSteps.java
    │   ├── stepdefinitions/               # Glue entre Gherkin y Steps
    │   │   ├── LoginStepDefinitions.java
    │   │   └── ShoppingStepDefinitions.java
    │   └── runner/                        # Ejecutor de pruebas
    │       └── SaucedemoRunner.java
    └── resources/
        ├── features/                      # Escenarios en Gherkin
        │   ├── Login.feature
        │   └── Shopping.feature
        ├── testdata.properties            # Credenciales y datos de prueba
        └── serenity.conf                  # Configuración de Serenity
```

---

## Patrón de Diseño

El proyecto implementa el patrón **Page Object Model (POM)** junto con la arquitectura de capas de Serenity BDD:

| Capa                | Clase                                             | Responsabilidad                                        |
|:--------------------|:--------------------------------------------------|:-------------------------------------------------------|
| **Page**            | `LoginPage`, `InventoryPage`, etc.                | Encapsula localizadores y acciones sobre cada pantalla |
| **Steps**           | `LoginSteps`, `ShoppingSteps`                     | Contiene la lógica de negocio reutilizable con `@Step` |
| **StepDefinitions** | `LoginStepDefinitions`, `ShoppingStepDefinitions` | Conecta los pasos Gherkin con los Steps de Java        |
| **Runner**          | `SaucedemoRunner`                                 | Configura y lanza la ejecución de los features         |

---

## Datos de Prueba

Las credenciales y datos sensibles están almacenados en `src/test/resources/testdata.properties` y **no se exponen en los escenarios Gherkin**, siguiendo buenas prácticas de seguridad.

```properties
# Usuarios de SauceDemo
sauce.user.standard=standard_user
sauce.user.locked=locked_out_user
sauce.user.problem=problem_user
sauce.user.performance=performance_glitch_user

# Contraseña común
sauce.password=secret_sauce

# Datos de checkout
checkout.firstname=...
checkout.lastname=...
checkout.zipcode=...
```

---

## Ejecución de las Pruebas

Existen dos formas de ejecutar el proyecto:

**Opción 1 — Desde IntelliJ IDEA:** Click derecho sobre `SaucedemoRunner` → `Run 'SaucedemoRunner'`, ubicado en `src/test/java/runner/SaucedemoRunner.java`. Ejecuta la totalidad de las 17 pruebas formuladas.

**Opción 2 — Desde la terminal:** Ejecutar en la raíz del proyecto utilizando **Git Bash** o cualquier terminal compatible con Maven, como se indica a continuación.

---

## Comandos de Ejecución

### Ejecutar todas las pruebas
```bash
mvn clean verify
```

### Ejecutar por módulo
```bash
# Solo pruebas de Autenticacion
mvn clean verify -Dcucumber.filter.tags="@Login"

# Solo pruebas de Compras
mvn clean verify -Dcucumber.filter.tags="@Shopping"
```

### Ejecutar por tipo de escenario
```bash
# Solo Happy Path
mvn clean verify -Dcucumber.filter.tags="@Happy-Path"

# Solo Unhappy Path
mvn clean verify -Dcucumber.filter.tags="@Unhappy-Path"

# Solo pruebas criticas (Smoke)
mvn clean verify -Dcucumber.filter.tags="@Smoke"

# Regresion completa
mvn clean verify -Dcucumber.filter.tags="@Regression"
```

### Ejecutar un escenario especifico
```bash
# Ejemplo Login
mvn clean verify -Dcucumber.filter.tags="@T-L01"

# Ejemplo Shopping
mvn clean verify -Dcucumber.filter.tags="@T-S01"
```

---

## Reglas de Negocio Automatizadas

### 1. Autenticacion de Usuarios — `Login.feature`

Ejecutar todos los escenarios del modulo:
```bash
mvn clean verify -Dcucumber.filter.tags="@Login"
```

| Codigo    | Escenario                                                   |         Tipo           |
|:----------|:------------------------------------------------------------|:----------------------:|
| **T-L01** | Login exitoso con credenciales validas                      | `@Happy-Path` `@Smoke` |
| **T-L02** | Cierre de sesion exitoso                                    | `@Happy-Path` `@Smoke` |
| **T-L03** | Login fallido con usuario bloqueado                         |    `@Unhappy-Path`     |
| **T-L04** | Login fallido con usuario con problemas                     |    `@Unhappy-Path`     |
| **T-L05** | Login con usuario de rendimiento degradado                  |    `@Unhappy-Path`     |
| **T-L06** | Login con usuario con error                                 |    `@Unhappy-Path`     |
| **T-L07** | Login con usuario con fallo visual                          |    `@Unhappy-Path`     |
| **T-L08** | Login fallido con credenciales invalidas (Scenario Outline) |    `@Unhappy-Path`     |

---

### 2. Compras — `Shopping.feature`

Ejecutar todos los escenarios del modulo:
```bash
mvn clean verify -Dcucumber.filter.tags="@Shopping"
```

| Codigo    | Escenario                                              |         Tipo           |
|:----------|:-------------------------------------------------------|:----------------------:|
| **T-S01** | Compra exitosa de un producto                          | `@Happy-Path` `@Smoke` |
| **T-S02** | Compra exitosa de un grupo de productos                |     `@Happy-Path`      |
| **T-S03** | Checkout fallido con datos de envio vacios             |    `@Unhappy-Path`     |
| **T-S04** | Remover un producto del carrito exitosamente           |     `@Happy-Path`      |
| **T-S05** | Remover un grupo de productos del carrito exitosamente |     `@Happy-Path`      |
| **T-S06** | Cancelar un pedido en la pagina Information            |     `@Happy-Path`      |
| **T-S07** | Cancelar un pedido en la pagina Overview               |     `@Happy-Path`      |

---

## Reporte de Resultados

Al finalizar la ejecucion, Serenity genera automaticamente un reporte HTML detallado que incluye capturas de pantalla de cada paso, estadisticas por modulo y resultado de cada escenario.

**Ubicacion del reporte:**
```
target/site/serenity/index.html
```

Abrelo directamente desde IntelliJ con click derecho → **Open In → Browser**, o navegando a la ruta desde el explorador de archivos.
package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageObject {
    @FindBy(id = "react-burger-menu-btn")
    WebElementFacade menuButton;

    @FindBy(id = "logout_sidebar_link")
    WebElementFacade logoutButton;

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickLogoutButton() {}
}

package homework4.steps;

import homework3.elements.ClickElement;
import homework3.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Action extends InitSteps {
    public Action(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    //@Step("Navigate to site")
    public void navigateToSite(String siteUrlProperty) {
        homePage = new HomePage(webDriver, properties.getProperty(siteUrlProperty));
    }

    //@Step("Perform login")
    public void login(String loginProperty, String passwordProperty) {
        homePage.performLogin(properties.getProperty(loginProperty), properties.getProperty(passwordProperty));
    }

    //@Step("Switch to default page")
    public void switchToDefaultPage() {
        homePage.returnToDefaultContent();
    }

    //@Step("Select {dropDownOption} in navigation bar dropdown")
    public void clickNavigationBarDropDown(String dropDownOption) {
        homePage.getNavigationBar().clickNavigationBarDropDown(dropDownOption);
    }

    @Step("Select {option} checkbox")
    public void clickCheckbox(String option) {
        ClickElement.clickWithOption(differentElements.getCheckboxes(), option);
    }

    //@Step("Select {option} radio")
    public void clickRadios(String option) {
        ClickElement.clickWithOption(differentElements.getRadios(), option);
    }

    //@Step("Select {option} in dropdown")
    public void clickDropdown(String option) {
        ClickElement.chooseDropdownOption(differentElements.getDropdown(), option);
    }
}

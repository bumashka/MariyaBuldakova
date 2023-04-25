package homework3.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class NavigationBar {

    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> navigationBar;

    @FindBy(css = "ul[class='dropdown-menu'] li a")
    private List<WebElement> navigationBarDropDown;

    public NavigationBar(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getNavigationBarNames() {
        return navigationBar.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isDisplayed() {
        return navigationBar.stream().map(WebElement::isDisplayed).allMatch((s) -> s.equals(Boolean.TRUE));
    }

    public void clickNavigationBarOption(String option) {
        for (WebElement e : navigationBar) {
            if (e.getText().equals(option)) {
                e.click();
                return;
            }
        }
    }

    public List<WebElement> getNavigationBarDropDown() {
        return navigationBarDropDown;
    }

    public void clickNavigationBarDropDown(String option) {
        clickNavigationBarOption("SERVICE");
        ClickElement.chooseDropdownOption(getNavigationBarDropDown(), option);
    }
}

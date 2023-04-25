package homework3.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SideBarLeft {

    @FindBy(css = "ul[class='sidebar-menu left'] > li")
    private List<WebElement> sideBarElements;

    public SideBarLeft(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getSideBarNames() {
        return sideBarElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isDisplayed() {
        return sideBarElements.stream().map(WebElement::isDisplayed).allMatch((s) -> s.equals(Boolean.TRUE));
    }
}

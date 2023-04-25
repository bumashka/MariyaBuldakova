package homework3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DifferentElements {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(css = "select[class=uui-form-element] > option")
    private List<WebElement> dropdown;

    @FindBy(css = "ul[class='panel-body-list logs'] > li")
    private List<WebElement> logs;

    public DifferentElements(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public List<WebElement> getDropdown() {
        return dropdown;
    }

    public List<String> getLogs() {
        return logs.stream().map((s) -> s.getText()
                .substring(9)).collect(Collectors.toList());
    }

}

package homework3.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClickElement {

    public static void clickWithOption(List<WebElement> list, String option) {
        for (WebElement e : list) {
            if (e.getText().equals(option)) {
                e.findElement(By.tagName("input")).click();
            }
        }
    }

    public static void chooseDropdownOption(List<WebElement> list, String option) {
        for (WebElement e : list) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }
}

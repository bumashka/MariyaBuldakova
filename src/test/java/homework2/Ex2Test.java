package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Ex2Test extends Driver {

    @Test
    public void browserTitleTest() {
        // 2. Assert Browser title
        Assert.assertEquals(webDriver.getTitle(), "Home Page");
    }

    @Test
    public void loginTest() {
        // 4. Assert Username in the left-top side of screen that user is loggined
        Assert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
    }

    @Test
    public void elementsTest() {
        // 5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.className("dropdown-toggle")).click();
        webDriver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[3]/ul/li[8]/a")).click();

        // 6. Select checkboxes
        List<WebElement> checkboxes = webDriver.findElements(By.className("label-checkbox"));
        for (WebElement e : checkboxes) {
            if (e.getText().equals("Water") || e.getText().equals("Wind")) {
                e.findElement(By.tagName("input")).click();
            }
        }

        // 7. Select radio
        webDriver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[4]")).click();

        // 8. Select in dropdown
        webDriver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select/option[4]")).click();

        // 9. Assert logs
        List<String> logs = webDriver.findElements(By.cssSelector("ul[class='panel-body-list logs'] > li")).stream().map((s) -> s.getText().substring(9)).collect(Collectors.toList());

        String[] realLogs = new String[]{
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        for (int i = 0; i < logs.size(); i++) {
            Assert.assertEquals(logs.get(i), realLogs[i]);
        }

    }
}

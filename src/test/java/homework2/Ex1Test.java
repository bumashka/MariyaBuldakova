package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Ex1Test extends Driver {
    @Test
    public void test() {

        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        // 4. Assert Username is loggined
        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        for (String s : new String[]{"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"}) {
            softAssert.assertTrue(webDriver.findElement(By.linkText(s)).isDisplayed());
        }

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> elements = webDriver.findElements(By.className("benefit-icon"));
        for (WebElement e : elements) {
            softAssert.assertTrue(e.isDisplayed());
        }

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        String[] expectedTexts = new String[]{
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
        };
        List<WebElement> benefitTexts = webDriver.findElements(By.className("benefit-txt"));
        for (int i = 0; i < benefitTexts.size(); i++) {
            softAssert.assertEquals(benefitTexts.get(i).getText(), expectedTexts[i]);
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(webDriver.findElement(By.id("frame")));
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> sidebarItems = webDriver.findElements(By.cssSelector("ul[class='sidebar-menu left'] > li"));
        String[] sidebarNames = new String[]{"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        for (int i = 0; i < sidebarItems.size(); i++) {
            softAssert.assertTrue(sidebarItems.get(i).isDisplayed());
            softAssert.assertEquals(sidebarItems.get(i).getText(), sidebarNames[i]);
        }

        softAssert.assertAll();
    }
}

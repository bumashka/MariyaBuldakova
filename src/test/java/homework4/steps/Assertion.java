package homework4.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class Assertion extends InitSteps {

    public Assertion(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    //@Step("Assert browser title: {title}")
    public void browserTitleAsExpected(String title) {
        Assert.assertEquals(homePage.getTitle(), title);
    }

    //@Step("Assert Username with {name} is loggined")
    public void loggedInUserNameAsExpected(String name) {
        Assert.assertEquals(homePage.getLoggedUserName(), name);
    }

    //@Step("Assert that there are 4 items on the header section are displayed")
    public void headerNavigationBarDisplayed() {
        Assert.assertTrue(homePage.getNavigationBar().isDisplayed());
    }

    //@Step("Assert that there are 4 items on the header section have proper texts")
    public void headerNavigationBarAsExpected(List<String> expectedNames) {
        Assert.assertEquals(homePage.getNavigationBar().getNavigationBarNames(), expectedNames);
    }

    //@Step("Assert that there are 4 images on the Index Page, and they are displayed")
    public void indexPageImagesDisplayed() {
        for (WebElement e : homePage.getBenefitIcons()) {
            Assert.assertTrue(e.isDisplayed());
        }
    }

    //@Step("Assert that there are 4 texts on the Index Page under icons, and they have proper text")
    public void indexPageTextsAsExpected(List<String> expectedTests) {
        Assert.assertEquals(homePage.getBenefitTexts(), expectedTests);
    }

    //@Step("Assert that there is the iframe with “Frame Button” exist")
    public void iframeWithFrameButtonDisplayed() {
        Assert.assertTrue(homePage.getFrame().isDisplayed());
    }

    //@Step("Assert that there is “Frame Button” in the iframe")
    public void frameButtonDisplayed() {
        Assert.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    //@Step("Assert that there are 5 items in the Left Section are displayed")
    public void leftSectionBarItemsDisplayed() {
        Assert.assertTrue(homePage.getSideBar().isDisplayed());
    }

    //@Step("Assert that there are 5 items in the Left Section have proper text")
    public void leftSectionBarItemsNamesAsExpected(List<String> expectedNames) {

        Assert.assertEquals(homePage.getSideBar().getSideBarNames(), expectedNames);
    }

    //@Step("Assert logs")
    public void logsAsExpected(List<String> expectedLogs) {
        Assert.assertEquals(differentElements.getLogs(), expectedLogs);
    }
}

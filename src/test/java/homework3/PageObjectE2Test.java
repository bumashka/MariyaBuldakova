package homework3;

import homework3.elements.ClickElement;
import homework3.exepectedvalues.ExpectedItems;
import homework3.pages.DifferentElements;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectE2Test extends Driver {
    @Test
    public void browserTitleTest() {
        // 2. Assert Browser title
        Assert.assertEquals(homePage.getTitle(), ExpectedItems.getExpectedHomePageName());
    }

    @Test
    public void loginTest() {
        // 4. Assert Username in the left-top side of screen that user is loggined
        Assert.assertEquals(homePage.getLoggedUserName(), ExpectedItems.getExpectedUserName());
    }

    @Test
    public void elementsTest() {

        DifferentElements differentElements = new DifferentElements(webDriver);

        // 5. Open through the header menu Service -> Different Elements Page
        homePage.getNavigationBar().clickNavigationBarDropDown("DIFFERENT ELEMENTS");

        ClickElement.clickWithOption(differentElements.getCheckboxes(), "Water");
        ClickElement.clickWithOption(differentElements.getCheckboxes(), "Wind");
        ClickElement.clickWithOption(differentElements.getRadios(), "Selen");
        ClickElement.chooseDropdownOption(differentElements.getDropdown(), "Yellow");

        Assert.assertEquals(differentElements.getLogs(), ExpectedItems.getExpectedLogs());

    }
}

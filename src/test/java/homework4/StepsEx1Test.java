package homework4;

import homework3.exepectedvalues.ExpectedItems;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Test Exercise 1")
public class StepsEx1Test extends Driver {
    @Test
    @Story("Testing of a home page")
    public void test() {

        // 2. Assert browser title
        assertion.browserTitleAsExpected(ExpectedItems.getExpectedHomePageName());

        // 4. Assert Username is loggined
        assertion.loggedInUserNameAsExpected(ExpectedItems.getExpectedUserName());

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        assertion.headerNavigationBarDisplayed();
        assertion.headerNavigationBarAsExpected(ExpectedItems.getExpectedNavigationBarNames());

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        assertion.indexPageImagesDisplayed();

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        assertion.indexPageTextsAsExpected(ExpectedItems.getExpectedBenefitTexts());

        // 8. Assert that there is the iframe with “Frame Button” exist
        assertion.iframeWithFrameButtonDisplayed();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertion.frameButtonDisplayed();

        // 10. Switch to original window back
        action.switchToDefaultPage();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        assertion.leftSectionBarItemsDisplayed();
        assertion.leftSectionBarItemsNamesAsExpected(ExpectedItems.getExpectedSideBarNames());
    }
}

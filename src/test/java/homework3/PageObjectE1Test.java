package homework3;

import homework3.exepectedvalues.ExpectedItems;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PageObjectE1Test extends Driver {
    @Test
    public void test() {

        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(homePage.getTitle(), ExpectedItems.getExpectedHomePageName());

        // 4. Assert Username is loggined
        softAssert.assertEquals(homePage.getLoggedUserName(), ExpectedItems.getExpectedUserName());

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softAssert.assertEquals(homePage.getNavigationBar().getNavigationBarNames(), ExpectedItems.getExpectedNavigationBarNames());
        softAssert.assertTrue(homePage.getNavigationBar().isDisplayed());

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        for (WebElement e : homePage.getBenefitIcons()) {
            softAssert.assertTrue(e.isDisplayed());
        }
        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertEquals(homePage.getBenefitTexts(), ExpectedItems.getExpectedBenefitTexts());

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.getFrame().isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());

        // 10. Switch to original window back
        homePage.returnToDefaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softAssert.assertTrue(homePage.getSideBar().isDisplayed());
        softAssert.assertEquals(homePage.getSideBar().getSideBarNames(), ExpectedItems.getExpectedSideBarNames());

        softAssert.assertAll();
    }
}

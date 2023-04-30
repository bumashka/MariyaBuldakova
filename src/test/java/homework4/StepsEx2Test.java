package homework4;

import homework3.exepectedvalues.ExpectedItems;
import org.testng.annotations.Test;

public class StepsEx2Test extends Driver {
    @Test
    //@Story( "Testing of a home and different elements pages")
    public void test() {
        // 2. Assert Browser title
        assertion.browserTitleAsExpected(ExpectedItems.getExpectedHomePageName());
        // 4. Assert Username in the left-top side of screen that user is loggined
        assertion.loggedInUserNameAsExpected(ExpectedItems.getExpectedUserName());

        // 5. Open through the header menu Service -> Different Elements Page
        action.clickNavigationBarDropDown("DIFFERENT ELEMENTS");

        // 6. Select checkboxes
        action.clickCheckbox("Water");
        action.clickCheckbox("Wind");

        // 7. Select radios
        action.clickRadios("Selen");

        //8. Select in dropdown
        action.clickDropdown("Yellow");

        //9. Assert logs
        assertion.logsAsExpected(ExpectedItems.getExpectedLogs());

    }
}

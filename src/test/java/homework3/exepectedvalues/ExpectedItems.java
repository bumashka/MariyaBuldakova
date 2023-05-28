package homework3.exepectedvalues;

import java.util.List;

public final class ExpectedItems {

    private static final List<String> expectedLogs = List.of(
            "Colors: value changed to Yellow",
            "metal: value changed to Selen",
            "Wind: condition changed to true",
            "Water: condition changed to true"
    );
    private static final List<String> expectedBenefitTexts = List.of(
            "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
            "To be flexible and\n" + "customizable",
            "To be multiplatform",
            "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
    );
    private static final List<String> expectedSideBarNames = List.of(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"
    );
    private static final List<String> expectedNavigationBarNames = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    private static final String expectedHomePageName = "Home Page";
    private static final String expectedUserName = "ROMAN IOVLEV";

    public static List<String> getExpectedLogs() {
        return expectedLogs;
    }

    public static List<String> getExpectedBenefitTexts() {
        return expectedBenefitTexts;
    }

    public static String getExpectedHomePageName() {
        return expectedHomePageName;
    }

    public static String getExpectedUserName() {
        return expectedUserName;
    }

    public static List<String> getExpectedSideBarNames() {
        return expectedSideBarNames;
    }

    public static List<String> getExpectedNavigationBarNames() {
        return expectedNavigationBarNames;
    }


}

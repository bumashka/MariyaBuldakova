package homework4;

import homework3.exepectedvalues.ExpectedItems;
import homework3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FailureTest {
    private WebDriver webDriver;

    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/test/resources/data.properties")));
        System.setProperty("webdriver.chrome.driver", "C:\\test-app\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        HomePage homePage = new HomePage(webDriver, properties.getProperty("site.url"));

        // 3. Perform login
        homePage.performLogin(properties.getProperty("user.login"), properties.getProperty("user.password"));

        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(homePage.getTitle(), "BUBBLE GUM");

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

    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}

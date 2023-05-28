package homework4;

import homework4.steps.Action;
import homework4.steps.Assertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Driver {
    public static Action action;
    public static Assertion assertion;
    private static WebDriver webDriver;

    @BeforeTest
    public static void setWebDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\test-app\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        action = new Action(webDriver);
        assertion = new Assertion(webDriver);

        action.navigateToSite("site.url");

        // 3. Perform login
        action.login("user.login", "user.password");
    }

    // Browser is closed
    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}

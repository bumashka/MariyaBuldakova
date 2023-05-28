package homework3;

import homework3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Driver {
    public static WebDriver webDriver;
    public static HomePage homePage;

    @BeforeTest
    public static void setWebDriver() throws IOException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/test/resources/data.properties")));
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        homePage = new HomePage(webDriver, properties.getProperty("site.url"));

        // 3. Perform login
        homePage.performLogin(properties.getProperty("user.login"), properties.getProperty("user.password"));
    }

    // Browser is closed
    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}
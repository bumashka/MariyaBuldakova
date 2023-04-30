package homework4.steps;

import homework3.pages.DifferentElements;
import homework3.pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class InitSteps {
    public static WebDriver webDriver;
    public static HomePage homePage;
    public static Properties properties;
    public static DifferentElements differentElements;

    public InitSteps(WebDriver webDriver) throws IOException {
        properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/test/resources/data.properties")));

        InitSteps.webDriver = webDriver;
        differentElements = new DifferentElements(InitSteps.webDriver);

        homePage = new HomePage(InitSteps.webDriver, properties.getProperty("site.url"));
    }
}

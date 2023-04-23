package homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Driver {
    public static WebDriver webDriver;

    @BeforeTest
    public static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\test-app\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
    }

    // Browser is closed
    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}

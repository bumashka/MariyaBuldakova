package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 3. Perform login
        webDriver.findElements(By.className("dropdown-toggle")).stream().skip(1).peek(WebElement::click).findFirst();

        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
    }

    // Browser is closed
    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}

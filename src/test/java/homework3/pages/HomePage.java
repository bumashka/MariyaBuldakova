package homework3.pages;

import homework3.elements.NavigationBar;
import homework3.elements.SideBarLeft;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    private final WebDriver webDriver;
    private final SideBarLeft sideBarLeft;

    private final NavigationBar navigationBar;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "name")
    private WebElement loginName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "body > header > div > nav > ul.uui-navigation.navbar-nav.navbar-right > li > a > span")
    private WebElement loginDropDownButton;
    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTexts;
    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;
    @FindBy(id = "frame")
    private WebElement frame;

    public HomePage(WebDriver webDriver, String p) {
        this.webDriver = webDriver;
        this.sideBarLeft = new SideBarLeft(webDriver);
        this.navigationBar = new NavigationBar(webDriver);

        // 1. Open test site by URL
        webDriver.navigate().to(p);
        PageFactory.initElements(this.webDriver, this);
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public List<String> getBenefitTexts() {
        return benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public SideBarLeft getSideBar() {
        return sideBarLeft;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        webDriver.switchTo().frame(frame);
        return webDriver.findElement(By.id("frame-button"));
    }

    public void returnToDefaultContent() {
        webDriver.switchTo().defaultContent();
    }

    public void performLogin(String login, String password) {
        this.loginDropDownButton.click();
        this.loginName.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getLoggedUserName() {
        return userName.getText();
    }
}

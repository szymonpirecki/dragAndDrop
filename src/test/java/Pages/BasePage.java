package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait defaultWait;
    public Actions actions;

    public BasePage(WebDriver driver) {
        init(driver);
        PageFactory.initElements(driver, this);
    }

    private void init(WebDriver driver) {
        this.driver = driver;
        defaultWait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("explicitWaitTimeout"))));
        actions = new Actions(driver);
    }
}

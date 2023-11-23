package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private static final String HOMEPAGE_URL="https://pastebin.com/";
    private WebDriver webDriver;
    private final int WAIT_TIMEOUT_SECOND = 10;

    private WebElement inputCode;
    private final By inputCodeLocator =By.id("postform-text");

    private WebElement buttonExpiration;
    private final By buttonExpirationLocator=By.id("select2-postform-expiration-container");


    private List<WebElement> selectionExpiration;
    private final By selectionExpirationLocator
            =By.xpath("//*[contains(@id, 'select2-postform-expiration-result') and @role='option']");

    private WebElement inputNameTitle;
    private final By inputNameTitleLocator=By.id("postform-name");

    public HomePage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public HomePage openPage () {
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public HomePage setCode (String code) {
        inputCode =waitForElementLocateBy(webDriver, inputCodeLocator);
        inputCode.click();
        inputCode.sendKeys(code);
        return this;
    }

    public HomePage setExpiration (String expiration) {
        buttonExpiration=waitForElementLocateBy(webDriver, buttonExpirationLocator);
        buttonExpiration.click();
        selectionExpiration=waitForElementsLocateBy(webDriver, selectionExpirationLocator);
        String s = selectionExpiration.get(0).getText();
        for (WebElement webElement: selectionExpiration) {
            if (webElement.getText().equals(expiration)) {
                webElement.click();
                break;
            }
        }
        return this;
    }

    public HomePage setNameOrTitle (String nameOrTitle) {
        inputNameTitle=waitForElementLocateBy(webDriver, inputNameTitleLocator);
        inputNameTitle.click();
        inputNameTitle.sendKeys(nameOrTitle);
        return  this;
    }

    private WebElement waitForElementLocateBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECOND))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private List<WebElement> waitForElementsLocateBy (WebDriver webDriver, By by) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECOND))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class HomePage extends AbstractPage{

    private static final String HOMEPAGE_URL="https://pastebin.com/";

    private WebElement inputCode;
    private final By inputCodeLocator =By.id("postform-text");

    private WebElement buttonHighlighting;
    private final By buttonHighlightingLocator=By.id("select2-postform-format-container");
    private List<WebElement> selectionHighlighting;
    private final By selectionHighlightingLocator
            =By.xpath("//*[contains(@id, 'select2-postform-format-result') " +
            "and @role='option' and not(contains (@aria-disabled, 'true'))]");

    private WebElement buttonExpiration;
    private final By buttonExpirationLocator=By.id("select2-postform-expiration-container");
    private List<WebElement> selectionExpiration;
    private final By selectionExpirationLocator
            =By.xpath("//*[contains(@id, 'select2-postform-expiration-result') and @role='option']");

    private WebElement inputNameTitle;
    private final By inputNameTitleLocator=By.id("postform-name");

    private WebElement buttonCreate;
    private final By buttonCreateLocator =By.xpath("//*[.='Create New Paste']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public void setCode (String code) {
        inputCode =waitForElementLocateBy(inputCodeLocator);
        toClick(inputCode);
        inputCode.sendKeys(code);
    }

    public void setHighlighting (String expiration) {
        buttonHighlighting=waitForElementLocateBy(buttonHighlightingLocator);
        toClick(buttonHighlighting);
        selectionHighlighting=waitForElementsLocateBy(selectionHighlightingLocator);
//        String s = selectionHighlighting.get(0).getText();
        for (WebElement webElement: selectionHighlighting) {
            if (webElement.getText().equals(expiration)) {
                toClick(webElement);
                break;
            }
        }
    }

    public void setExpiration (String expiration) {
        buttonExpiration=waitForElementLocateBy(buttonExpirationLocator);
        toClick(buttonExpiration);
        selectionExpiration=waitForElementsLocateBy(selectionExpirationLocator);
//        String s = selectionExpiration.get(0).getText();
        for (WebElement webElement: selectionExpiration) {
            if (webElement.getText().equals(expiration)) {
                webElement.click();
                break;
            }
        }
    }

    public void setNameOrTitle (String nameOrTitle) {
        inputNameTitle=waitForElementLocateBy(inputNameTitleLocator);
        toClick(inputNameTitle);
        inputNameTitle.sendKeys(nameOrTitle);
    }

    public void createNewPaste () {
        buttonCreate=waitForElementLocateBy(buttonCreateLocator);
        toClick(buttonCreate);
    }

    private void scroll (WebElement webElement) {
        new Actions(webDriver)
                .scrollToElement(webElement)
                .scrollByAmount(0, 100)
                .perform();
    }

    private void toClick (WebElement webElement) {
        try {
            webElement.click();
        }
        catch (ElementClickInterceptedException exception) {
            scroll(webElement);
            webElement.click();
        }
    }
}

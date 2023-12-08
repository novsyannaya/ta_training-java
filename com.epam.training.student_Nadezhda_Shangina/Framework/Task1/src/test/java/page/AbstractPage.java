package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {
    protected WebDriver webDriver;

    protected final int WAIT_TIMEOUT_SECOND = 50;
    protected AbstractPage (WebDriver driver) {
        this.webDriver=driver;
    }
    protected abstract AbstractPage openPage();

    protected WebElement waitForElementLocateBy(By by) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECOND))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> waitForElementsLocateBy (By by) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECOND))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected boolean checkAvailable(By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void scroll (WebElement webElement) {
        new Actions(webDriver)
                .scrollToElement(webElement)
                .scrollByAmount(0, 100)
                .perform();
    }
}

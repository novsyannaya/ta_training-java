package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage extends AbstractPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private final String HOMEPAGE_URL="https://cloud.google.com/";

    private WebElement buttonSearch;
    private final By buttonSearchLocator=By.className("YSM5S");

    private WebElement inputSearch;
    private final By inputSearchLocator=By.className("mb2a7b");

    private WebElement linkGoToResult;
    private By linkGoToResultLocator;

    @Override
    public AbstractPage openPage() {
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public void search(String textForSearch) {
        buttonSearch=waitForElementLocateBy(buttonSearchLocator);
        buttonSearch.click();
        inputSearch=waitForElementLocateBy(inputSearchLocator);
        inputSearch.isEnabled();
        inputSearch.isSelected();
        inputSearch.click();
        inputSearch.sendKeys(textForSearch);
        inputSearch.sendKeys(Keys.ENTER);
    }

    public void goToResult(String result) {
        String makeLocator="//div[@class='gs-title']//b[contains(.,'"+ result+"')]";
        linkGoToResultLocator=By.xpath(makeLocator);
        linkGoToResult=waitForElementLocateBy(linkGoToResultLocator);
        linkGoToResult.click();
    }
}

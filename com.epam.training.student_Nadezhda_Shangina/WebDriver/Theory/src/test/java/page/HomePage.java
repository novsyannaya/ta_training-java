package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends AbstractPage{
    private static final String HOMEPAGE_URL="https://www.selenium.dev/";
//    private WebDriver driver;

    @FindBy(className="DocSearch-Search-Icon")
    private WebElement searchClass;

    @FindBy(className="DocSearch-Input")
    private WebElement searchInput;

    @FindBy(xpath="//div[contains(@class, 'DocSearch-Hit-Container')]")
    private List<WebElement> searchResult;

    public HomePage(WebDriver driver) {
        super(driver);
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    public HomePage openPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public HomePage searchForTerms(String term) {
//        searchClass = waitForElementLocateBy(driver, By.className("DocSearch-Search-Icon"));
        searchClass.click();
//        searchInput = driver.findElement(By.className("DocSearch-Input"));
        searchInput.sendKeys(term);
        return this;

    }

    public int countSearchResult() {
//        searchResult=waitForElementsLocateBy(driver,
//                By.xpath("//div[contains(@class, 'DocSearch-Hit-Container')]"));
        return searchResult.size();
    }

    private static WebElement waitForElementLocateBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private static List<WebElement> waitForElementsLocateBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

}

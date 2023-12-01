package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage{
    private final String BASE_URL = "https://github.com/";

    @FindBy(id = "global-create-menu-button")
    private WebElement buttonCreateNew;

//    @FindBy(xpath = "//*[@id='//*[@id='global-create-menu-list']//li")
    private WebElement linkNewRepository;

    private final By linkLoggedInUserLocator = By.xpath("//meta[@name='user-login']");

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CreateNewRepositoryPage invokeNewRepositoryCreation()
    {
        buttonCreateNew.click();
        linkNewRepository=getWebElement(By
                .xpath("//*[@id='global-create-menu-list']//li"));
        linkNewRepository.click();
        return new CreateNewRepositoryPage(driver);
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getLoggedInUserName()
    {
        WebElement linkLoggedInUser = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
        return linkLoggedInUser.getAttribute("content");
    }
}

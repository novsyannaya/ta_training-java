package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateNewRepositoryPage extends AbstractPage{
    private final String BASE_URL = "http://www.github.com/new";
    private final Logger logger = LogManager.getRootLogger();

//    @FindBy(id = ":r2:")
    private WebElement inputRepositoryName;

//    @FindBy(id = ":r3:")
    private WebElement inputRepositoryDescription;

    @FindBy(xpath = "//*[@class='types__StyledButton-sc-ws60qy-0 SoHAO']//span[@data-component='text']")
    private WebElement buttonCreate;

    private final By labelEmptyRepoSetupOptionLocator = By.xpath("//h3/strong[text()='Quick setup']");

//    @FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
    private WebElement linkCurrentRepository;

    public CreateNewRepositoryPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isCurrentRepositoryEmpty()
    {
        WebElement labelEmptyRepoSetupOption = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(labelEmptyRepoSetupOptionLocator));
        return labelEmptyRepoSetupOption.isDisplayed();
    }

    public CreateNewRepositoryPage createNewRepository(String repositoryName, String repositoryDescription)
    {
        inputRepositoryName=getWebElement(By.id(":r2:"));
        inputRepositoryName.sendKeys(repositoryName);
        inputRepositoryDescription=getWebElement(By.id(":r3:"));
        inputRepositoryDescription.sendKeys(repositoryDescription);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        buttonCreate.click();
        logger.info("Created repository with name: [" + repositoryName +
                "[ and description: [" + repositoryDescription + "]");
        return this;
    }

    public String getCurrentRepositoryName()
    {
        linkCurrentRepository=getWebElement(By.xpath("//*[@class='mr-2 flex-self-stretch d-none d-md-block']//*"));
        return linkCurrentRepository.getText();
    }

    @Override
    public CreateNewRepositoryPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }
}

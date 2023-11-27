package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreatedPage extends AbstractPage {

    private WebElement pageTitle;
    private final By pageTitleLocator= By.className("info-top");

    private WebElement syntaxInfo ;
    private final By syntaxInfoLocator= By.xpath("//*[@class='left']/*[@class='btn -small h_800']");

    private List<WebElement> fieldCode ;
    private final By fieldCodeLocator=By.className("li1");

    public CreatedPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Please, don't open page again");
    }

    public String getPageTittle () {
        pageTitle=waitForElementLocateBy(pageTitleLocator);
        return pageTitle.getText();

    }

    public String getSyntax() {
        syntaxInfo=waitForElementLocateBy(syntaxInfoLocator);
        return syntaxInfo.getText();
    }

    public String getCode() {
        fieldCode=waitForElementsLocateBy(fieldCodeLocator);
        StringBuilder result=new StringBuilder();
        for (WebElement n: fieldCode) {
            result.append(n.getText());
            result.append("\n");
        }
        result.delete(result.length()-2, result.length());
        return result.toString();
    }
}

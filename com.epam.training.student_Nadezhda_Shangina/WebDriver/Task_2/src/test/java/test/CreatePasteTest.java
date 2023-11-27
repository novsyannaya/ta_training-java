package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.CreatedPage;
import page.HomePage;

public class CreatePasteTest {
    HomePage homePage;
    ChromeDriver driver;
    CreatedPage createdPage;
    String code = """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force
            """;

    @BeforeTest
    public void startTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        createdPage = new CreatedPage(driver);
    }

    @AfterTest
    public void endTest() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void CreatePasteCodeHighlightingExpirationName() {

        String syntaxHighlighting="Bash";
        String pasteExpiration = "10 Minutes";
        String pasteNameTitle = "how to gain dominance among developers";

        homePage.openPage();
        homePage.setCode(code);
        homePage.setHighlighting(syntaxHighlighting);
        homePage.setExpiration(pasteExpiration);
        homePage.setNameOrTitle(pasteNameTitle);
        homePage.createNewPaste();

        Assert.assertEquals(createdPage.getPageTittle(), pasteNameTitle);
        Assert.assertEquals(createdPage.getSyntax(), syntaxHighlighting);
        Assert.assertEquals(createdPage.getCode(), code);
    }
}

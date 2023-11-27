package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;


public class GenerateEmailPage  extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://yopmail.com/";
    String tabId;

    protected GenerateEmailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.get(HOMEPAGE_URL);
        tabId= webDriver.getWindowHandle();
        return this;
    }

    public String makeEmail() {
        openPage();
        waitForElementLocateBy(By.xpath("//*[@id='listeliens']" +
                "/*[@href='email-generator']")).click();
        String email;
        closeAd();
        email=waitForElementLocateBy(By.xpath("//*[@id='egen']")).getText();
        return email;
    }

    private void closeAd(){
        if(checkAvailable(By.id("aswift_6"))) {
            webDriver.switchTo().frame(waitForElementLocateBy(By.id("aswift_6")));
            webDriver.switchTo().frame(waitForElementLocateBy(By.xpath("//iframe[@title='Advertisement']")));
            waitForElementLocateBy(By
                    .xpath("//*[contains(@class, 'close') and contains(@class, 'button')]")).click();
//                        .xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[3]")).click();
        }
    }


    public String getCostFromEmail() throws InterruptedException {
        Thread.sleep(2000);
        WebElement buttonCheckEmail = waitForElementLocateBy(By
                .xpath("//button[@onclick='egengo();']"));
        scroll(buttonCheckEmail);
        buttonCheckEmail.click();
        webDriver.switchTo().frame("ifmail");
        return waitForElementLocateBy(By
                .xpath("//*[@id=\"mail\"]/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3"))
                .getText();
    }

    public String getIdTab() {
        return tabId;
    }

    private void scroll (WebElement webElement) {
        new Actions(webDriver)
                .scrollToElement(webElement)
                .scrollByAmount(0, 100)
                .perform();
    }
}

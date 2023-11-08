import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

//        Deprecated. Too general
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.selenium.dev/");
        WebElement searchClass = driver.findElement(By.className("DocSearch-Search-Icon"));
        searchClass.click();
        WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));
        searchInput.sendKeys("selenium java");


        List<WebElement> searchResult=driver.findElements(By
                        .xpath("(//div[contains(@class, 'DocSearch-Hit-Container') and contains(., 'Selenium') and contains(., 'Java') ])"));
        driver.quit();

//        WebElement search=driver.findElement(By.xpath("//div[contains(@class, 'DocSearch-Hit-Container') and contains(., 'Selenium') and contains(., 'Java')]"));
//        System.out.println("number of results"+searchResult.size());

//         WebElement searchBtn=driver.findElement(By.xpath(""));
//         searchBtn.click();

//        don't solve Synchronization problems
//        Thread.sleep(2000);

//        driver.quit();
    }
}

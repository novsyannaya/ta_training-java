package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePasteTest {
    HomePage homePage;
    ChromeDriver driver;

    @BeforeClass
    public void beforeTest() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void endTest() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void CreatePasteCodeExpirationName() {
        homePage=new HomePage(driver);
        homePage.openPage();
        homePage.setCode("Hello from WebDriver");
//        homePage.setExpiration("10 Minutes");


    }


}

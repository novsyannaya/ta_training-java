package test;

import org.testng.annotations.Test;
import page.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePasteTest {
    @Test
    public void CreatePasteCodeExpirationName() {
        HomePage homePage=new HomePage(new ChromeDriver());
        homePage.openPage();
        homePage.setCode("Hello from WebDriver");
        homePage.setExpiration("10 Minutes");
        homePage.setNameOrTitle("helloweb");
    }
}

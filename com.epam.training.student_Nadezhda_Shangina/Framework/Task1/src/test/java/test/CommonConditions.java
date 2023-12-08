package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import page.CalculatorPage;
import page.HomePage;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    HomePage homePage;
    CalculatorPage calculatorPage;


    @BeforeTest
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
        homePage=new HomePage(driver);
        calculatorPage = new CalculatorPage(driver);
    }
    @AfterTest
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

}

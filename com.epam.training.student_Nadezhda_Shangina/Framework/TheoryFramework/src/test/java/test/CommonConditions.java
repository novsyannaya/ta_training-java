package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
//    protected static final String USER_NAME = "forTestInEpam";
//    protected static final String USER_PASSWORD = "forTestforEpam2023";
//    private static final String RESOURCES_PATH = "src\\test\\resources\\";


    @BeforeMethod()
    public void setUp()
    {
//        System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver.exe");

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver= DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
//        driver.quit();
        DriverSingleton.closeDriver();
    }
}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.HomePage;

public class GetEmailTest {
    ChromeDriver driver;
    HomePage homePage;
    CalculatorPage calculatorPage;

    String product;
    String numberOfInstances;
    String software;
    String provisioningModel;
    String machineFamily;
    String series;
    String machineType;
    String gPUType;
    String numberOfGPUs;
    String localSSD;
    String datacenterLocation;
    String committedUsage;


    @BeforeMethod
    public void beforeTest(){
        driver=new ChromeDriver();
        homePage=new HomePage(driver);
        calculatorPage = new CalculatorPage(driver);
    }
    @Test
    public void getEmailWithCalculation () throws InterruptedException {
        String textToInput = "Google Cloud Pricing Calculator";
        homePage.openPage();
        homePage.search(textToInput);
        homePage.goToResult(textToInput);

        product = "COMPUTE ENGINE";
        numberOfInstances="4";
        software = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
        provisioningModel = "Regular";
        machineFamily = "General purpose";
        series = "N1";
        machineType ="n1-standard-8 (vCPUs: 8, RAM: 30GB)";
        gPUType="NVIDIA Tesla V100";
        numberOfGPUs="1";
        localSSD="2x375 GB";
        datacenterLocation="Frankfurt (europe-west3)";

        committedUsage="1 Year";

        calculatorPage.selectProduct(product);
        calculatorPage.setNumberOfInstances(numberOfInstances);
        calculatorPage.setSoftware(software);
        calculatorPage.setProvisioningModel(provisioningModel);
        calculatorPage.setMachineFamily(machineFamily);
        calculatorPage.setSeries(series);
        calculatorPage.setMachineType(machineType);
        calculatorPage.selectCheckbox();
        calculatorPage.setGPUType(gPUType);
        calculatorPage.setNumberOfGPUs(numberOfGPUs);
        calculatorPage.setLocalSSD(localSSD);
        calculatorPage.setDatacenterLocation(datacenterLocation);
        calculatorPage.setCommittedUsage(committedUsage);
        calculatorPage.AddToEstimate();


//      * Number of GPUs: 1
//      * Local SSD: 2x375 Gb
//      * Datacenter location: Frankfurt (europe-west3)
//      * Committed usage: 1 Year




        System.out.println(1);

    }

    //      * Provisioning model: Regular
//      * Machine Family: General purpose 
//      * Series: N1 
//      * Machine type: n1-standard-8 (vCPUs: 8, RAM: 30 GB)
//      * Select “Add GPUs“
//      * GPU type: NVIDIA Tesla V100
//      * Number of GPUs: 1
//      * Local SSD: 2x375 Gb
//      * Datacenter location: Frankfurt (europe-west3)
//      * Committed usage: 1 Year
}

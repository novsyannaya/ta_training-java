package test;

import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ProductCreator;

public class GetEmailTest extends CommonConditions {

    Product product;
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
    String totalEstimatedCost;

    @Test
    public void getEmailWithCalculation () throws InterruptedException {
        String textToInput = "Google Cloud Pricing Calculator";
        homePage.openPage();
        homePage.search(textToInput);
        homePage.goToResult(textToInput);

        product = ProductCreator.withCredentialsFromProperty();
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

        totalEstimatedCost="Total Estimated Cost: USD 1,081.20 per 1 month";

        calculatorPage.selectProduct(product);
        calculatorPage.setNumberOfInstances(numberOfInstances);
        calculatorPage.setSoftware(software);
        calculatorPage.setProvisioningModel(provisioningModel);
        calculatorPage.setMachineFamily(machineFamily);
        calculatorPage.setSeries(series);
        calculatorPage.setMachineType(machineType);
        calculatorPage.selectCheckbox();
        //outdated steps
//        calculatorPage.setGPUType(gPUType);
//        calculatorPage.setNumberOfGPUs(numberOfGPUs);
//        calculatorPage.setLocalSSD(localSSD);
        calculatorPage.setDatacenterLocation(datacenterLocation);
        calculatorPage.setCommittedUsage(committedUsage);
        calculatorPage.AddToEstimate();
        Assert.assertTrue(calculatorPage.checkTotalEstimatedCost());

        calculatorPage.sendEstimateToEmail();
        Assert.assertTrue(calculatorPage.checkCostFromEmail());
    }
}

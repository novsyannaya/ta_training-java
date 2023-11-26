package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalculatorPage extends AbstractPage{
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private boolean flagInForm =false;
    private final int TIME_FOR_GET_TEXT=400;

    private WebElement inputNumberOfInstances;
    private By inputNumberOfInstancesLocator= By.id("input_100");

    private List<WebElement> products;
    private By productsLocator=By.xpath("//*[contains(@id, 'tab-item-')]");

    private WebElement softwareSelect;
    private By softwareSelectLocator=By.id("select_113");
    private List<WebElement> listSoftware;
    private final By listSoftwareLocator =By.xpath("//*[@id='select_container_114']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement provisioningModelSelect;
    private By provisioningSelectLocator=By.id("select_117");
    private List<WebElement> listProvisioningModel;
    private final By listProvisioningModelLocator =By.xpath("//*[@id='select_container_118']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement machineFamilySelect;
    private By machineFamilySelectLocator=By.id("select_123");
    private List<WebElement> listMachineFamily;
    private final By listMachineFamilyLocator =By.xpath("//*[@id='select_container_124']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement seriesSelect;
    private By seriesSelectLocator=By.id("select_125");
    private List<WebElement> listSeries;
    private final By listSeriesLocator =By.xpath("//*[@id='select_container_126']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement machineTypeSelect;
    private By machineTypeSelectLocator=By.id("select_127");
    private List<WebElement> listMachineType;
    private final By listMachineTypeLocator =By.xpath("//*[@id='select_container_128']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement checkboxAddGPUs;
    private By checkboxAddGPUsLocator=By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']" +
            "//*[@class='md-container md-ink-ripple']");

    private WebElement gPUTypeSelect;
    private By gPUTypeSelectLocator=By.id("select_508");
    private List<WebElement> listGPUType;
    private final By listGPUTypeLocator =By.xpath("//*[@id='select_container_509']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement numberOfGPUsSelect;
    private By numberOfGPUsSelectLocator =By.id("select_510");
    private List<WebElement> listNumberOfGPUs;
    private final By listNumberOfGPUsLocator =By.xpath("//*[@id='select_container_511']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement localSSDSelect;
    private By localSSDSelectLocator=By.id("select_467");
    private List<WebElement> listLocalSSD;
    private final By listLocalSSDLocator =By.xpath("//*[@id='select_container_468']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement datacenterLocationSelect;
    private By datacenterLocationSelectLocator=By.id("select_133");
    private List<WebElement> listDatacenterLocation;
    private final By listDatacenterLocationLocator =By.xpath("//*[@id='select_container_134']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement committedUsageSelect;
    private By committedUsageSelectLocator=By.id("select_140");
    private List<WebElement> listCommittedUsage;
    private final By listCommittedUsageLocator =By.xpath("//*[@id='select_container_141']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement buttonAddToEstimate;
    private By buttonAddToEstimateLocator=By.xpath("//*[@name='ComputeEngineForm']//*[@type='button'][normalize-space()='Add to Estimate']");

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please, don't open page again");
    }

    public CalculatorPage selectProduct(String product) {
        checkPoint();
        products=waitForElementsLocateBy(productsLocator);
        for (WebElement n: products) {
            if (n.getText().equals(product)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setNumberOfInstances(String number) {
        checkPoint();
        inputNumberOfInstances=waitForElementLocateBy(inputNumberOfInstancesLocator);
        inputNumberOfInstances.click();
        inputNumberOfInstances.sendKeys(number);
        return this;
    }

    public CalculatorPage setSoftware (String software) throws InterruptedException {
        checkPoint();
        softwareSelect=waitForElementLocateBy(softwareSelectLocator);
        softwareSelect.click();

        listSoftware=waitForElementsLocateBy(listSoftwareLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listSoftware) {
            n.getText();
            if (n.getText().equals(software)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setProvisioningModel(String provisioningModel) throws InterruptedException {
        checkPoint();
        provisioningModelSelect=waitForElementLocateBy(provisioningSelectLocator);
        provisioningModelSelect.click();
        listProvisioningModel=waitForElementsLocateBy(listProvisioningModelLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listProvisioningModel) {
            if (n.getText().equals(provisioningModel)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setMachineFamily(String machineFamily) throws InterruptedException {
        checkPoint();
        machineFamilySelect=waitForElementLocateBy(machineFamilySelectLocator);
        machineFamilySelect.click();
        listMachineFamily=waitForElementsLocateBy(listMachineFamilyLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listMachineFamily) {
            if (n.getText().equals(machineFamily)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setSeries(String series) throws InterruptedException {
        checkPoint();
        seriesSelect=waitForElementLocateBy(seriesSelectLocator);
        seriesSelect.click();
        listSeries=waitForElementsLocateBy(listSeriesLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listSeries) {
            if (n.getText().equals(series)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setMachineType(String machineType) throws InterruptedException {
        checkPoint();
        machineTypeSelect=waitForElementLocateBy(machineTypeSelectLocator);
        machineTypeSelect.click();
        listMachineType=waitForElementsLocateBy(listMachineTypeLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listMachineType) {
            if (n.getText().equals(machineType)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage selectCheckbox() throws InterruptedException {
        checkPoint();
        checkboxAddGPUs=waitForElementLocateBy(checkboxAddGPUsLocator);
        checkboxAddGPUs.click();
        return this;
    }

    public CalculatorPage setGPUType(String gPUType) throws InterruptedException {
        checkPoint();
        gPUTypeSelect=waitForElementLocateBy(gPUTypeSelectLocator);
        gPUTypeSelect.click();
        listGPUType =waitForElementsLocateBy(listGPUTypeLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listGPUType) {
            if (n.getText().equals(gPUType)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setNumberOfGPUs(String numberOfGPUs) throws InterruptedException {
        checkPoint();
        numberOfGPUsSelect=waitForElementLocateBy(numberOfGPUsSelectLocator);
        numberOfGPUsSelect.click();
        listNumberOfGPUs =waitForElementsLocateBy(listNumberOfGPUsLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listNumberOfGPUs) {
            if (n.getText().equals(numberOfGPUs)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setLocalSSD(String localSSD) throws InterruptedException {
        checkPoint();
        localSSDSelect=waitForElementLocateBy(localSSDSelectLocator);
        localSSDSelect.click();
        listLocalSSD =waitForElementsLocateBy(listLocalSSDLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listLocalSSD) {
            if (n.getText().equals(localSSD)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setDatacenterLocation(String datacenterLocation) throws InterruptedException {
        checkPoint();
        datacenterLocationSelect=waitForElementLocateBy(datacenterLocationSelectLocator);
        datacenterLocationSelect.click();
        listDatacenterLocation =waitForElementsLocateBy(listDatacenterLocationLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listDatacenterLocation) {
            if (n.getText().equals(datacenterLocation)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public CalculatorPage setCommittedUsage(String committedUsage) throws InterruptedException {
        checkPoint();
        committedUsageSelect=waitForElementLocateBy(committedUsageSelectLocator);
        committedUsageSelect.click();
        listCommittedUsage =waitForElementsLocateBy(listCommittedUsageLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listCommittedUsage) {
            if (n.getText().equals(committedUsage)){
                n.click();
                return this;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void AddToEstimate() {
        buttonAddToEstimate=waitForElementLocateBy(buttonAddToEstimateLocator);
        buttonAddToEstimate.click();
    }



    private void checkPoint() {
        if (!flagInForm) {
            webDriver=webDriver.switchTo().frame(waitForElementLocateBy(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe")));
            webDriver=webDriver.switchTo().frame(waitForElementLocateBy(By.xpath("//*[@id=\"myFrame\"]")));
            flagInForm =true;
        }
    }
}

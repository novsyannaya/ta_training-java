package page;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorPage extends AbstractPage{
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private boolean flagInForm =false;
    private boolean flagFirstCall=false;

    private final int TIME_FOR_GET_TEXT=500;
    String idTabThisPage;
    String idTabEmail;
    private boolean flagSentEmail=false;
    GenerateEmailPage generateEmailPage;

    private WebElement inputNumberOfInstances;
    private final By inputNumberOfInstancesLocator= By.id("input_101");

    private List<WebElement> products;
    private final By productsLocator=By.xpath("//*[contains(@id, 'tab-item-')]");

    private WebElement softwareSelect;
    private final By softwareSelectLocator=By.id("select_114");
    private List<WebElement> listSoftware;
    private final By listSoftwareLocator =By.xpath("//*[@id='select_container_115']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement provisioningModelSelect;
    private final By provisioningSelectLocator=By.id("select_118");
    private List<WebElement> listProvisioningModel;
    private final By listProvisioningModelLocator =By.xpath("//*[@id='select_container_119']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement machineFamilySelect;
    private final By machineFamilySelectLocator=By.id("select_124");
    private List<WebElement> listMachineFamily;
    private final By listMachineFamilyLocator =By.xpath("//*[@id='select_container_125']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement seriesSelect;
    private final By seriesSelectLocator=By.id("select_126");
    private List<WebElement> listSeries;
    private final By listSeriesLocator =By.xpath("//*[@id='select_container_127']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement machineTypeSelect;
    private final By machineTypeSelectLocator=By.id("select_128");
    private List<WebElement> listMachineType;
    private final By listMachineTypeLocator =By.xpath("//*[@id='select_container_129']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement checkboxAddGPUs;
    private final By checkboxAddGPUsLocator=By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']" +
            "//*[@class='md-container md-ink-ripple']");

    private WebElement gPUTypeSelect;
    private final By gPUTypeSelectLocator=By.id("select_509");
    private List<WebElement> listGPUType;
    private final By listGPUTypeLocator =By.xpath("//*[@id='select_container_510']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement numberOfGPUsSelect;
    private final By numberOfGPUsSelectLocator =By.id("select_510");
    private List<WebElement> listNumberOfGPUs;
    private final By listNumberOfGPUsLocator =By.xpath("//*[@id='select_container_511']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement localSSDSelect;
    private final By localSSDSelectLocator=By.id("select_467");
    private List<WebElement> listLocalSSD;
    private final By listLocalSSDLocator =By.xpath("//*[@id='select_container_468']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement datacenterLocationSelect;
    private final By datacenterLocationSelectLocator=By.id("select_134");
    private List<WebElement> listDatacenterLocation;
    private final By listDatacenterLocationLocator =By.xpath("//*[@id='select_container_135']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement committedUsageSelect;
    private final By committedUsageSelectLocator=By.id("select_141");
    private List<WebElement> listCommittedUsage;
    private final By listCommittedUsageLocator =By.xpath("//*[@id='select_container_142']" +
            "//*[contains(@id, 'select_option_')]");

    private WebElement buttonAddToEstimate;
    private final By buttonAddToEstimateLocator=By.xpath("//*[@name='ComputeEngineForm']" +
            "//*[@type='button'][normalize-space()='Add to Estimate']");

    private WebElement totalEstimatedCost;
    private final By totalEstimatedCostLocator=By.xpath("//*[@class='cpc-cart-total']" +
            "//*[@class='md-title']");
    private String totalEstimatedCostText;

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please, don't open page again");
    }

    public void selectProduct(Product testProduct) {
        String product=testProduct.toString();
        waitForLoad();
        checkPoint();
        products=waitForElementsLocateBy(productsLocator);
        for (WebElement n: products) {
            if (n.getText().equals(product)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setNumberOfInstances(String number) {

        checkPoint();
        inputNumberOfInstances=waitForElementLocateBy(inputNumberOfInstancesLocator);
        inputNumberOfInstances.click();
        inputNumberOfInstances.sendKeys(number);
    }

    public void setSoftware (String software) throws InterruptedException {
        checkPoint();
        softwareSelect=waitForElementLocateBy(softwareSelectLocator);
        softwareSelect.click();

        listSoftware=waitForElementsLocateBy(listSoftwareLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listSoftware) {
            n.getText();
            if (n.getText().equals(software)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setProvisioningModel(String provisioningModel) throws InterruptedException {
        checkPoint();
        provisioningModelSelect=waitForElementLocateBy(provisioningSelectLocator);
        provisioningModelSelect.click();
        listProvisioningModel=waitForElementsLocateBy(listProvisioningModelLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listProvisioningModel) {
            if (n.getText().equals(provisioningModel)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setMachineFamily(String machineFamily) throws InterruptedException {
        checkPoint();
        machineFamilySelect=waitForElementLocateBy(machineFamilySelectLocator);
        machineFamilySelect.click();
        listMachineFamily=waitForElementsLocateBy(listMachineFamilyLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listMachineFamily) {
            if (n.getText().equals(machineFamily)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setSeries(String series) throws InterruptedException {
        checkPoint();
        seriesSelect=waitForElementLocateBy(seriesSelectLocator);
        seriesSelect.click();
        listSeries=waitForElementsLocateBy(listSeriesLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listSeries) {
            if (n.getText().equals(series)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setMachineType(String machineType) throws InterruptedException {
        checkPoint();
        machineTypeSelect=waitForElementLocateBy(machineTypeSelectLocator);
        machineTypeSelect.click();
        listMachineType=waitForElementsLocateBy(listMachineTypeLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listMachineType) {
            if (n.getText().equals(machineType)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void selectCheckbox() {
        checkPoint();
        checkboxAddGPUs=waitForElementLocateBy(checkboxAddGPUsLocator);
        checkboxAddGPUs.click();
    }

    public void setGPUType(String gPUType) throws InterruptedException {
        checkPoint();
        gPUTypeSelect=waitForElementLocateBy(gPUTypeSelectLocator);
        gPUTypeSelect.click();
        listGPUType =waitForElementsLocateBy(listGPUTypeLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listGPUType) {
            if (n.getText().equals(gPUType)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setNumberOfGPUs(String numberOfGPUs) throws InterruptedException {
        checkPoint();
        numberOfGPUsSelect=waitForElementLocateBy(numberOfGPUsSelectLocator);
        numberOfGPUsSelect.click();
        listNumberOfGPUs =waitForElementsLocateBy(listNumberOfGPUsLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listNumberOfGPUs) {
            if (n.getText().equals(numberOfGPUs)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setLocalSSD(String localSSD) throws InterruptedException {
        checkPoint();
        localSSDSelect=waitForElementLocateBy(localSSDSelectLocator);
        localSSDSelect.click();
        listLocalSSD =waitForElementsLocateBy(listLocalSSDLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listLocalSSD) {
            if (n.getText().equals(localSSD)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setDatacenterLocation(String datacenterLocation) throws InterruptedException {
        checkPoint();
        datacenterLocationSelect=waitForElementLocateBy(datacenterLocationSelectLocator);
        datacenterLocationSelect.click();
        listDatacenterLocation =waitForElementsLocateBy(listDatacenterLocationLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listDatacenterLocation) {
            if (n.getText().equals(datacenterLocation)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void setCommittedUsage(String committedUsage) throws InterruptedException {
        checkPoint();
        committedUsageSelect=waitForElementLocateBy(committedUsageSelectLocator);
        committedUsageSelect.click();
        listCommittedUsage =waitForElementsLocateBy(listCommittedUsageLocator);
        Thread.sleep(TIME_FOR_GET_TEXT);
        for (WebElement n: listCommittedUsage) {
            if (n.getText().equals(committedUsage)){
                n.click();
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public void AddToEstimate() {
        buttonAddToEstimate=waitForElementLocateBy(buttonAddToEstimateLocator);
        buttonAddToEstimate.click();
    }

    public boolean checkTotalEstimatedCost(){
        totalEstimatedCost=waitForElementLocateBy(totalEstimatedCostLocator);
        totalEstimatedCostText = totalEstimatedCost.getText();
        Pattern pattern = Pattern.compile("Total Estimated Cost: USD +[0-9.,]*+ per 1 month");
        Matcher matcher=pattern.matcher(totalEstimatedCostText);
        return matcher.matches();
    }

    public void sendEstimateToEmail() {
        idTabThisPage =webDriver.getWindowHandle();
        generateEmailPage= new GenerateEmailPage(webDriver);

        String email = generateEmailPage.makeEmail();
        idTabEmail = generateEmailPage.getIdTab();
        webDriver.switchTo().window(idTabThisPage);

        flagInForm=false;
        checkPoint();
        WebElement buttonEmailEstimate=waitForElementLocateBy(By.id("Email Estimate"));
        buttonEmailEstimate.click();
        WebElement inputEmail = waitForElementLocateBy(By.id("input_616"));
        inputEmail.click();
        inputEmail.sendKeys(email);
        waitForElementLocateBy(By.xpath("//*[@name='emailForm']" +
                "//*[@class='md-raised md-primary cpc-button md-button md-ink-ripple']"))
                .click();
        flagSentEmail=true;
    }

    public boolean checkCostFromEmail() throws InterruptedException {
        if (!flagSentEmail) throw new RuntimeException("Need to send email");
        if (!webDriver.getWindowHandle().equals(idTabThisPage))
            webDriver.switchTo().window(idTabThisPage);
        String costInCalculator=totalEstimatedCostText;
        costInCalculator=costInCalculator.replace("Total Estimated Cost: ","");
        costInCalculator=costInCalculator.replace(" per 1 month", "");

        webDriver.switchTo().window(idTabEmail);
        return costInCalculator.equals(generateEmailPage.getCostFromEmail());
    }

    private void checkPoint() {
        if (!flagInForm) {
            webDriver=webDriver.switchTo().frame(waitForElementLocateBy(By
                    .xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe")));
            webDriver=webDriver.switchTo().frame(waitForElementLocateBy(By
                    .xpath("//*[@id=\"myFrame\"]")));
            flagInForm =true;
        }
    }

    private void waitForLoad() {
        if (!flagFirstCall) {
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
            webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
            flagFirstCall=true;
        }
    }
}

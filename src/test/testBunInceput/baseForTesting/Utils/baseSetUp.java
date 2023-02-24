package baseForTesting.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class baseSetUp {

    protected WebDriver driver;
    String browser;
    protected String hostnameDouglas;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {

        //read from properties browser and hostname
        Properties properties = baseUtils.readProperties("src/test/testBunInceput/baseForTesting/resources/framework.properties");
        browser = System.getProperty("browser");

        //if there is no browser attributed to (browser==null) than we implement to var browser the browser wich is taken from Browsers enum
        if(browser==null)
        browser = properties.getProperty("browser"); System.out.println("Use browser: " + browser);

        hostnameDouglas = properties.getProperty("hostnameDouglas"); System.out.println("Use next hostname: " + hostnameDouglas);

        //get the browser type from switch method in baseUtils
        driver = baseUtils.getDriver(browser);
    }

    protected void enterValuesOnInput(WebElement el, String value) {
        el.click();
        el.clear();
        el.sendKeys(value);
    }

    @AfterMethod
    public void saveScreenShotAtFailure2(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            //your screenshooting code goes here
            String testName = result.getMethod().getMethodName();
            System.out.println("Take screen shoot..for test:" + testName);
            baseUtils.takeScreenShot(driver, testName);
        }
    }

}

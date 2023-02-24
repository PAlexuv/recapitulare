package BaseForTestingRahul.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseSetUp {
    protected WebDriver driver;
    String browser;
    protected String hostname;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        //read from the frameworkProperties.properties browser and hostname
        Properties properties = BaseMethodsUtils.readProperties("src/test/RahulTesting/BaseForTestingRahul/Resources/frameworkR.properties");

        browser = System.getProperty("browser");
        //if there is no browser attributed to (browser==null) than we implement to var browser the browser which is taken from Browsers enum
        if (browser == null)
            browser = properties.getProperty("browser");
        System.out.println("Use browser: " + browser);

        hostname = properties.getProperty("hostname");
        System.out.println("Use next hostname: " + hostname);

        //get the browser type from switch method in baseUtils
        driver = BaseMethodsUtils.getDriver(browser);
    }

    protected void enterValuesOnInput(WebElement el, String value) {
        el.click();
        el.clear();
        el.sendKeys(value);
    }

    @AfterMethod
    public void saveScreenShotAtFailure2(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getMethod().getMethodName();
            System.out.println("Take screen shoot..for test:" + testName);
            BaseMethodsUtils.takeScreenshot(driver, testName);
        }
    }

}

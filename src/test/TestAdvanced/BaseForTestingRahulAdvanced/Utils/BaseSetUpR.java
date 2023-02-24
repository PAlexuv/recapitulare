package BaseForTestingRahulAdvanced.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseSetUpR {
    protected WebDriver driver;
    String browser;
    protected String hostname;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {

        //read from properties browser and hostname
//        Properties properties = BaseUtilsR.readProperties("\\src\\test\\TestAdvanced\\baseForTestingRahul\\Resources\\frameworkProperties.properties.properties");
        Properties properties = BaseUtilsR.readProperties("src/test/TestAdvanced/BaseForTestingRahul/Resources/framework.properties");
        browser = System.getProperty("browser");
        //if there is no browser attributed to (browser==null) than we implement to var browser the browser which is taken from Browsers enum
        if(browser==null)

        browser = properties.getProperty("browser"); System.out.println("Use browser: " + browser);
        hostname = properties.getProperty("hostnameAK"); System.out.println("Use next hostname: " + hostname);

        //get the browser type from switch method in baseUtils
        driver = BaseUtilsR.getDriver(browser);
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
            BaseUtilsR.takeScreenShot(driver, testName);
        }
    }

}

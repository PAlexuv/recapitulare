package DoYouSpain.BaseForTesting.UtilsDYS;

import Twitter.BaseForTesting.UtilsTW.BaseMethodsTW;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseSetupDYS {
    protected WebDriver driver;
    protected String browserTypeDYS;
    protected String hostnameDYS;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {

        //read from the frameworkProperties.properties browser and hostname
        Properties propertiesDYS = BaseMethodsDYS.readProperties("src/main/java/DoYouSpain/BaseForTesting/ResourcesDYS/frameworkDYS.properties");

        hostnameDYS = propertiesDYS.getProperty("hostnameDYS");
        System.out.println("Hostname used: " + hostnameDYS);

        if (browserTypeDYS == null)
            browserTypeDYS = propertiesDYS.getProperty("browserDYS");
        System.out.println("Browser Used: " + browserTypeDYS);
        driver = BaseMethodsDYS.getBrowser(browserTypeDYS);
    }

    @AfterMethod
    public void saveScreenshotFailureDYS(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String testName = result.getMethod().getMethodName();
            System.out.println("Take screen shoot..for test:" + testName);
            BaseMethodsDYS.takeScreenShotsDYS(driver, testName);
        }
    }

}

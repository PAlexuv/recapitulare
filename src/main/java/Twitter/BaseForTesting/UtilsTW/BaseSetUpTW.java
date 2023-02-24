package Twitter.BaseForTesting.UtilsTW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseSetUpTW {
    protected WebDriver driver;
    protected String browserTypeTW;
    protected String hostnameTW;

    protected String dbHostnameTW;
    protected String dbPortTW;
    protected String dbUserTW;
    protected String dbPasswordTW;
    protected String dbSchemaTW;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {

        //read from the frameworkProperties.properties browser and hostname
        Properties propertiesTW = BaseMethodsTW.readPropertiesTW("src/main/java/Twitter/BaseForTesting/ResourcesTW/frameworkTW.properties");

        hostnameTW = propertiesTW.getProperty("hostnameTW");
        System.out.println("Hostname used: " + hostnameTW);

        browserTypeTW = propertiesTW.getProperty("browser");
        if(browserTypeTW == null)
            browserTypeTW = propertiesTW.getProperty("browser");
        System.out.println("Use browser: " + browserTypeTW);
        driver = BaseMethodsTW.getBrowser(browserTypeTW);
        //database
//        dbHostnameTW = propertiesTW.getProperty("dbHostname");
//        System.out.println("Use dbHostnameTW:" + dbHostnameTW);
//
//        dbPortTW = propertiesTW.getProperty("dbPortTW");
//        System.out.println("Use dbPortTW:" + dbPortTW);
//
//        dbUserTW = propertiesTW.getProperty("dbUser");
//        System.out.println("Use dbUserTW:" + dbUserTW);
//
//        dbPasswordTW = propertiesTW.getProperty("dbPort");
//        System.out.println("Use dbPasswordTW:" + dbPasswordTW);
//
//        dbSchemaTW = propertiesTW.getProperty("dbSchemaTW");
//        System.out.println("Use dbSchemaTW:" + dbSchemaTW);

    }

    @AfterMethod
    public void saveScreenshotFailureTW(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String testName = result.getMethod().getMethodName();
            System.out.println("Take screen shoot..for test:" + testName);
            BaseMethodsTW.takeScreenShotsTW(driver, testName);
        }
    }


}

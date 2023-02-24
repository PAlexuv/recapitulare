package BaseForTestingAutoK.UtilsAK;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseSetUpAK {
    protected WebDriver driver;
    protected String browserTypeAK;
    protected String hostnameAK;

    protected String dbHostnameAK;
    protected String dbPortAK;
    protected String dbUserAK;
    protected String dbPasswordAK;
    protected String dbSchemaAK;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {

        //read from the frameworkProperties.properties browser and hostname
        Properties propertiesAK = BaseMethodsAK.readPropertiesAK("src\\test\\AutoKarma\\BaseForTestingAutoK\\ResourcesAK\\frameworkAK.properties");

        hostnameAK = propertiesAK.getProperty("hostnameAK");
        System.out.println("Hostname used: " + hostnameAK);

        browserTypeAK = propertiesAK.getProperty("browser");
        if(browserTypeAK == null)
            browserTypeAK = propertiesAK.getProperty("browser");
        System.out.println("Use browser: " + browserTypeAK);
        driver = BaseMethodsAK.getBrowser(browserTypeAK);
//database
        dbHostnameAK = propertiesAK.getProperty("dbHostname");
        System.out.println("Use dbHostnameAK:" + dbHostnameAK);

        dbPortAK = propertiesAK.getProperty("dbPortAK");
        System.out.println("Use dbPortAK:" + dbPortAK);

        dbUserAK = propertiesAK.getProperty("dbUser");
        System.out.println("Use dbUserAK:" + dbUserAK);

        dbPasswordAK = propertiesAK.getProperty("dbPort");
        System.out.println("Use dbPasswordAK:" + dbPasswordAK);

        dbSchemaAK = propertiesAK.getProperty("dbSchemaAK");
        System.out.println("Use dbSchemaAK:" + dbSchemaAK);
    }

    @AfterMethod
    public void saveScreenshotFailureAK(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String testName = result.getMethod().getMethodName();
            System.out.println("Take screen shoot..for test:" + testName);
            BaseMethodsAK.takeScreenShotsAK(driver, testName);
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();
    }

}

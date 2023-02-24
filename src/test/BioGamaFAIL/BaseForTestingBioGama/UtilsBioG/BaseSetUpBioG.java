package BaseForTestingBioGama.UtilsBioG;

import BaseForTestingAutoK.UtilsAK.BaseMethodsAK;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseSetUpBioG {

    protected WebDriver driver;
    protected String browserTypeBioG;
    protected String hostnameBioG;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {

        //read from the frameworkProperties.properties browser and hostname
        Properties propertiesBioG = BaseMethodsBioG.readPropertiesBioG("src/test/BioGama/BaseForTestingBioGama/ResourcesBioG/frameworkBioG.properties");

        hostnameBioG = propertiesBioG.getProperty("hostnameBioG");
        System.out.println("Hostname used: " + hostnameBioG);

        browserTypeBioG = propertiesBioG.getProperty("browserTypeBioG");
        System.out.println("Browser used: " + browserTypeBioG);

        driver = BaseMethodsBioG.getBrowserBioG(browserTypeBioG);
    }

    @AfterMethod
    public void saveScreenshotFailureBioG(ITestResult result){
        String testName = result.getMethod().getMethodName();
        System.out.println("Take screen shoot..for test:" + testName);
        BaseMethodsBioG.takeScreenShotsBioG(driver, testName);
    }
}

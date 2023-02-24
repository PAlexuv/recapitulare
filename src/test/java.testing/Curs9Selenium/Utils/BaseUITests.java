package Curs9Selenium.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseUITests {
    protected WebDriver driver;
    String hostname;
    String browser;
    String dbHostname, dbUser, dbSchema, dbPassword, dbPort;

//    @AfterClass(alwaysRun = true)
//    public void close(){
//        if(driver!=null)
//            driver.quit();
//    }

    @BeforeClass
    public void setUpBasic() throws IOException{
        //properties
        Properties prop = UtilsBrowsersWaitScreensCookie.readProperties("src\\test\\resources\\frameworkProperties.properties.properties");

        browser=System.getProperty("browser");
        if (browser==null)
            browser=prop.getProperty("browser");
        System.out.println("Use browser: " + browser);

        hostname = System.getProperty("hostnameAK");
        System.out.println("Use hostname: " + hostname);

        dbHostname = System.getProperty("dbHostname");
        System.out.println("Use hostname: " + dbHostname);

        dbUser = System.getProperty("dbUser");
        System.out.println("Use hostname: " + dbUser);

        dbSchema = System.getProperty("dbSchema");
        System.out.println("Use hostname: " + dbSchema);

        dbPassword = System.getProperty("dbPassword");
        System.out.println("Use hostname: " + dbPassword);

        dbPort = System.getProperty("dbPort");
        System.out.println("Use hostname: " + dbPort);

        //getBrowser
        driver = UtilsBrowsersWaitScreensCookie.getDriver(browser);
    }

    protected void enterValuesOnInput(WebElement el, String value) {
        el.click();
        el.clear();
        el.sendKeys(value);
    }

    @AfterMethod
    public void saveScreenShotAtFailure(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String testName = result.getMethod().getMethodName();
            System.out.println("Take screen shoot..for test:" + testName);
            UtilsBrowsersWaitScreensCookie.takeScreenShot(driver, testName);
        }
    }
}

package deStersSelenium.Utils;

import Selenium.Util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseUITestDel {
    WebDriver driver;
    String browser;
    String hostname;

    @BeforeClass(alwaysRun = true)
    public void setUP() throws IOException {
        Properties properties = UtilsdEL.readProperties("src\\test\\resources\\framework.properties");
        browser=System.getProperty(browser);
        if(browser==null)
            //read default values from congfig file
        browser= properties.getProperty("browser");
        hostname= properties.getProperty("hostname");
        System.out.println("Use browser: " + browser);
        System.out.println("Use browser: " + hostname);
        driver= UtilsdEL.getDriver(browser);
    }
    @AfterMethod
    public void saveScreenShotAtFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            //your screenshooting code goes here
            String testName = result.getMethod().getMethodName();
            System.out.println("Take screen shoot..for test:" + testName);
            Utils.takeScreenShot(driver, testName);
        }
    }

    protected void enterValuesOnInput(WebElement el, String value) {
        el.click();
        el.clear();
        el.sendKeys(value);
    }


}

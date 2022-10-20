package Selenium.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseUITest2 {
    protected WebDriver driver;
    String browser;
    protected String hostname;
    String url;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        Properties properties = Utils.readProperties("src\\test\\resources\\framework.properties");
        browser = System.getProperty("browser");
        if(browser ==null)
        browser = properties.getProperty("browser");
        System.out.println("Use browser: " + browser);
        hostname = properties.getProperty("hostname");
        System.out.println("Use next hostname: " + hostname);

        driver = Utils.getDriver(browser);
    }

    protected void enterValuesOnInput(WebElement el, String value) {
        el.click();
        el.clear();
        el.sendKeys(value);
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

}

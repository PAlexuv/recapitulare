package BaseForTestingRahulAdvanced.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

public class BaseUtilsR {
    public static final String SCREEN_SHOOT_PATHR = "src\\test\\TestAdvanced\\baseForTestingRahul\\Resources\\ScreenshotsRahul";
    public static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;

        switch (Objects.requireNonNull(getBrowserEnumFromTringsR(browserType))) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }
        return driver;
    }
    public static BrowsersR getBrowserEnumFromTringsR(String browserType) {
        for (BrowsersR browser : BrowsersR.values()) {
            if (browserType.equalsIgnoreCase(browser.toString()))
                return browser;
        }
        System.out.println("Browser " + browserType + " is not on supported list");
        return null;
    }

    //  read from properties files
    public static Properties readProperties(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

    public static void takeScreenShot(WebDriver driver, String testName) {
        LocalDateTime currentDate = LocalDateTime.now();
        String dataTimeFormat = currentDate.format(formatter).split("\\.")[0].replaceAll(":", "");
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screnShotName = SCREEN_SHOOT_PATHR + "\\screenshot-" + testName + "-" + dataTimeFormat + ".jpeg";
        File saveFile = new File(screnShotName);
        System.out.println("Save screen shoot at path:" + screnShotName);
        try {
            FileUtils.copyFile(screenShotFile, saveFile);
        } catch (IOException e) {
            System.out.println("Cannot save screen shoots. Please investigate");
        }
    }

    public static WebElement waitForPresenceOfOneElementGeneric(WebDriver driver, long timeOut, By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by));
    }
    public static List<WebElement> waitForPresenceOfAllElementsGeneric(WebDriver driver, long timeOut, By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void printCookies(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        if (cookies.size() > 0) {
            System.out.println("The number of cookies found:" + cookies.size());
            System.out.println("Cookie Name | Cookie Value | Cookie Expire Date");
            for (Cookie c : cookies) {
                if (c.getExpiry() != null)
                    System.out.println(c.getName() + " " + "|" + " " +  c.getValue() + " " +  "|"  + " " +  c.getExpiry());
            }
        } else
            System.out.println("No cookies present");
    }

}

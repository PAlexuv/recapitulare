package Twitter.BaseForTesting.UtilsTW;

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

public class BaseMethodsTW {
    public static final String SCREENSHOT_PATH_TW= "Twitter/BaseForTesting/ResourcesTW/ScreenshotsTW";
    public static DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE_TIME;

    //  read from properties files
    public static Properties readPropertiesTW(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties propertiesTW = new Properties();
        propertiesTW.load(inputStream);
        return propertiesTW;
    }

    public static WebDriver getBrowser(String browserTypeTW) {
        WebDriver driver = null;

        switch (Objects.requireNonNull(getBrowsersTW(browserTypeTW))){
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

    public static BrowsersTW getBrowsersTW(String browserType){
        for(BrowsersTW chosenBrowser: BrowsersTW.values()){
            if(browserType.equalsIgnoreCase(chosenBrowser.toString()))
                return chosenBrowser;
        }
        System.out.println("Browser " + browserType + " is not on supported list");
        return null;
    }

    //take ScreenShots for failure
    public static void takeScreenShotsTW(WebDriver driver, String testNameTW){
        LocalDateTime currentTime = LocalDateTime.now();
        String dateTimeFormatter = currentTime.format(dateFormat).split("\\.")[0].replaceAll(":", "");
        File screenShotFileTW = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotNameTW = SCREENSHOT_PATH_TW + "\\screenshot-" + testNameTW +  "-" + dateTimeFormatter + ".jpeg";
        File saveFileTW = new File(screenShotNameTW);
        System.out.println("Save screen shoot at path:" + screenShotNameTW);
        try{
            FileUtils.copyFile(screenShotFileTW, saveFileTW);
        } catch (IOException e) {
            System.out.println("Cannot save screen shoots. Please investigate");
        }
    }

    //WAIT
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

    //COOKIES
    public static void printCookiesTW(WebDriver driver){
        Set<Cookie> cookiesTW = driver.manage().getCookies();
        if(cookiesTW.size()>0){
            System.out.println("The number of cookies found:" + cookiesTW.size());
            System.out.println("Cookie Name | Cookie Value | Cookie Expire Date");
            for(Cookie c: cookiesTW){
                if(c.getExpiry() != null)
                    System.out.println(c.getName() + " " + "|" + " " +  c.getValue() + " " +  "|"  + " " + c.getExpiry());
            }
        }else
            System.out.println("No cookies present");
    }

}

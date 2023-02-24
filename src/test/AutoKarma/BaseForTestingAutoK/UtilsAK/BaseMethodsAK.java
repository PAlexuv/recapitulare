package BaseForTestingAutoK.UtilsAK;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;


public class BaseMethodsAK {
    public static final String SCREENSHOT_PATH_AK= "BaseForTestingAutoK/ResourcesAK/ScreenShotsAK";
    public static DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE_TIME;

    //  read from properties files
    public static Properties readPropertiesAK(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties propertiesAK = new Properties();
        propertiesAK.load(inputStream);
        return  propertiesAK;
    }

    public static WebDriver getBrowser(String browserTypeAK) {
        WebDriver driver = null;

        switch (Objects.requireNonNull(getBrowsersAK(browserTypeAK))){
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
    public static BrowsersAK getBrowsersAK(String browserType){
        for(BrowsersAK chosenBrowser: BrowsersAK.values()){
            if(browserType.equalsIgnoreCase(chosenBrowser.toString()))
                return chosenBrowser;
        }
        System.out.println("Browser " + browserType + " is not on supported list");
        return null;
    }

    //take ScreenShots for failure
    public static void takeScreenShotsAK(WebDriver driver, String testNameAK){
        LocalDateTime currentTime = LocalDateTime.now();
        String dateTimeFormatter = currentTime.format(dateFormat).split("\\.")[0].replaceAll(":", "");
        File screenShotFileAK = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotNameAK = SCREENSHOT_PATH_AK + "\\screenshot-" + testNameAK +  "-" + dateTimeFormatter + ".jpeg";
        File saveFileAK = new File(screenShotNameAK);
        System.out.println("Save screen shoot at path:" + screenShotNameAK);
        try{
            FileUtils.copyFile(screenShotFileAK, saveFileAK);
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
    public static void printCookiesAK(WebDriver driver){
        Set<Cookie> cookiesAk = driver.manage().getCookies();
        if(cookiesAk.size()>0){
            System.out.println("The number of cookies found:" + cookiesAk.size());
            System.out.println("Cookie Name | Cookie Value | Cookie Expire Date");
            for(Cookie c: cookiesAk){
               if(c.getExpiry() != null)
                   System.out.println(c.getName() + " " + "|" + " " +  c.getValue() + " " +  "|"  + " " + c.getExpiry());
            }
        }else
            System.out.println("No cookies present");
    }

}

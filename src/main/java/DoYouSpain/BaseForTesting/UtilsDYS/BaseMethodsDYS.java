package DoYouSpain.BaseForTesting.UtilsDYS;

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

public class BaseMethodsDYS {

    public static final String SCREENSHOT_PATH_DYS = "C:\\Users\\alexa\\IdeaProjects\\Recapitulare\\src\\main\\java\\DoYouSpain\\BaseForTesting\\ResourcesDYS\\ScreenshotsDYS";
    public static DateTimeFormatter dateFormatDYS = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    //  read from properties files
    public static Properties readProperties(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties propertiesDYS = new Properties();
        propertiesDYS.load(inputStream);
        return propertiesDYS;
    }

    public static WebDriver getBrowser(String browserTypeDYS){
        WebDriver driver = null;
        switch (Objects.requireNonNull(getBrowsersDYS(browserTypeDYS))) {
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

        public static BrowsersDYS getBrowsersDYS(String browserType){
            for(BrowsersDYS chosenBrowser: BrowsersDYS.values()){
                if(browserType.equalsIgnoreCase(chosenBrowser.toString()))
                    return chosenBrowser;
            }
            System.out.println("Browser " + browserType + " is not on supported list");
            return null;
        }

    //take ScreenShots for failure
    public static void takeScreenShotsDYS(WebDriver driver, String testNameDYS){
        LocalDateTime currentTime = LocalDateTime.now();
        String dateTimeFormatter = currentTime.format(dateFormatDYS).split("\\.")[0].replaceAll(":", "");
        File screenShotFileDYS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotNameDYS = SCREENSHOT_PATH_DYS + "\\screenshot-" + testNameDYS +  "-" + dateTimeFormatter + ".jpeg";
        File saveFileDYS = new File(screenShotNameDYS);
        System.out.println("Save screen shoot at path:" + screenShotNameDYS);
        try{
            FileUtils.copyFile(screenShotFileDYS, saveFileDYS);
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
    public static void printCookiesDYS(WebDriver driver){
        Set<Cookie> cookiesDYS= driver.manage().getCookies();
        if(cookiesDYS.size()>0){
            System.out.println("The number of cookies found:" + cookiesDYS.size());
            System.out.println("Cookie Name | Cookie Value | Cookie Expire Date");
            for(Cookie c: cookiesDYS){
                if(c.getExpiry() != null)
                    System.out.println(c.getName() + " " + "|" + " " +  c.getValue() + " " +  "|"  + " " + c.getExpiry());
            }
        }else
            System.out.println("No cookies present");
    }
}

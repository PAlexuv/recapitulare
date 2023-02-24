package BaseForTestingBioGama.UtilsBioG;

import BaseForTestingAutoK.UtilsAK.BrowsersAK;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import static BaseForTestingBioGama.UtilsBioG.BrowsersBioG.*;

public class BaseMethodsBioG {

    public static final String SCREENSHOT_PATH_BIOG = "BaseForTestingBioGama/ResourcesBioG/ScreenShotsBioG";
    public static DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE_TIME;

    //  read from properties files
    public static Properties readPropertiesBioG(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties propertiesBioG = new Properties();
        propertiesBioG.load(inputStream);
        return propertiesBioG;
    }

    //choose browser
    public static WebDriver getBrowserBioG(String browserTypeBioG) {
        WebDriver driver = null;

        switch (Objects.requireNonNull(getBrowsersBioG(browserTypeBioG))) {
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

    public static BrowsersBioG getBrowsersBioG(String browserType) {
        for (BrowsersBioG chosenBrowser : BrowsersBioG.values()) {
            if (browserType.equalsIgnoreCase(chosenBrowser.toString()))
                return chosenBrowser;
        }
        System.out.println("Browser " + browserType + " is not on supported list");
        return null;
    }

    //take ScreenShots for failure
    public static void takeScreenShotsBioG(WebDriver driver, String testNameBioG) {
        LocalDateTime currentTime = LocalDateTime.now();
        String dateTimeFormatter = currentTime.format(dateFormat).split("\\.")[0].replaceAll(":", "");
        File screenshotFileBioG = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenShotNameBioG = SCREENSHOT_PATH_BIOG + "\\screenshot-" + testNameBioG +  "-" + dateTimeFormatter + ".jpeg";
        File saveFileBioG = new File(screenShotNameBioG);
        System.out.println("Save screen shoot at path:" + screenShotNameBioG);
        try{
            FileUtils.copyFile(screenshotFileBioG, saveFileBioG);
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
    public static WebElement waitForElementToBeClickable(WebDriver driver, long timeOut, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public static void waitForModalToBeClosed(WebDriver driver, long timeOut, By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webdriver) {
                return driver.findElements(by).size() == 0;
            }
        });
    }

    //replace Elements
    private static String replaceElements(String element, String valueToBeReplaced, String valueReplaceWith) {
        return element.replaceAll(valueToBeReplaced, valueReplaceWith);
    }
    public static String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return replaceElements(resultSet.getString(element), "''", "");
    }

    //COOKIES
    public static void printCookiesBioG(WebDriver driver){
        Set<Cookie> cookiesBioG = driver.manage().getCookies();
        if(cookiesBioG.size()>0){
            System.out.println("The number of cookies found:" + cookiesBioG.size());
            System.out.println("Cookie Name | Cookie Value | Cookie Expire Date");
            for(Cookie c: cookiesBioG){
                if(c.getExpiry() != null)
                    System.out.println(c.getName() + " " + "|" + " " +  c.getValue() + " " +  "|"  + " " + c.getExpiry());
            }
        }else
            System.out.println("No cookies present");
    }

    public static Cookie getCookie(WebDriver driver, String name) {
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

}


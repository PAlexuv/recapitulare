package AutomationIO.PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class BasePOPageAIO {
    //1: initiate webdriver, create variables for config(String) and properties(Properties)
    //2: method to load properties from config
    //3: method to Open Browser and maximize
    //4: method to Close Browser
    //5: method to Go to Homepage
    //6: method to Get a Text
    //7: method to Set a Text
    //8: method to hit TAB button

    protected static WebDriver driver;


    public String browser;
    public String baseUrl;
    public Properties properties;


    //load Properties file(private)
    private void loadProperties(){

        //to read the files we need FileInputStream
        FileInputStream fileInputStream = null;

        //if file moved from disk or unaccesable do a try catch
        try{
            properties = new Properties();
            fileInputStream = new FileInputStream("C:\\Users\\alexa\\IdeaProjects\\Recapitulare\\src\\main\\java\\AutomationIO\\Config\\config.properties");
            properties.load(fileInputStream);

            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void openBrowser(){
        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.quit();
    }
    public void closeWindow(){
        driver.close();
    }

    public Boolean goToHomePage(){
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
        }catch (Exception e){
            System.out.println("Unable to navigate to the HomePage");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getTextByValue(By locator){
        return driver.findElement(locator).getAttribute("value");
    }
    public String getTextByText(By locator){
        return driver.findElement(locator).getText();
    }

    public void setText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        tab(locator);
    }

    public void tab(By locator){
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public void click(By locator){
    driver.findElement(locator).click();
    }

    public void goBack(){
        driver.navigate().back();
    }

    public String getWindowHandle(){
        return driver.getWindowHandle();
    }
    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }
    public int getNumberOfOpenWindows(){
         return driver.getWindowHandles().size();
    }

    public void openNewTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }
    public void goToUrl(String url){
        driver.get(url);
    }

    public void dragAndDropByOffset(By locator, int x, int y){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.dragAndDropBy(element, x, y).perform();
    }

    public void dismissPopUp(){
        driver.switchTo().alert().dismiss();
    }
    public void acceptPopUp(){
        driver.switchTo().alert().accept();
    }
    public void setPopupText(String popupText){
        driver.switchTo().alert().sendKeys(popupText);
    }

    public void waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForElementText(By locator, String text){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void hoverOverElement(By locator){
        WebElement elementLocator = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementLocator).perform();
    }

    public void scrollElementIntoView(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Scroll the page by specified number of pixels
     * @param x How many pixels to scroll on x-axis(horizontal).
     * @param y How many pixels to scroll on y-axis(vertical).
     */
    public void scrollPage(int x, int y){

    }
}

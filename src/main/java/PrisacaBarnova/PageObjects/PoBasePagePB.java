package PrisacaBarnova.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PoBasePagePB {
    //1: initiate webdriver ; create variables for config(String) and properties(Properties)
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

    public void loadProperties(){
        FileInputStream fis = null;
        try{
            properties = new Properties();
            fis = new FileInputStream("C:\\Users\\alexa\\IdeaProjects\\Recapitulare\\src\\main\\java\\PrisacaBarnova\\Config\\config.properties");
            properties.load(fis);

            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openBrowserMaximize(){
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }
    public void closeBrowser(){
        driver.quit();
    }

    public Boolean goToHomepage(){
        try{
            loadProperties();
            openBrowserMaximize();
            driver.get(baseUrl);
        }catch (Exception e){
            System.out.println("couldn't get to homepage");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getText(By locator){
        //6: method to Get a Text only locator - return String - either that we entered from keyboard or exist already
        //get text By locator - locating through selectors
        //use IF statement to cover both situations when WE HAVE the text and when WE INPUT the text
        // 6.1: use a STRING VALUE to get the text  .getText
        // 6.2: use if after String our STRING VALUE is empty - nothing to show - return getAttribute to get the text VALUE from locator
        // 6.3: else return the String found text in .getText
        String displayedText = driver.findElement(locator).getText();
        if(displayedText.isEmpty()){
           return driver.findElement(locator).getAttribute("value");
        }else{
            return displayedText;
        }
    }
    //7: method to Set a Text
    //using the LOCATOR to locate where to set the text and a String to set the TEXT to input
    //7.1 after locating the locator clear the field to input text
    //7.2 after cleanup send the TEXT to the located field
    //7.3 use tab key to navigate away from locator(use tab method)
    public void setText(By locator, String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        tabKey(locator);
    }
    public void tabKey(By locator){
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
}

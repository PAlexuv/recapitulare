package try1.PageObjects;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class try1PoBasePage {
    //1: initiate webdriver create variables for config(String) and properties(Properties)
    //2: method to load properties from config
    //3: method to Open Browser and maximize
    //4: method to Close Browser
    //5: method to Go to Homepage
    //6: method to Get a Text
    //7: method to Set a Text
    //8: method to hit TAB button



    //1: initiate webdriver create variables for config(String) and properties(Properties)
    protected static WebDriver driver;

    public String browser;
    public String baseUrl;
    public Properties properties;

    //2: method to load properties from config
    // load properties method
    // to read the file we use FileInputStream
    // -fis- we set it on NULL so our created variable does not contain anything inside but later on try we fill it with the new FileInputStream("...")
    // in try catch: get new properties use new Properties to prepare the method for a new property -> get new fis - new FileInputStream -> load to properties the new fis
    // attribute to variables browser and baseUrl the data from config using properties.getproperty with the loaded properties from config
    // catch why file wasn't opened: not found and IOException
    // very important(finally): if the file is NOT found we must CLOSE the FileInputStream before our program ends fis.close()
    // use try/catch just in case an error occur during the closing process
    public void loadProperties() {
    FileInputStream fis = null;
    try {
        properties = new Properties();
        fis = new FileInputStream("C:\\Users\\alexa\\IdeaProjects\\Recapitulare\\src\\main\\java\\try1\\Config\\config.properties");
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

//3: method to Open Browser
    //use if for browser variable to load chromedriver or what we want it to load
    public void openBrowserandMax(){
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

//4: method to Close Browser
    public void closeBrowser(){
        driver.quit();
    }

//5: method to Go to Homepage
    //use try/catch just in case homepage won't open
    //5.1: load properties (method) to know what browser and what url to use to get to homepage
    //5.2: open the browser and maximize
    //5.3: open url
    //5.4: catch the errors in case we cannot go to homepage - use Exception e = general exception
    //   we return FALSE inside catch if error and TRUE outside catch if all ok
    public Boolean goToHomepage(){

       try{
           loadProperties();
           openBrowserandMax();
           driver.get(baseUrl);
       }catch (Exception e){
           System.out.println("Couldn't access the Homepage");
           e.printStackTrace();
           return false;
       }
       return true;
    }

  //6: method to Get a Text - return String - either that we entered from keyboard or exist already
    //get text By locator - locating through selectors the text
    //use IF statement to cover both situations when WE HAVE the text and when WE INPUT the text
    // 6.1: use a STRING VALUE to get the text  .getText
    // 6.2: if our STRING VALUE is empty - nothing to show - return getAttribute to get the text VALUE from locator
    // 6.3: else return the String found text in .getText
    public String getText(By locator){
        String displayedText = driver.findElement(locator).getText();
        if(displayedText.isEmpty()) {
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
        tab(locator);
    }

    //8: method to hit TAB button
    //move from the locator with TAB Key(s) -sendkeys-
    public void tab(By locator){
        driver.findElement(locator).sendKeys(Keys.TAB);
    }


}

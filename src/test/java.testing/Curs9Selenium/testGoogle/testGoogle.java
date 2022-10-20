package Curs9Selenium.testGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Selenium.Util.BaseUITest2;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class testGoogle extends BaseUITest2 {
    String url = "https://www.google.com/";

    @BeforeMethod(alwaysRun = true)
    public void closeBrowserAfterRun() {
        if (driver != null)
            driver.close();
    }

    @Test
    public void testSearchBarChrome(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get(url);

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        acceptCookies.click();
        WebElement searchBar = driver.findElement(By.cssSelector("input[title='Căutați']"));
        searchBar.click();
        searchBar.sendKeys("teren vanzare palas iasi", Keys.ENTER);

//count how many websites pages were found on first google search page
        List<WebElement> listOfResults=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".yuRUbf")));
        System.out.println("Numbers of found websites: " + listOfResults.size());
//---------------------------------

//show names of the pages found on first google search page
        List<WebElement>nameOfFirstPageFounds = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".LC20lb.MBeuO.DKV0Md")));
        System.out.println("Name of first google page items found: " + nameOfFirstPageFounds.size());

        for (WebElement we : nameOfFirstPageFounds)
        {
            System.out.println(we.getText());
            WebElement resultUrl = we.findElement(By.xpath("//h3[normalize-space()='Teren Palas - Terenuri în Iasi - OLX.ro']"));
            String url = resultUrl.getAttribute("href");
            System.out.println(url);
        }
        driver.navigate().to("http://google.com");
        driver.navigate().back();
//        driver.quit();
    }



}
//    @Test
//    public void testSearchBarFirefox(){
//System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
//        driver= new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//
//        driver.get(url);
//
//        WebElement acceptCookie = driver.findElement(By.id("L2AGLb"));
//        acceptCookie.click();
//
//        WebElement searchBar = driver.findElement(By.cssSelector("input[title='Căutați']"));
//        searchBar.click();
//        searchBar.sendKeys("fuerteventura", Keys.ENTER);
//
//        //count how many websites pages were found on first google search page
//        List<WebElement> howManyPages = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".yuRUbf")));
//        System.out.println("nr of firefox's first pages: " + howManyPages.size());
//        //--------------------
//
//        //show names of the pages found on first google search page
//        List<WebElement>nameOfPages = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".LC20lb MBeuO DKV0Md")));
//        for(WebElement names: nameOfPages){
//            System.out.println(names.getText());
////            WebElement namesOfPages = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
////            String url = namesOfPages.getAttribute("href");
////            System.out.println(url);
//        }
//    }
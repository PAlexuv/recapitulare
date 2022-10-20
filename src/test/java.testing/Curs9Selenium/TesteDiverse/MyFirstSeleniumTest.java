package Curs9Selenium.TesteDiverse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MyFirstSeleniumTest {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void myFirstChromeTest(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement acceptChromeCookie = driver.findElement(By.id("L2AGLb"));
        acceptChromeCookie.click();
        WebElement searchBAr = driver.findElement(By.xpath("//input[@name='q']"));
        searchBAr.click();
        searchBAr.clear();
        searchBAr.sendKeys("flori" + Keys.ENTER);

        System.out.println("titlul site-ului: " + driver.getTitle());
        List<WebElement> listOfResults = driver.findElements(By.cssSelector(".G32ulc"));
        System.out.println("Lista rezultate: " + listOfResults);
    }
    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void myFirstFirefoxDriverTest() {
        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        WebElement acceptCookiesButton = driver.findElement(By.cssSelector("#L2AGLb > div:nth-child(1)"));
        acceptCookiesButton.click();
        WebElement searchInput = driver.findElement(By.name("q"));
//      scriem in inputul de search
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("flori", Keys.ENTER);

        wait = new WebDriverWait(driver, 10);
        System.out.println("Titlu site:" + driver.getTitle());

        List<WebElement> listOfResults = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#rcnt")));
//        List<WebElement> promoteListOfResults = wait.until(
//                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.v5yQqb")));

        System.out.println("Numar de rezultate gasite:" + (listOfResults.size()));//(listOfResults.size() + promoteListOfResults.size())
    }


}

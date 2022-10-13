package Curs9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MyFirstSeleniumTest {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void myFirstFirefoxTest(){

        driver = new FirefoxDriver();
        driver.get("https://www.google.ro/");
        WebElement acceptCookiesButton = driver.findElement(By.cssSelector("button[id='L2AGLb'] div[role='none']"));
        acceptCookiesButton.click();
        WebElement searchBar  = driver.findElement(By.name("q"));
        //input data in search field
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys("Selenium", Keys.ENTER);
//        wait = new WebDriverWait(driver, 10);
        System.out.println("titlu site:" + driver.getTitle());

        List<WebElement> listOfResults = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.yuRUbf")));
        List<WebElement> promoteListOfResults = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.v5yQqb")));

        System.out.println("Numar de rezultate gasite:" + (listOfResults.size() + promoteListOfResults.size()));
    }

    }

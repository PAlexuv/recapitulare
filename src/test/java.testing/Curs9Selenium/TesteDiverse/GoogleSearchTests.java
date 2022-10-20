package Curs9Selenium.TesteDiverse;

import Curs9Selenium.Utils.BaseUITests;
import Curs9Selenium.Utils.UtilsBrowsersWaitScreensCookie;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchTests extends BaseUITests {
    String url = "https://www.google.com/";

    @BeforeMethod(alwaysRun = true)
    public void closeBrowserAfterRun() {
        if (driver != null)
            driver.close();
    }

    @DataProvider(name = "browserDataProvider")
    public Object[][] browserDataProvider() {
        return new Object[][]{
                {"chrome", 11},
//                {"firefox", 11},
//                {"edge", 11}
        };
    }
    @Test(dataProvider = "browserDataProvider")
    public void testGoogleSearchParameters(String browserType, Integer expectedResults) {
        driver = UtilsBrowsersWaitScreensCookie.getDriver(browserType);
        driver.get(url);
    }
    //de aici in jos e testul sus e legat de dataprovider

    @Test(dataProvider = "browserDataProvider")
    public void searchOnGoogleTests(String browserType, Integer expectedResults) {
        driver = UtilsBrowsersWaitScreensCookie.getDriver(browserType);
        driver.get(url);

        WebElement acceptCookiesButton = UtilsBrowsersWaitScreensCookie.waitForPresenceOfElementGeneric(driver, 15, By.xpath("//button[@id='L2AGLb']/div"));
        acceptCookiesButton.click();
        WebElement searchInput = UtilsBrowsersWaitScreensCookie.waitForPresenceOfElementGeneric(driver, 15, By.name("q"));
//      scriem in inputul de search
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("flori", Keys.ENTER);

//      afisam titlul site-ului
        System.out.println("Titlu site:" + driver.getTitle());

        List<WebElement> listOfResults = UtilsBrowsersWaitScreensCookie.waitForPresenceOfAllElementsGeneric(driver, 15, By.cssSelector("div.yuRUbf"));
        List<WebElement> promoteListOfResults = UtilsBrowsersWaitScreensCookie.waitForPresenceOfAllElementsGeneric(driver, 15, By.cssSelector("div.v5yQqb"));
        System.out.println("Numar de rezultate gasite:" + (listOfResults.size() + promoteListOfResults.size()));
        Assert.assertEquals(listOfResults.size() + promoteListOfResults.size(), expectedResults, 0);

    }
}

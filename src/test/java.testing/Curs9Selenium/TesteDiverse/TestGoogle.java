package Curs9Selenium.TesteDiverse;

import Curs9Selenium.Utils.BaseUITests;
import Curs9Selenium.Utils.UtilsBrowsersWaitScreensCookie;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestGoogle extends BaseUITests {
    String url = "https://www.google.com";
    WebDriverWait wait;

    @DataProvider(name = "data-provider")
    public Object[][] browserTypes() {
        return new Object[][]{
                {"chrome", 11},
                {"firefox", 11}
        };
    }
    @Test(dataProvider = "data-provider")
    public void testSearchBar(String browserType, Integer expectedResults){

        driver = UtilsBrowsersWaitScreensCookie.getDriver(browserType);
        driver.get(url);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, 5);

    }
}

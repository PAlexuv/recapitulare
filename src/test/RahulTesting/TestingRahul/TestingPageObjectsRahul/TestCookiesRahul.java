package TestingRahul.TestingPageObjectsRahul;

import BaseForTestingRahul.Utils.BaseMethodsUtils;
import BaseForTestingRahul.Utils.BaseSetUp;
import TestingRahul.PageObjectsRahul.PoCookies;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCookiesRahul extends BaseSetUp {


    @Test
    public void cookiesTest(){
        driver.get(hostname);

        PoCookies cookies = new PoCookies(driver);
        cookies.cookieMethods();
//        PoCookies.printCookies(driver);

    }
}

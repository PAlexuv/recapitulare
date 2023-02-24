package Testing.TestPageObjects;

import baseForTesting.Utils.baseSetUp;
import baseForTesting.Utils.baseUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Testing.DataBase.dataBaseLoginDouglas;
import Testing.PageObjects.LoginPagePoDouglas;

public class TestLogin extends baseSetUp {

    @Test(dataProvider = "positiveLoginData", dataProviderClass = dataBaseLoginDouglas.class)

    public void positiveLogin(String browserType, String username, String password) throws InterruptedException {
        driver = baseUtils.getDriver(browserType);
//        driver.get(hostnameDouglas);
        driver.manage().window().maximize();

        LoginPagePoDouglas loginPage = new LoginPagePoDouglas(driver);
        loginPage.openWebsite(hostnameDouglas);
        loginPage.loginEl(username, password);
    }

    @Test(dataProvider = "negativeLoginData", dataProviderClass = dataBaseLoginDouglas.class)
    public void negativeLogin(String browserType, String username, String password) throws InterruptedException {
        driver = baseUtils.getDriver(browserType);
        driver.manage().window().maximize();

        LoginPagePoDouglas loginPage = new LoginPagePoDouglas(driver);
        loginPage.openWebsite(hostnameDouglas);
        loginPage.loginEl(username, password);
    }

    @BeforeClass(alwaysRun = true)
    public void closeBrowserAfterRun() {
        if (driver != null)
            driver.close();
    }
}

package Selenium.Csel.pageObjects;

import Selenium.BselLoginAssert.LoginTestDatabasePositiveAssert;
import Selenium.Util.BaseUITest2;
import Selenium.Util.Utils;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestsLoginPagePO extends BaseUITest2 {


    @Test(dataProvider = "positiveLoginDataProvider", dataProviderClass = DataBase.class)
    public void positiveLoginDataProvider(String browserType, String username, String password) {
        //choose browser
        driver = Utils.getDriver(browserType);
        //open website
        LoginPagePO loginPagePO = new LoginPagePO(driver);
        loginPagePO.openLoginPage(hostname);

        //login
        loginPagePO.login(username, password);
        System.out.println("Login button was pressed");

        Assert.assertEquals(loginPagePO.loggedIn.getText(), "Logged In Successfully");
        System.out.println("logged in text: " + loginPagePO.loggedIn.getText());
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("log out button is displayed: " + loginPagePO.logOutButton.isDisplayed());
    }

    @Test(dataProvider = "negativeLoginDataProvider", dataProviderClass = DataBase.class)
    public void negativeLoginDataProvider(String browserType, String username, String password, String expectedUsernameErr, String expectedPasswordErr) {
        driver = Utils.getDriver(browserType);
        driver.get(hostname);

        LoginPagePO loginPagePO = new LoginPagePO(driver);
        loginPagePO.login(username, password);
//        loginPagePO.waitPassErr();
        System.out.println(loginPagePO.usernameErr.getText());
        System.out.println(loginPagePO.passwordErr.getText() + "\n");

        Assert.assertEquals(expectedUsernameErr, "Your username is invalid!");
        Assert.assertEquals(expectedPasswordErr, "Your password is invalid!");

        //assert pentru element lipsa
//        Assert.assertTrue(loginPagePO.checkErr(expectedUsernameErr, "userErr"));
//        Assert.assertTrue(loginPagePO.checkErr(expectedPasswordErr, "passErr"));
    }
    @BeforeMethod(alwaysRun = true)
    public void closeBrowserAfterRun() {
        if (driver != null)
            driver.close();
    }
}

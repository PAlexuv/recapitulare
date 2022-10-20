package Selenium.BselLoginAssert;

import Selenium.Util.BaseUITest2;
import Selenium.Util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestDatabasePositiveAssert extends BaseUITest2 {

    @DataProvider(name = "positiveLoginDataProvider")
    public Object[][] positiveLoginDataProvider() {
        return new Object[][]{
                {"chrome", "student", "Password123"}
//                {"firefox", "student", "Password123", "Username is required!", "Password is required!"},
//                {"edge", "student", "Password123", "Username is required!", "Password is required!"},
        };
    }
    @Test(dataProvider = "positiveLoginDataProvider")
    public void positiveLoginDataProvider(String browserType, String username, String password) {
        driver = Utils.getDriver(browserType);
        driver.get(hostname);

        WebElement usernameEl = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#username"));
        WebElement passwordEl = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#password"));
        WebElement buttonSubmit = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.xpath("//button[@id='submit']"));

        enterValuesOnInput(usernameEl, username);
        enterValuesOnInput(passwordEl, password);
        buttonSubmit.click();

        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
    }

//    @DataProvider(name = "negativeLoginDataProvider")
//    public Object[][] negativeLoginDataProvider() {
//        return new Object[][]{
//                {"chrome", "", "", "Username is required!", "Password is required!"},
//                {"firefox", "test", "", "", "Password is required!"},
//                {"edge", "", "123TEst", "Username is required!", ""},
//                {"chrome", "student", "Password123", "", ""}
//        };
//    }
//
//    @Test(dataProvider = "negativeLoginDataProvider")
//    public void testNegativeLogin(String browserType, String username, String password,
//                                  String expectedUsernameErr, String expectedPassErr) {
//        driver = Utils.getDriver(browserType);
//        driver.get(hostname + "#/login");

////identify elements, use Utils method for timeout
//        WebElement usernameEl = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#username"));
//        WebElement passwordEl = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#password"));
//        WebElement buttonSubmit = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#submit"));

////use method from baseUI - enterValuesOnInput - click clear sendkeys for input data wich we get from databse (Object[][])
//        enterValuesOnInput(usernameEl, username);
//        enterValuesOnInput(passwordEl, password);
//        buttonSubmit.submit();

////get error messages if we don't input data or if we get icorrect data
//        WebElement usernameErr = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#error"));
//        WebElement passwordErr = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#error"));

////confirm errors
//        Assert.assertEquals(expectedUsernameErr, usernameErr.getText());
//        Assert.assertEquals(expectedPassErr, passwordErr.getText());
//    }

@BeforeMethod(alwaysRun = true)
public void closeBrowserAfterRun() {
    if (driver != null)
        driver.close();
}
}
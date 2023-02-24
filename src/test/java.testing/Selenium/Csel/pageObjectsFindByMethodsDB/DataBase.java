package Selenium.Csel.pageObjectsFindByMethodsDB;

import Selenium.Util.BaseUITest2;
import org.testng.annotations.DataProvider;

public class DataBase extends BaseUITest2 {
    @DataProvider(name = "positiveLoginDataProvider")
    public Object[][] positiveLoginDataProvider() {
        return new Object[][]{
                {"chrome", "student", "Password123"},
                {"firefox", "student", "Password123"}
        };
    }

    @DataProvider(name = "negativeLoginDataProvider")
    public Object[][] negativeLoginDataProvider() {
        return new Object[][]{
                {"chrome", " ", "Password123", "Your username is invalid!", "Your password is invalid!"},
                {"chrome", "student", "", "Your username is invalid!", "Your password is invalid!"},
                {"firefox", "student", "", "Your username is invalid!", "Your password is invalid!"}
        };
    }
}

package Testing.DataBase;

import baseForTesting.Utils.baseSetUp;
import org.testng.annotations.DataProvider;

public class dataBaseLoginDouglas extends baseSetUp {
    @DataProvider(name = "positiveLoginData")
    public Object[][] positiveLoginData(){
            return new Object[][]{
                    {"chrome", "user@yahoo.com", "password"},
            };
    }

    @DataProvider(name = "negativeLoginData")
    public Object[][] negativeLoginData(){
        return new Object[][]{
                {"chrome", "user...", "password..."},
        };
    }
}

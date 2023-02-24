package TestingAutoK.TestingPageObjectsAK;

import TestingAutoK.DataBase.dataBaseLoginAK;
import BaseForTestingAutoK.UtilsAK.BaseMethodsAK;
import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import TestingAutoK.PageObjectsAK.PoLoginAK;
import org.testng.annotations.Test;

public class testLoginAK extends BaseSetUpAK {

    @Test(dataProviderClass = dataBaseLoginAK.class, dataProvider = "PosLoginAK")
    public void testPositiveLogin(String browserTypeAK, String usernameAK, String passwordAK){

        driver= BaseMethodsAK.getBrowser(browserTypeAK);
        driver.get(hostnameAK);

        PoLoginAK loginAK = new PoLoginAK(driver);
//        loginAK.loginMethodAK(usernameAK, passwordAK);
    }

    @Test(dataProviderClass = dataBaseLoginAK.class, dataProvider = "NegLoginAK")
    public void testNegativeLogin(String browserTypeAK, String usernameAK, String passwordAK, String expectedUserErr, String expectedPassErr){

        driver = BaseMethodsAK.getBrowser(browserTypeAK);
        driver.get(hostnameAK);

        // intantiate and use methods from page objects page
        PoLoginAK loginAK = new PoLoginAK(driver);
//        loginAK.loginMethodAK(usernameAK, passwordAK);
        loginAK.checkErrLogin(expectedUserErr, "userErr");
        loginAK.checkErrLogin(expectedPassErr, "passErr");

//        Assert.assertEquals(expectedUserErr, "Date de autentificare incorecte!");
//        Assert.assertTrue(loginAK.checkErr(expectedUserErr, "userErr"));
//        Assert.assertTrue(loginAK.checkErr(expectedPassErr, "passErr"));
    }
}


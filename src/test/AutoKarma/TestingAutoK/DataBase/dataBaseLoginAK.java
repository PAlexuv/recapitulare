package TestingAutoK.DataBase;

import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import org.testng.annotations.DataProvider;

public class dataBaseLoginAK extends BaseSetUpAK {

    @DataProvider(name = "PosLoginAK")
    public Object[][] positiveLoginAK(){
        return new Object[][]{
                {"chrome", "utilizator@yahoo.com", "parola"}
        };
    }

    @DataProvider(name = "NegLoginAK")
    public Object[][] negativeLoginAK(){
        return new Object[][]{
                {"chrome","+++utilizator", "1", "Date de autentificare incorecte!", "Date de autentificare incorecte!"}
        };
    }


}


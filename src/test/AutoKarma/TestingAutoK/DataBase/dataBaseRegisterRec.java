package TestingAutoK.DataBase;

import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import org.testng.annotations.DataProvider;

public class dataBaseRegisterRec {

    @DataProvider(name = "PositiveRecap")
    public Object[][] positiveRecapRegister() {
        return  new Object[][]
                {
                        { "chrome", "testNume", "testPrenume", "testEmail@email.com", "0789456754",
                        "stefan cel mare 21",  "700552", "testareParola", "testareParola"}
                };
    }

    @DataProvider(name = "NegativeRecap")
    public Object[][] negativeRecapRegister(){
        return new Object[][]{
                {
                  "chrome","", "", "Numele contine intre 3 si 32 de caractere!", "Prenumele contine intre 3 si 32 de caractere!"
                }
        };
    }

}

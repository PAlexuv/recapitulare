package TestingAutoK.DataBase;

import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import org.testng.annotations.DataProvider;

public class DataBaseRegisterAK extends BaseSetUpAK {

    @DataProvider(name = "PosRegisterAK")
    public Object[][] positiveRegisterAK(){
        return new Object[][]{
                {"chrome", "testNume", "testPrenume", "testEmail@email.com", "0789456754",
                 "stefan cel mare 21",  "880989", "testareParola", "testareConfirmareParola"}
        };
    }

    @DataProvider(name = "NegRegisterAK")
    public Object[][] negativeRegisterAK(){
        return new Object[][]{
                {"chrome","", "", "Numele contine intre 3 si 32 de caractere!", "Prenumele contine intre 3 si 32 de caractere!"}
        };
    }
}

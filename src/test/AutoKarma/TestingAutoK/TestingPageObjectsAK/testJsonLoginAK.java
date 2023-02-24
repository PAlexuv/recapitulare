package TestingAutoK.TestingPageObjectsAK;

import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import TestingAutoK.PageObjectsAK.PoModels.JsonLoginDpAK;
import TestingAutoK.DataBase.ObjectModels.LoginModelAK;
import org.testng.annotations.Test;

public class testJsonLoginAK extends BaseSetUpAK {

    @Test(dataProvider = "jsonDpAK", dataProviderClass = JsonLoginDpAK.class)
    public void testJsonLogin(LoginModelAK lm){

        JsonLoginDpAK jsonDbLogin = new JsonLoginDpAK();

//        jsonDbLogin.loginJsonAK(LoginModelAK lm);
    }


//    @Test(dataProvider =  "jsonDpAK")
//    public void loginJsonAK(LoginModel lm){
//        printData(lm);
//        loginActions(lm);
//    }
}

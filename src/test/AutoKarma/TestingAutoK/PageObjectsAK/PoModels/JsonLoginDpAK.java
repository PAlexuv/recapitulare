package TestingAutoK.PageObjectsAK.PoModels;

import BaseForTestingAutoK.UtilsAK.BaseMethodsAK;
import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import TestingAutoK.DataBase.ObjectModels.LoginModelAK;
import TestingAutoK.PageObjectsAK.PoLoginAK;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JsonLoginDpAK extends BaseSetUpAK {

    PoLoginAK poLoginAK;

    @BeforeMethod
    public void initializePages() {
        poLoginAK = new PoLoginAK(driver);
        poLoginAK.openAKPage(hostnameAK);
    }

    @DataProvider(name = "jsonDpAK")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
        //starting deserialization of json into LoginModel object
        ObjectMapper mapper = new ObjectMapper();

        File f = new File("src/test/AutoKarma/TestingAutoK/DataBase/DataProviders/testdata.json");

        LoginModelAK lm = mapper.readValue(f, LoginModelAK.class);

        dp.add(new Object[]{lm});
        return dp.iterator();
        }

    public void loginJsonAK(LoginModelAK lm){
        printData(lm);
        loginInputData(lm);
    }
    private void printData(LoginModelAK lm) {
        System.out.println("Account.nume:" + lm.getAccount().getUsername());
        System.out.println("Account.prenume:" + lm.getAccount().getPassword());

        System.out.println("================REGISTRATION FIELD ERRORS==============");
        System.out.println("nume error:" + lm.getUserErr());
        System.out.println("pass error:" + lm.getPasswordErr());

    }
    public void loginInputData(LoginModelAK lm){
        PoLoginAK poLoginAK = new PoLoginAK(driver);
        poLoginAK.openAKPage(hostnameAK);
        poLoginAK.loginActionsAK();
        poLoginAK.enterLoginInputsAK ( (lm.getAccount().getUsername()), lm.getAccount().getPassword() );
    }

}


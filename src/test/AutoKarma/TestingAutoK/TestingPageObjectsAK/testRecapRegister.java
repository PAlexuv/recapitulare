package TestingAutoK.TestingPageObjectsAK;

import BaseForTestingAutoK.UtilsAK.BaseMethodsAK;
import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import TestingAutoK.DataBase.dataBaseRegisterRec;
import TestingAutoK.PageObjectsAK.PoRecapRegister;
import org.testng.annotations.Test;

public class testRecapRegister extends BaseSetUpAK {

    @Test()
    public void testActions() throws InterruptedException {

//        driver = BaseMethodsAK.getBrowser(browserTypeAK);
//        driver.get(hostnameAK);

        PoRecapRegister recapRegister = new PoRecapRegister(driver);
        recapRegister.registerActions();
    }

    @Test(dataProviderClass = dataBaseRegisterRec.class , dataProvider = "PositiveRecap")
    public void testPositive(String browserTypeAK, String nume, String prenume, String email, String phone, String strada, String codPostal, String parola, String confirmareParola ) throws InterruptedException {

        driver = BaseMethodsAK.getBrowser(browserTypeAK);
        driver.get(hostnameAK);

        PoRecapRegister recapRegister = new PoRecapRegister(driver);
        recapRegister.registerActions();
        recapRegister.posRegisterRecap(nume, prenume, email, phone, strada, codPostal, parola, confirmareParola);


    }

}

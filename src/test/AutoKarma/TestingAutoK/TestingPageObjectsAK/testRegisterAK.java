package TestingAutoK.TestingPageObjectsAK;

import BaseForTestingAutoK.UtilsAK.BaseMethodsAK;
import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import TestingAutoK.DataBase.DataBaseRegisterAK;
import TestingAutoK.PageObjectsAK.PoRegisterPageAK;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testRegisterAK extends BaseSetUpAK {

    @Test()
    public void testNegativeRegistration() {

        driver= BaseMethodsAK.getBrowser(browserTypeAK);
        driver.get(hostnameAK);

        PoRegisterPageAK registerAK = new PoRegisterPageAK(driver);
        registerAK.registerPageActionsAK();
    }

    // ******************** TESTARE POZITIVA ********************
//    @Test(dataProviderClass = DataBaseRegisterAK.class , dataProvider = "PosRegisterAK")
//    public void testPositiveRegistration(String browserTypeAK, String numeInp, String prenumeInp, String emailInp, String phoneInp, String stradaInp, String codPostalInp,
//                                         String parolaInp, String confirmareParolaInp){
//
//        driver= BaseMethodsAK.getBrowser(browserTypeAK);
//        driver.get(hostnameAK);
//
//        PoRegisterPage registerAK = new PoRegisterPage(driver);
//        registerAK.registrationPageAK(numeInp, prenumeInp, emailInp, phoneInp, stradaInp,  codPostalInp, parolaInp, confirmareParolaInp);

        // ************* SAU preluam metoda pentru toate metodele one to rule all************

//    @Test(dataProviderClass = DataBaseRegisterAK.class , dataProvider = "PosRegisterAK")
//    public void testPositiveRegistration(String browserTypeAK, String nume, String prenume, String email, String phone, String strada, String codPostal,
//                                         String parola, String confirmareParola){
//
//        driver= BaseMethodsAK.getBrowser(browserTypeAK);
//        driver.get(hostnameAK);
//
//        PoRegisterPageAK registerAK = new PoRegisterPageAK(driver);
//        registerAK.registerPageActionsAK();
//        registerAK.PosRegistrationPageAK(nume, prenume, email, phone, strada, codPostal, parola, confirmareParola);
//    }

    //, String email, String phone, String strada,
    //                                         String codPostal, String parola, String confirmareParola,
    //                                         String numeInpErr, String prenumeInpErr, String emailInpErr, String phoneInpErr,
    //                                         String stradaInpErr, String codPostalInpErr,String parolaInpErr, String confirmareParolaInpErr

/*
    @Test(dataProviderClass = DataBaseRegisterAK.class , dataProvider = "NegRegisterAK")
    public void testNegativeRegistration(String browserTypeAK, String nume, String prenume, String numeInpErr, String prenumeInpErr) {

        driver= BaseMethodsAK.getBrowser(browserTypeAK);
        driver.get(hostnameAK);

        PoRegisterPageAK registerAK = new PoRegisterPageAK(driver);
        registerAK.registerPageActionsAK();
        registerAK.NegRegistrationPageAK(nume, prenume, numeInpErr, prenumeInpErr);
        registerAK.checkErrRegister(numeInpErr, "numeErr");
        registerAK.checkErrRegister(prenumeInpErr, "prenumeErr");

    }
*/

}

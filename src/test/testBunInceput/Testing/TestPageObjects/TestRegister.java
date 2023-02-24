package Testing.TestPageObjects;

import baseForTesting.Utils.baseSetUp;
import baseForTesting.Utils.baseUtils;
import org.testng.annotations.Test;
import Testing.DataBase.dataBaseRegisterDouglas;
import Testing.PageObjects.RegisterPagePoDouglas;

public class TestRegister extends baseSetUp {

    @Test(dataProvider = "positiveRegisterData", dataProviderClass = dataBaseRegisterDouglas.class)
    public void positiveRegister(String browserType, String firstName, String lastName, String eMail, String password, String phone,
                                 String streetAndNumber, String zipCode, String city) throws InterruptedException {
        driver = baseUtils.getDriver(browserType);
        driver.manage().window().maximize();

        RegisterPagePoDouglas registerPage = new RegisterPagePoDouglas(driver);
        registerPage.openWebsite(hostnameDouglas);
        registerPage.registerPageEl(firstName, lastName, eMail, password, phone, streetAndNumber, zipCode, city);
    }

}


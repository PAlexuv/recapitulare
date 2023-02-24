package TestingBioGama.TestingPoBioG;

import BaseForTestingBioGama.UtilsBioG.BaseMethodsBioG;
import TestingBioGama.PageObjectsBioG.PoRegistrationBioG;
import org.testng.annotations.BeforeMethod;

public class testTegistrationBioG extends BaseMethodsBioG {

    PoRegistrationBioG poRegistrationBioG;

    @BeforeMethod
    public void initializePages() {
        poRegistrationBioG = new PoRegistrationBioG();
//        poRegistrationBioG.openRegistrationPage(hostname);
    }

}

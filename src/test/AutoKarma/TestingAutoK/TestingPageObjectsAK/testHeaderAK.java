package TestingAutoK.TestingPageObjectsAK;

import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import TestingAutoK.PageObjectsAK.PoHeaderAK;
import org.testng.annotations.Test;

public class testHeaderAK extends BaseSetUpAK {

    @Test
    public void testHeader() {
        driver.get(hostnameAK);

        PoHeaderAK header = new PoHeaderAK(driver);
        header.testHeader();
    }

}

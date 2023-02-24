package TestingRahul.TestingPageObjectsRahul;

import TestingRahul.PageObjectsRahul.RadioButSelectDropdwnCheckBoxPO;
import BaseForTestingRahul.Utils.BaseSetUp;
import org.testng.annotations.Test;

public class TestRadioBChBoxAutocomDropDwnSelect extends BaseSetUp {

    @Test
    public void testFirstRowElements() {
        driver.get(hostname);
//        driver.manage().window().maximize(); nu e necesar, facut in basePO

        RadioButSelectDropdwnCheckBoxPO PORadioButSelectDropdwnCheckBox = new RadioButSelectDropdwnCheckBoxPO(driver);
        PORadioButSelectDropdwnCheckBox.testPage();
    }
}

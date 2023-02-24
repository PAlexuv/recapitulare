package TestingRahulAdvanced.TestPageObjects;

import TestingRahulAdvanced.PageObjects.AlertPO;
import TestingRahulAdvanced.PageObjects.HoverPagePO;
import BaseForTestingRahulAdvanced.Utils.BaseSetUpR;
import BaseForTestingRahulAdvanced.Utils.BaseUtilsR;
import org.testng.annotations.Test;

public class TestAdvanced extends BaseSetUpR {

    @Test
    public void showAlertText() {

        driver = BaseUtilsR.getDriver("chrome");
        driver.manage().window().maximize();

        AlertPO alertPO = new AlertPO(driver);

        alertPO.openWebsite(hostname);
//        alertPO.showAlertTerxtandAccept();
//        alertPO.showAlertTerxtandDismiss();
        alertPO.showAlertTextandInputText();
    }

    @Test
    public void selectValueFromHoverDropdown(){
//        driver = BaseUtilsR.getDriver("chrome");
        driver.get(hostname);
        driver.manage().window().maximize();

        HoverPagePO hoverPagePO = new HoverPagePO(driver);
        hoverPagePO.selectValueFromHoverDropdown();


    }
}

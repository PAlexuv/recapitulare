package TestingRahulAdvanced.DelTestiingPages;

import TestingRahulAdvanced.DelPageObjects.HoverPagePODel;
import BaseForTestingRahulAdvanced.Utils.BaseSetUpR;
import org.testng.annotations.Test;

public class TestingDel extends BaseSetUpR {
    @Test
    public void testHover(){
        driver.get(hostname);
        HoverPagePODel hoverPagePODel = new HoverPagePODel(driver);
        hoverPagePODel.useHover();
    }

}

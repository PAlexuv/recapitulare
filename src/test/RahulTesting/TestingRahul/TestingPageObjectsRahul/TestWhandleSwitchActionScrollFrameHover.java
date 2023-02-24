package TestingRahul.TestingPageObjectsRahul;

import BaseForTestingRahul.Utils.BaseSetUp;
import TestingRahul.PageObjectsRahul.GetWHandleSwitchTabAlertHoverPO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWhandleSwitchActionScrollFrameHover extends BaseSetUp {

    @Test
    public void testSecondRowElements() throws InterruptedException {
        driver.get(hostname);

        GetWHandleSwitchTabAlertHoverPO testPO2 = new GetWHandleSwitchTabAlertHoverPO(driver);
        testPO2.testSecondRow();
        System.out.println("This is Assertion:");
        System.out.println(("new page opened, expected: Free Access to InterviewQues/ResumeAssistance/Material -> Actual: " + testPO2.checkSelectedOptionIT("Free Access to InterviewQues/ResumeAssistance/Material")));
        Assert.assertTrue((testPO2.checkSelectedOptionIT("Free Access to InterviewQues/ResumeAssistance/Material")));

        //checkHoverPageOpened asertion
//        Assert.assertTrue(testPO2.checkHoverPageOpened("About Us"));


    }
}

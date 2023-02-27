package PrisacaBarnova;

import PrisacaBarnova.PageObjects.PoBasePagePB;
import PrisacaBarnova.PageObjects.PoHomePagePB;
import PrisacaBarnova.PageObjects.PoNavBarPB;
import PrisacaBarnova.PageObjects.PoStupinaPB;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class testBasePB extends PoBasePagePB {
    //beforesuite aftersuite

    protected PoHomePagePB homePagePB;
    protected PoNavBarPB navBarPB;
    protected PoStupinaPB stupinaPB;

    @BeforeSuite
    public void setUp(){
        goToHomepage();
        Assert.assertTrue(goToHomepage(), "Could not load homepage");

        homePagePB = new PoHomePagePB();
        navBarPB = new PoNavBarPB();
        stupinaPB = new PoStupinaPB();
    }

    @AfterSuite
    public void tearDown(){
        closeBrowser();
    }
}

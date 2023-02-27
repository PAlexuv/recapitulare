package PrisacaBarnova;

import PrisacaBarnova.PageObjects.PoNavBarPB;
import PrisacaBarnova.PageObjects.PoStupinaPB;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class testStupinaPB extends testBasePB {

    @BeforeClass(description = "navigate to Stupina page")
    public void toStupinaPage(){
        new PoNavBarPB().clickStupina();
    }


//    PoStupinaPB stupinaPB = new PoStupinaPB();  nu mai e necesar am facut instntierea in base page

    @Test(description = "test page title")
    public void testPageTitle(){
        String title = stupinaPB.getTitle();
        System.out.println(title);
        assertEquals(title, "Stupina - Prisaca Barnova", "not Stupina's page title!");
    }

    @Test(description = "test Stupina's page welcome text")
    public void testStupinaText(){
        String stupinasText = stupinaPB.getStupinaText();
        System.out.println(stupinasText);
        assertEquals(stupinasText, "Stupina", "couldn't find the text");
    }

    @Test(description = "click on stupina's picture, confirm we clicked the picture")
    public void testStupinaPicture(){
        stupinaPB.clickOnPicture();
    }

}

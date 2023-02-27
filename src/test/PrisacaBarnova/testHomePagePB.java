package PrisacaBarnova;

import PrisacaBarnova.PageObjects.PoHomePagePB;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class testHomePagePB extends testBasePB {

    @Test(description = "test Page Title")
    public void testPageTitle(){

        String pageTitle = homePagePB.getTitle();
        System.out.println("title: " + pageTitle);
        Assert.assertEquals(pageTitle, "Prisaca Barnova - Miere Naturala de Albine", "title do not match - !!");

    }

    @Test(description = "get a text from homepage - cele mai vandute")
    public void testHomePageText(){
        String homePageText = homePagePB.homePageText();
        System.out.println("text from homepage: " + homePageText );
        assertEquals(homePageText, "Cele mai vandute",  "text does not exist!");
        //acest tip de assert nu mai e necesar pentru ca am specificat sa fie importat assert static. punem * pentru a accesa tot din Assert
//        Assert.assertEquals(homePageText, "Cele mai vandute",  "text does not exist!");
    }

}

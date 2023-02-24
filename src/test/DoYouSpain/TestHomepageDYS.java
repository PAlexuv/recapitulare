import DoYouSpain.BaseForTesting.UtilsDYS.BaseSetupDYS;
import DoYouSpain.PageObjects.PoHomePageDYS;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHomepageDYS extends BaseSetupDYS {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Testing Homepage");
    }

    @Test
    public void testHomepage (){
        driver.get(hostnameDYS);
        PoHomePageDYS homePageDYS = new PoHomePageDYS(driver);
        homePageDYS.readText();
    }
}

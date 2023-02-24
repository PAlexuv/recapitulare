import DoYouSpain.BaseForTesting.UtilsDYS.BaseSetupDYS;
import DoYouSpain.PageObjects.PoHomePageDYS;
import DoYouSpain.PageObjects.PoLoginDYS;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginDYS extends BaseSetupDYS {

    @BeforeTest
    public void beforePositiveTest(){
        System.out.println("This is a positive test");
    }

    @Test
    public void testLogin() {
        driver.get(hostnameDYS);
        PoLoginDYS loginDYS = new PoLoginDYS(driver);
        loginDYS.readTitle();
    }
}

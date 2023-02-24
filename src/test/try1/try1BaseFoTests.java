import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import try1.PageObjects.try1PoBasePage;

public class try1BaseFoTests extends try1PoBasePage {

    //  @BeforeSuite - create a method to go to homepage - method extended from PoBase with Assert
    //  on setup we assertTrue that our tests go through homepage first - repetitive task
    @BeforeSuite
    public void setUp(){
        Assert.assertTrue(goToHomepage(), "Couldn't get the homepage");
    }

    //  @AfterSuite - close browser; do NOT put the same name to method as the called method from PoBase
    @AfterSuite
    public void tearDown(){
        closeBrowser();
    }
}

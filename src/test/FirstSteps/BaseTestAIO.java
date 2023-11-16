package AutomateIO;

import AutomationIO.PageObjects.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestAIO extends BasePOPageAIO {

    //instantiate all the classes that we need to instantiate to not instantiate them every time - only accesible by the classes that inherit(extend) this class
    //instantiate the classes after the homepage has been launched - put in BeforeSuite

    protected PoHomePageAIO homePageAIO;
    protected PoNavigationBarAIO navBarAIO;
    protected PoSandboxAIO sandboxAIO;
    protected POTrainingAIO trainingAIO;

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        Assert.assertTrue(goToHomePage(), "An error occured while navigating to the homepage");
        homePageAIO = new PoHomePageAIO();
        navBarAIO = new PoNavigationBarAIO();
        sandboxAIO = new PoSandboxAIO();
        trainingAIO = new POTrainingAIO();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }
}

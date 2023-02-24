import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class TestTrainingAIO extends BaseTestAIO {

    //before class press training button from navBar wich is ponavigationBar
    @BeforeClass
    public void testNavigateToTrainigPage(){
        navBarAIO.trainingAIO();
    }

    //
    @Test(description = "check title")
    public void testTrainingTitle(){
        String trainingTitle = trainingAIO.getTrainingTitle();
        System.out.println(trainingTitle);
        assertEquals(trainingTitle, "Training | automateNow");
    }

    @Test(description = "get the text from down page")
    public void testFirstDownPageText(){
        String firstText = trainingAIO.getFirstTexFromContributions();
        System.out.println(firstText);
        assertEquals(firstText, "BugRaptors | Tech Talks");
    }
    @Test(description = "get the 2nd text from down page")
    public void testSecondDownPageText(){
        String secText = trainingAIO.getSecondTextContribution();
        System.out.println(secText);
        assertEquals(secText, "Testomat.io | Singleton Design Pattern: How to Use It In Test Automation");
    }
}

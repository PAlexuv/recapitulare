package AutomateIO;

import org.testng.annotations.*;

import static org.junit.Assert.*;

public class TestHomepageAIO extends BaseTestAIO {

    @Test(description = "Verify page title")
    public void testPageTitle(){
        String pageTitle = homePageAIO.getPageTitle();
        System.out.println("Page title is: " + pageTitle);
        assertEquals(pageTitle, "automateNow | Automation Made Easy", "automateNow | Automation Made Easy");
    }

    @Test(description = "Verify first Article Title")
    public void TestFirstArticleTitle(){
        String firstArticleTitle = homePageAIO.getFirstArticleTitle();
        System.out.println("First Article title is: " + firstArticleTitle);
        assertEquals(firstArticleTitle, "Cypress vs Selenium: Collision of Champions 2022", "titles do not match");
    }

    @Test(description = "Test hover and click on Reviews button")
    public void testHoverClickReviewsButton(){
        navBarAIO.reviewsAIO();
    }

}

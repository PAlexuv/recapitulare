import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import try1.PageObjects.try1PoHomePage;

public class try1TestHomePage extends try1BaseFoTests{

    try1PoHomePage try1Homepage = new try1PoHomePage();

    //@Test(description = "Verify page title")
    //@Test(description = "Verify first Article Title")

    @Test(description = "verify page title")
    public void testPageTitle(){
        String pageTitle = try1Homepage.getTitle();
        Assert.assertEquals(pageTitle, "automateNow | Automation Made Easy", "no title");
    }

    @Test(description = "verify article text")
    public void testArticleTitle(){
        String articleText = try1Homepage.getArticleTitle();
        Assert.assertEquals(articleText, "Cypress vs Selenium: Collision of Champions 2022", "no match");
    }
}

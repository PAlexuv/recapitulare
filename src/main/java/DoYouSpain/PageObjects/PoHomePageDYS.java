package DoYouSpain.PageObjects;

import DoYouSpain.BaseForTesting.UtilsDYS.BaseSetupDYS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PoHomePageDYS extends BaseSetupDYS {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public PoHomePageDYS(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("Spain Car Hire from £2 day - 100% Lowest Price Guaranteed!"));
        actions= new Actions(driver);
        driver.manage().window().maximize();

        PageFactory.initElements(driver, this);
    }

    public void readText(){
        //verify texts
        String text = driver.findElement(By.xpath("//div[@class='landing-page-title']")).getText();
//        Assert.assertEquals(text, "All the top car hire companies in one place", "Text did not match!");
        Assert.assertTrue(text.contains("All the"));
        //close browser
        driver.quit();
    }
}

package DoYouSpain.PageObjects;

import DoYouSpain.BaseForTesting.UtilsDYS.BaseSetupDYS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PoLoginDYS extends BaseSetupDYS {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public PoLoginDYS(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("Spain Car Hire from £2 day - 100% Lowest Price Guaranteed!"));
        System.out.println(driver.getTitle());
        actions = new Actions(driver);
        driver.manage().window().maximize();

        PageFactory.initElements(driver, this);
    }

    public void enterValuesOnInput(WebElement el, String value){
        el.click();
        el.clear();
        el.sendKeys(value);
    }

    public void readTitle(){
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Spain Car Hire from £2 day - 100% Lowest Price Guaranteed!" );
        System.out.println(driver.getTitle());

        driver.quit();
    }
}

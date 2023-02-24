package Twitter.PageObjects;

import Twitter.BaseForTesting.UtilsTW.BaseSetUpTW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PoBasePageTW extends BaseSetUpTW {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public PoBasePageTW(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("Log in to Twitter / Twitter"));
        actions = new Actions(driver);
        driver.manage().window().maximize();

        PageFactory.initElements(driver, this);
    }

    public PoBasePageTW() {
    }

    public void enterValuesOnInput(WebElement el, String value){
        el.click();
        el.clear();
        el.sendKeys(value);
    }
}

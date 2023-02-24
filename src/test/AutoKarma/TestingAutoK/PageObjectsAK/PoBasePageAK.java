package TestingAutoK.PageObjectsAK;

import BaseForTestingAutoK.UtilsAK.BaseSetUpAK;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PoBasePageAK extends BaseSetUpAK {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public PoBasePageAK(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        driver.manage().window().maximize();

        PageFactory.initElements(driver, this);
    }

    public void enterValuesOnInput(WebElement el, String value){
        el.click();
        el.clear();
        el.sendKeys(value);
    }
}

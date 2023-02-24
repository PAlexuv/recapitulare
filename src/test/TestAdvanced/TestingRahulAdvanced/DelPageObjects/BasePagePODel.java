package TestingRahulAdvanced.DelPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePagePODel {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePagePODel(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

}

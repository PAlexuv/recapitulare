package TestingRahul.PageObjectsRahul;

import BaseForTestingRahul.Utils.BaseMethodsUtils;
import BaseForTestingRahul.Utils.BaseSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageRahulPO extends BaseSetUp {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePageRahulPO(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        driver.manage().window().maximize();

        PageFactory.initElements(driver, this);

    }
}

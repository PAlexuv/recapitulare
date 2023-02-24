package TestingBioGama.PageObjectsBioG;

import TestingAutoK.PageObjectsAK.PoBasePageAK;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PoBasePageBioG {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public PoBasePageBioG() {

    }

    public void enterValuesOnInput(WebElement el, String value){
        el.click();
        el.clear();
        el.sendKeys(value);
    }

    public PoBasePageBioG(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
        driver.manage().window().maximize();

        PageFactory.initElements(driver, this);
    }

    public void selectCheckBox(WebElement checkBox){
        if(!checkBox.isSelected())
            actions.click(checkBox).build().perform();
    }
    public String getText(WebElement webElement) {
        return webElement.getText();
    }
}

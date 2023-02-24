package TestingRahulAdvanced.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPO {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public AlertPO(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
        Actions actions;

    //open website page
    public void openWebsite(String hostname) {
        System.out.println("Open the next url: " + hostname);
        driver.get(hostname);
    }

    @FindBy(css = "#alertbtn")
    WebElement alertButton;
    @FindBy(css = "#confirmbtn")
    WebElement confirmButton;
    @FindBy(css = "#name")
    WebElement alertText;

    public void showAlertTextandAccept() {
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //dismiss
        alert.accept();
    }

    public void showAlertTerxtandDismiss() {
        confirmButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //dismiss
        alert.dismiss();
    }

    public void showAlertTextandInputText() {
        alertText.sendKeys("Alex1");
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //dismiss
        alert.accept();
        alertText.sendKeys("Alex2");
        confirmButton.click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        //dismiss
        alert.dismiss();
    }

}

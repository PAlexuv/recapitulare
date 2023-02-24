package TestingRahulAdvanced.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HoverPagePO extends BasePagePO{

    public HoverPagePO(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @FindBy (css = "#mousehover")
    WebElement hoverButton;
    @FindBy(xpath = "//a[normalize-space()='Reload']")
    WebElement hoverChoiceReload;
    @FindBy (css = "a[href='#top']")
    WebElement hoverChoiceTop;

    Actions actions;

    public void selectValueFromHoverDropdown(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        actions.moveToElement(hoverButton).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Reload']")));
        System.out.println(hoverChoiceReload.getText());
        hoverChoiceReload.click();
        actions.moveToElement(hoverButton).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='#top']")));
        System.out.println(hoverChoiceTop.getText());
        hoverChoiceTop.click();
    }


}

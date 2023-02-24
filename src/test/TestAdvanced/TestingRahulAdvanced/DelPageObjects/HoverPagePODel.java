package TestingRahulAdvanced.DelPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HoverPagePODel extends BasePagePODel{

    public HoverPagePODel(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#mousehover")
    WebElement hoverButton;

    public void useHover(){
        actions.moveToElement(hoverButton).build().perform();
        System.out.println(hoverButton.getText());
    }

}

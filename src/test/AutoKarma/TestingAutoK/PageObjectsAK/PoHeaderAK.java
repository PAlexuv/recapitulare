package TestingAutoK.PageObjectsAK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoHeaderAK extends PoBasePageAK {

    public PoHeaderAK(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "img[title='AutoKarma Group']" )
    WebElement websiteLogo;
    public void clickLogo(){
        websiteLogo.click();

    }

    public void testHeader(){
        clickLogo();
    }
}

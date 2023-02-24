package PrisacaBarnova.PageObjects;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PoStupinaPB extends PoBasePagePB {
    By stupinaText = By.cssSelector(".entry-title");
    By stupinaPicture = By.cssSelector("img[title='3']");
    By confirmStupinaPicture = By.cssSelector(".bwg_popup_image_spun2 [alt]");

    public String getTitle(){
        return driver.getTitle();
    }

    public String getStupinaText(){
        return getText(stupinaText);
    }

    public void clickOnPicture(){
        driver.findElement(stupinaPicture).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(confirmStupinaPicture).isDisplayed();
    }

}

package PrisacaBarnova.PageObjects;

import org.openqa.selenium.By;

public class PoHomePagePB extends PoBasePagePB{
    By hPageText = By.cssSelector("li[class='active'] a[data-toggle='tab']");

    public String getTitle(){
        return driver.getTitle();
    }

    public String homePageText(){
        return driver.findElement(hPageText).getText();
    }

}

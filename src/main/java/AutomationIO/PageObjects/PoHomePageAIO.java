package AutomationIO.PageObjects;

import org.openqa.selenium.By;

public class PoHomePageAIO extends BasePOPageAIO {

    private By firstArticleTitle = By.xpath("//a[normalize-space()='Cypress vs Selenium: Collision of Champions 2022']");

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getFirstArticleTitle(){
        return driver.findElement(firstArticleTitle).getText();
    }

}


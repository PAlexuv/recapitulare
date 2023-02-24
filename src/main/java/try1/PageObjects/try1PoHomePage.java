package try1.PageObjects;

import org.openqa.selenium.By;

public class try1PoHomePage extends try1PoBasePage {
    By firstTitle = By.cssSelector("article[id='post-3500'] header[class='entry-header'] a");


    public String getTitle(){
        return driver.getTitle();
    }

    public String getArticleTitle(){
        return driver.findElement(firstTitle).getText();
    }
}

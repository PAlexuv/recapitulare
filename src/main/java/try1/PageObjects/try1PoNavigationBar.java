package try1.PageObjects;

import org.openqa.selenium.By;

public class try1PoNavigationBar extends try1PoBasePage {
    By navBar = By.cssSelector("span[data-hover='Sandbox']");

    public try1PoSandbox try1Sandbox(){
        driver.findElement(navBar).click();
        return new try1PoSandbox();
    }
}

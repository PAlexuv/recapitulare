package Twitter.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoLoginPageTW extends PoBasePageTW{

    public PoLoginPageTW(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='text']" )
    WebElement usernameTW;
    @FindBy(css = "input[name='password']" )
    WebElement passwordTW;

    public PoLoginPageTW() {
        super();
    }

    public PoLoginPageTW loginTW(String username, String password){
    usernameTW.sendKeys(username);
    passwordTW.sendKeys(password);
        return this;
    }

    public String getErrorMessage(){
        return  driver.findElement(By.cssSelector("//span[contains(text(), 'The username and password you entered did not match')]")).getText();
    }


}

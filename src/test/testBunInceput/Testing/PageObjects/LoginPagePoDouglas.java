package Testing.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePoDouglas {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions = new Actions(driver);
//constructor
    public LoginPagePoDouglas(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
//open website page
    public void openWebsite(String hostnameDouglas){
        System.out.println("Open the next url: " + hostnameDouglas);
        driver.get(hostnameDouglas);
    }

@FindBy (css = "#CybotCookiebotDialogBodyButtonDecline")
    WebElement declineCookie;

@FindBy(css = ".account--display.nav--text")
WebElement contulMeuButton;

@FindBy(css = ".navigation--signin")
WebElement signInButton;

@FindBy(css = "#email")
    WebElement username;
@FindBy(css = ".alert--content")
    WebElement usernameErr;

@FindBy(css = "#password")
    WebElement password;
@FindBy(css = ".alert--content")
    WebElement passwordErr;

@FindBy(css = "button[class='register--login-btn btn is--primary is--large right']")
    WebElement conectare;

    //login elements to do:
    public void loginEl(String usernameInp, String passwordInp) {
        declineCookie.click();
        actions.moveToElement(driver.findElement(By.cssSelector(".account--display.nav--text"))).build().perform();
//        contulMeuButton.click();
        signInButton.click();
        username.clear();
        username.sendKeys(usernameInp);
        password.clear();
        password.sendKeys(passwordInp);

        conectare.click();
    }

    public boolean checkErr(String expectedErr, String errorType){
        if(errorType.equalsIgnoreCase("userErr")){
            return expectedErr.equals(usernameErr.getText());
        }
        else if(errorType.equalsIgnoreCase("passErr")){
//            this.waitPassErr(); EROAREA DINAMICA DE MAI SUS DIN WAITPASSERR
            return expectedErr.equalsIgnoreCase(passwordErr.getText());
        }
        return false;
    }


}


package Selenium.Csel.pageObjectsFindByMethodsDB;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePO {

    //constructor
    public LoginPagePO(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;
    WebDriverWait wait;

    //define webelements
//    WebElement usernameEl = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#username"));
//    WebElement passwordEl = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector("#password"));
//    WebElement buttonSubmit = Utils.waitForPresenceOfOneElementGeneric(driver, 10, By.xpath("//button[@id='submit']"));

    @FindBy(css="#username")
    WebElement username;

    @FindBy(css="#password")
    WebElement password;

    @FindBy(xpath="//button[@id='submit']")
    WebElement button;

    //define errors:
//    WebElement usernameErr = SeleniumUtils.waitForPresenceOfElementGeneric(driver, 15, By.xpath("//input[@id='input-login-username']/parent::div/div[@class='text-left invalid-feedback']"));
//    WebElement passwordErr = SeleniumUtils.waitForPresenceOfElementGeneric(driver, 15, By.xpath("//input[@id='input-login-password']/parent::div/div[@class='text-left invalid-feedback']"));
    @FindBy(xpath = "//div[@id='error']")
    WebElement usernameErr;
    @FindBy(xpath = "//div[@id='error']")
    WebElement passwordErr;

    //pagina 2 dupa login corect
    @FindBy(css = ".post-title")
    WebElement loggedIn;

    @FindBy(css = ".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")
    WebElement logOutButton;

    //IN CAZ CA O EROARE NU APARE E NULA SUA O FACEM DINAMICA:
//    WebElement passwordErr;
//    By passwordErrBy = By.xpath("//div[@id='error']");


    public void openLoginPage(String hostname){
        System.out.println("Open the next url: " + hostname + "/practice-test-login");
        driver.get(hostname + "/practice-test-login");
    }

    public void login(String usernameInp, String passwordInp){
        username.clear();
        username.sendKeys(usernameInp);
        password.clear();
        password.sendKeys(passwordInp);
        button.click();
        loggedIn.getText();
        logOutButton.isDisplayed();
    }

    //IN CAZ CA O EROARE NU APARE E NULA SUA O FACEM DINAMICA:
//    public void waitPassErr(){
//        passwordErr = Utils.waitForPresenceOfOneElementGeneric(driver, 10, passwordErrBy);
//    }
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

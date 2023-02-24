package TestingAutoK.PageObjectsAK;

import BaseForTestingAutoK.UtilsAK.BaseMethodsAK;
import TestingAutoK.DataBase.ObjectModels.AccountLoginModelAK;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;

public class PoLoginAK extends PoBasePageAK{

    public PoLoginAK(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn.btn-success.notify_cookie-close")
    WebElement acceptCookies;

    @FindBy(css = "div[class='hidden-xs']")
    WebElement myAccountButton;

    @FindBy(xpath = "//div[@class='hidden-xs']//div[@class='dropdown-menu pull-right']//a[@class='btn btn-outline']")
    WebElement loginButton;

    @FindBy(css = "#input-email")
    WebElement usernameAK;
    @FindBy(css = ".alert.alert-danger")
    WebElement usernameErrAK;

    @FindBy (css = "#input-password")
    WebElement passwordAK;
    @FindBy(css = ".alert.alert-danger")
    WebElement passwordErrAK;

    @FindBy (css = "button[value='login']")
    WebElement authButton;

    public void openAKPage(String hostnameAK){
        driver= BaseMethodsAK.getBrowser(browserTypeAK);
        driver.get(hostnameAK);
    }

//    public void loginMethodAK(String usernameInp, String passwordInp) {
//
//        acceptCookies.click();
//
//        actions.moveToElement(myAccountButton).build().perform();
//        actions.moveToElement(loginButton).build().perform();
//        try {
//            loginButton.click();
//        } catch (NoSuchElementException e) {
//            System.out.println("unable to click on button after hover");
//        }
//
//        BaseMethodsAK.waitForPresenceOfOneElementGeneric(driver, 5, By.cssSelector("#input-email"));
//        usernameAK.clear();
//        usernameAK.sendKeys(usernameInp);
//        passwordAK.clear();
//        passwordAK.sendKeys(passwordInp);
//        authButton.click();
//        BaseMethodsAK.waitForPresenceOfOneElementGeneric(driver, 5, By.cssSelector(".alert.alert-danger"));
//        System.out.println(passwordErrAK.getText());
//    }

    public void loginActionsAK() {
        acceptCookies.click();
        actions.moveToElement(myAccountButton).build().perform();
        actions.moveToElement(loginButton).build().perform();
        try {
            loginButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("unable to click on button after hover");
        }
        BaseMethodsAK.waitForPresenceOfOneElementGeneric(driver, 5, By.cssSelector("#input-email"));

    }

    public void enterLoginInputsAK(String usernameInp, String passwordInp ){
        enterValuesOnInput(usernameAK, usernameInp);
        enterValuesOnInput(passwordAK, passwordInp);
    }

    public boolean checkErrLogin(String expectedErr, String errorTypeUserOrPassword) {
        if (errorTypeUserOrPassword.equalsIgnoreCase("userErr")) {
            System.out.println(usernameErrAK.getText());
        return expectedErr.equals(usernameErrAK.getText());
    }
        else if(errorTypeUserOrPassword.equalsIgnoreCase("passErr")){
            System.out.println(passwordErrAK.getText());
            return expectedErr.equals(passwordErrAK.getText());
        }
        return false;
    }

}

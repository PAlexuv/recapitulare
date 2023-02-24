package TestingAutoK.PageObjectsAK;

import BaseForTestingAutoK.UtilsAK.BaseMethodsAK;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class PoRegisterPageAK extends PoBasePageAK{

    public PoRegisterPageAK(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn.btn-success.notify_cookie-close")
    WebElement acceptCookies;

    @FindBy(css = "div[class='hidden-xs']")
    WebElement myAccountButton;

    @FindBy(xpath = "//div[@class='hidden-xs']//div[@class='dropdown-menu pull-right']//a[@class='btn btn-inverse']")
    WebElement registerButton;

//register form
    @FindBy(css = "input#input-lastname")
    WebElement nume;
    @FindBy(xpath = "//label[@for='input-lastname']/following-sibling::div[@class='text-danger']")
    WebElement numeErr;

    //cream un webelement pentru a face o metoda sa tragem de timp sa apara erorile
    By numerErrBy= By.xpath("//label[@for='input-lastname']/following-sibling::div[@class='text-danger']");

    @FindBy(css = "input#input-firstname")
    WebElement prenume;
    @FindBy(xpath = "//label[@for='input-firstname']/following-sibling::div[@class='text-danger']")
    WebElement prenumeErr;
    @FindBy(css = "input#input-email")
    WebElement email;
    @FindBy(css = "input#input-email")
    WebElement emailErr;
    @FindBy(css = "input#input-telephone")
    WebElement phone;
    @FindBy(css = "input#input-telephone")
    WebElement phoneErr;

    //Metoda Selectare Judet
    @FindBy(css = "select#input-zone")
    WebElement selectJudet;
    @FindBy(css = "select#input-zone")
    WebElement selectJudetErr;
    public void choseJudet(String judet) {
        Select select = new Select(selectJudet);
        select.selectByVisibleText(judet);
    }

    //Metoda Selectare Oras
    @FindBy(css = "select#input-city")
    WebElement selectOras;
    @FindBy(css = "select#input-city")
    WebElement selectOrasErr;
    public void choseOras(String oras) {
        selectOras.click();
        Select select = new Select(selectOras);
        select.selectByVisibleText(oras);
    }

    @FindBy(css = "input#input-address-1")
    WebElement strada;
    @FindBy(css = "input#input-address-1")
    WebElement stradaErr;

    @FindBy(css = "input#input-postcode")
    WebElement codPostal;
    @FindBy(css = "input#input-postcode")
    WebElement codPostalErr;

    //Metoda Schimbare tab
    @FindBy(css = "span#search-postcode")
    WebElement butonCautaCodPostal;
    @FindBy(css = "span#search-postcode")
    WebElement butonCautaCodPostalErr;
    public void switchNewTabCodPostal(){
        butonCautaCodPostal.click();
        Set<String> pageId = driver.getWindowHandles();
        Iterator<String> iterator = pageId.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(childId).close();
        driver.switchTo().window(parentId);
    }

    //Metoda Selectare Magazin Preferat din localitatea x
    @FindBy(css = "select#input-location_id")
    WebElement locatieMagazinPreferat;
    @FindBy(css = "select#input-location_id")
    WebElement locatieMagazinPreferatErr;
    public void choseMagazinPreferat() {
        Select select = new Select(locatieMagazinPreferat);
        select.selectByValue("6");
    }

    @FindBy(css = "input#input-password")
    WebElement parola;
    @FindBy(css = "input#input-password")
    WebElement parolaErr;

    @FindBy(css = "input#input-confirm")
    WebElement confirmareParola;
    @FindBy(css = "input#input-confirm")
    WebElement confirmareParolaErr;

    @FindBy(xpath = "//label[@for='register_agree']")
    WebElement TermCondCheckBox;
    @FindBy(xpath = "//label[@for='register_agree']")
    WebElement TermCondcheckBoxErr;

    @FindBy(xpath = "//label[@for='date_agree']")
    WebElement GDPRcheckbox;
    @FindBy(xpath = "//label[@for='date_agree']")
    WebElement GDPRcheckboxErr;

    @FindBy(css = "button#register-account")
    WebElement butonRegister;

    //dupa identificarea elementelor si crearea metodelor de accesare a obiectelor
    //cream o metoda pentru actiuni
    //cream metode pentru testare pozitiva si negativa

    public void registerPageActionsAK(){
        //main page
        System.out.println("Base page: " + driver.getTitle());
        acceptCookies.click();
        actions.moveToElement(myAccountButton).build().perform();
        actions.moveToElement(registerButton).build().perform();
        registerButton.click();
        //registration page
        try {
            nume.getText();
        }catch (NoSuchElementException e) {
            System.out.println("Stop playing with your mouse, go play with smth else");
        }
        BaseMethodsAK.waitForPresenceOfOneElementGeneric(driver, 3, By.cssSelector("input#input-lastname"));

        System.out.println("Registration page: " + driver.getTitle());
        choseJudet("Iasi");
        BaseMethodsAK.waitForPresenceOfOneElementGeneric(driver, 5, By.cssSelector("select#input-city"));
        choseOras("IASI");
        switchNewTabCodPostal();
        choseMagazinPreferat();
        TermCondCheckBox.click();
        GDPRcheckbox.click();
        butonRegister.click();
    }

    public void PosRegistrationPageAK(String numeInp, String prenumeInp, String emailInp, String phoneInp, String stradaInp, String codPostalInp,
                                      String parolaInp, String confirmareParolaInp) {
        nume.sendKeys(numeInp);
        prenume.sendKeys(prenumeInp);
        email.sendKeys(emailInp);
        phone.sendKeys(phoneInp);
        strada.sendKeys(stradaInp);
        codPostal.sendKeys(codPostalInp);
        parola.sendKeys(parolaInp);
        confirmareParola.sendKeys(confirmareParolaInp);
    }

    public void NegRegistrationPageAK(
            String numeInp, String prenumeInp, String numeInpErr, String prenumeInpErr) {

            nume.sendKeys(numeInp);
            prenume.sendKeys(prenumeInp);

            numeErr = BaseMethodsAK.waitForPresenceOfOneElementGeneric(driver, 5, numerErrBy);

            Assert.assertEquals(numeInpErr, numeErr.getText());
            Assert.assertEquals(prenumeInpErr, prenumeErr.getText());
    }

    public boolean checkErrRegister(String expectedErr, String errorType) {
        if (errorType.equalsIgnoreCase("numeErr")) {
            System.out.println("Eroare nume : " + numeErr.getText());
            return expectedErr.equals(numeErr.getText());
        }
        else if(errorType.equalsIgnoreCase("prenumeErr")){
            System.out.println("Eroare prenume : " + prenumeErr.getText());
            return expectedErr.equals(prenumeErr.getText());
        }
        return false;
    }

}



/* de folosit daca e cazu

  //, String emailInp, String phoneInp, String stradaInp,
    //            String codPostalInp,String parolaInp, String confirmareParolaInp,
    //,String emailInpErr, String phoneInpErr,
    //            String stradaInpErr, String codPostalInpErr,String parolaInpErr, String confirmareParolaInpErr

nume.sendKeys("testNume");
        prenume.sendKeys("testPrenume");
        email.sendKeys("testEmail@email.com");
        phone.sendKeys("0789456754");
        strada.sendKeys("stefan cel mare 21");
        codPostal.sendKeys("8989");
        parola.sendKeys("testareParola");
        confirmareParola.sendKeys("testareConfirmareParola");
 */
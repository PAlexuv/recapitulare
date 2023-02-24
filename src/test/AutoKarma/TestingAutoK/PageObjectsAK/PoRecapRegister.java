package TestingAutoK.PageObjectsAK;

import BaseForTestingAutoK.UtilsAK.BaseMethodsAK;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class PoRecapRegister extends PoBasePageAK{

    public PoRecapRegister(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn.btn-success.notify_cookie-close")
    WebElement acceptCookie;

//    @FindBy(css = ".dropdown-backdrop")
    @FindBy(css = "div[class='hidden-xs']")
    WebElement hoverMyAccount;

    @FindBy(xpath = "//div[@class='hidden-xs']//a[@class='btn btn-inverse']")
    WebElement inregistrareButton;

    //wait for error
    By waitForErrors = By.xpath("//label[@for='input-lastname']/following-sibling::div[@class='text-danger']");

//register page
    @FindBy(css = "input#input-lastname")
    WebElement nume;
    @FindBy(xpath = "//label[@for='input-lastname']/following-sibling::div[@class='text-danger']")
    WebElement numeErr;

    @FindBy(css = "input#input-firstname")
    WebElement prenume;
    @FindBy(xpath = "//label[@for='input-firstname']/following-sibling::div[@class='text-danger']")
    WebElement prenumeErr;
    @FindBy(css = "input#input-email")
    WebElement email;
    @FindBy(xpath = "//label[@for='input-email']/following-sibling::div[@class='text-danger']")
    WebElement emailErr;
    @FindBy(css = "input#input-telephone")
    WebElement telefon;
    @FindBy(xpath = "//label[@for='input-telephone']/following-sibling::div[@class='text-danger']")
    WebElement telefonErr;

    //alege judet
    @FindBy(css = "select#input-zone")
    WebElement alegeJudet;
    @FindBy(xpath = "//label[@for='input-zone']/following-sibling::div[@class='text-danger']")
    WebElement alegeJudetErr;

    public void alegeJudet(String judet){
        alegeJudet.click();
        Select select = new Select(alegeJudet);
        select.selectByVisibleText(judet);
    }

    //alege Oras
    @FindBy(css = "select#input-city")
    WebElement alegeOras;
    @FindBy(css = "//label[@for='input-city']/following-sibling::div[@class='text-danger']")
    WebElement alegeOrasErr;

    public void alegeOrasul(String localitate){
        alegeOras.click();
        Select selectOras=new Select(alegeOras);
        selectOras.selectByVisibleText(localitate);
    }

    //adresa
    By adresaWait = By.cssSelector("#input-address-1");
    @FindBy(css = "#input-address-1")
    WebElement adresa;
    @FindBy(css = "//label[@for='input-address-1']/following-sibling::div[@class='text-danger']")
    WebElement alegeAdresaErr;

    //cod postal
    By codPostalWait = By.cssSelector("#input-postcode");
    @FindBy(css = "#input-postcode")
    WebElement codPostal;
    @FindBy(css = "//label[@for='input-postcode']/following-sibling::div[@class='text-danger']")
    WebElement codPostalErr;
    @FindBy(css = "#search-postcode")
    WebElement butonCodPostalCauta;
    @FindBy(css = "#cookie-bar-close")
    WebElement cookiePostaRomanaPage;
    public void butonCodPostal(){
        butonCodPostalCauta.click();
        Set<String> pageID = driver.getWindowHandles();
        Iterator<String> selectedPage = pageID.iterator();
        String pageParent = selectedPage.next();
        String pageChild1 = selectedPage.next();
        driver.switchTo().window(pageChild1);
        System.out.println(driver.getTitle());
        cookiePostaRomanaPage.click();
        driver.switchTo().window(pageChild1).close();
        driver.switchTo().window(pageParent);
        System.out.println(driver.getTitle());
    }

    //alege magazin preferat din lista
    @FindBy(css = "#input-location_id")
    WebElement alegeMagazin;
    @FindBy(css = "//label[@for='input-location_id']/following-sibling::div[@class='text-danger']")
    WebElement alegeMagazinErr;

    public void alegeMagazin(String value){
        Select selectMagazin = new Select(alegeMagazin);
        selectMagazin.selectByValue(value);
    }

    //parola
    @FindBy(css = "#input-password")
    WebElement parola;
    @FindBy(css = "//label[@for='input-password']/following-sibling::div[@class='text-danger']")
    WebElement parolaErr;
    @FindBy(css = "#input-confirm")
    WebElement parolaConfirm;
    @FindBy(css = "//label[@for='input-confirm']/following-sibling::div[@class='text-danger']")
    WebElement parolaConfirmErr;

    //checkboxes
    @FindBy(css = "label[for='register_agree']")
    WebElement checkBoxTC;
    @FindBy(css = "//input[@id='register_agree']/ancestor::div[@class='col-sm-12 col-xs-12']//div[@class='text-danger']")
    WebElement checkBoxTCErr;
    @FindBy(css = "label[for='date_agree']")
    WebElement checkBoxGDPR;
    @FindBy(css = "//input[@id='date_agree']/ancestor::div[@class='col-sm-12 col-xs-12']//div[@class='text-danger']")
    WebElement checkBoxGDPRErr;

    //buron inregistrare
    @FindBy(css = "button#register-account")
    WebElement registerButton;

    public void openWebsite(){
        driver = BaseMethodsAK.getBrowser(browserTypeAK);
        driver.get(hostnameAK);
    }

    //ONE METH TO RULE ALL
    public void registerActions() throws InterruptedException {
//main page
        openWebsite();
        System.out.println("Opened page:" + driver.getTitle());
        acceptCookie.click();
        actions.moveToElement(hoverMyAccount).build().perform();
        actions.moveToElement(inregistrareButton).build().perform();
        inregistrareButton.click();
//in case user moves mopuse during testing phase
        try {
            nume.getText();
        }catch (NoSuchElementException e) {
            System.out.println("Stop playing with your mouse, go play with smth else");
        }
        //registration page ACTIONS; we do not input data, as we will introduce them from DATABASE
        System.out.println("Opened page:" + driver.getTitle());
        alegeJudet("Iasi");
        alegeOrasul("IASI");
        butonCodPostal();
        BaseMethodsAK.waitForPresenceOfOneElementGeneric(driver, 3, codPostalWait);
        BaseMethodsAK.waitForPresenceOfOneElementGeneric(driver, 3, adresaWait);
        alegeMagazin("6");
        checkBoxTC.click();
        checkBoxGDPR.click();


    }

    public void posRegisterRecap(String numeInp, String prenumeInp, String emailInp, String telefonInp, String adresaInp, String codPostalInp, String parolaInp,
                                 String parolaConfirmInp){
        nume.sendKeys(numeInp);
        prenume.sendKeys(prenumeInp);
        email.sendKeys(emailInp);
        telefon.sendKeys(telefonInp);
        adresa.sendKeys(adresaInp);
        codPostal.sendKeys(codPostalInp);
        parola.sendKeys(parolaInp);
        parolaConfirm.sendKeys(parolaConfirmInp);
//scroll down to page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        registerButton.click();
    }
/*
(css = "#input-password")
    WebElement parola;
    @FindBy(css = "//label[@for='input-password']/following-sibling::div[@class='text-danger']")
    WebElement parolaErr;
    @FindBy(css = "#input-confirm")
    WebElement parolaConfirm;
    @FindBy(css = "//label[@for='input-confirm']/following-sibling::div[@class='text-danger']")
    WebElement parolaConfirmErr;
 */
}

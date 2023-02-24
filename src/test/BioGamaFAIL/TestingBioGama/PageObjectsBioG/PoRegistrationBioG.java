package TestingBioGama.PageObjectsBioG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PoRegistrationBioG extends PoBasePageBioG {

    public PoRegistrationBioG(WebDriver driver) {
        super(driver);
    }
    public PoRegistrationBioG() {
        super();
    }
    @FindBy(xpath = "//input[@id='nume']")
    WebElement nume;

    @FindBy(xpath = "//label[@id='nume-error']")
    List<WebElement> numeError;

    @FindBy(xpath = "//input[@id='prenume']")
    WebElement prenume;

    @FindBy(xpath = "//label[@id='prenume-error']")
    List<WebElement> prenumeError;

    @FindBy(xpath = "//input[@id='telefon']")
    WebElement telefon;

    @FindBy(xpath = "//label[@id='telefon-error']")
    List<WebElement> telefonError;

    @FindBy(xpath = "//input[@id='emailc']")
    WebElement email;

    @FindBy(xpath = "//label[@id='emailc-error']")
    List<WebElement> emailError;

    @FindBy(xpath = "//input[@id='passwordc']")
    WebElement parola;

    @FindBy(xpath = "//label[@id='passwordc-error']")
    List<WebElement> parolaError;

    @FindBy(xpath = "//input[@id='passwordc2']")
    WebElement parolaVerif;

    @FindBy(id = "newslttr")
    WebElement newsletter;

    @FindBy(xpath = "//label[@id='passwordc2-error']")
    List<WebElement> parolaVerifError;

    @FindBy(xpath = "//input[@id='newslttr']")
    WebElement mewsletter;

    @FindBy(xpath = " //input[@id='agree']")
    WebElement termreg;

    @FindBy(xpath = " //label[@id='agree-error']")
    List<WebElement> termregError;


    @FindBy(css = "form#crearecont input[type='submit']")
    WebElement butonCreezaCont;




    public void openRegistrationPage(String hostname) {
        System.out.println("Open the next url: " + hostname + "/cont/creare");
        driver.get(hostname + "/cont/creare");
    }

    public void enterRegisterInputs(String numeInp, String prenumeInp,
                                    String telefonInp, String emailInp, String parolaInp, String parolaVerifInp,
                                    boolean termreqIn) {
        enterValuesOnInput(nume, numeInp);
        enterValuesOnInput(prenume, prenumeInp);
        enterValuesOnInput(telefon, telefonInp);
        enterValuesOnInput(email, emailInp);
        enterValuesOnInput(parola, parolaInp);
        enterValuesOnInput(parolaVerif, parolaVerifInp);

        if (termreqIn) {
            if(!termreg.isSelected())
                termreg.click();
        }
    }

    public void checkNewsLetter(String newsInp){
        selectCheckBox(newsletter);
    }

    public void performSubmit() {
        butonCreezaCont.submit();
    }

//errors
    public String getNumeErr() {
        return getError(numeError);
    }
    public String getPrenumeErr() {
        return getError(prenumeError);
    }
    public String getEmailErr() {
        return getError(emailError);
    }
    public String getParolaErr() {
        return getError(parolaError);
    }
    public String getVerifyParolaErr() {
        return getError(parolaVerifError);
    }
    public String getThermsErr() {
        return getError(termregError);
    }
    public String getTelefonErr() {
        return getError(telefonError);
    }
    private String getError(List<WebElement> errorList){
        if(errorList.size() == 0){
            System.out.println("Eroarea nu a fost gasita");
            return "";
        }
        return errorList.get(0).getText();

    }



}

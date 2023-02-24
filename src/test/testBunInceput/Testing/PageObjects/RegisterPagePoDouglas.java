package Testing.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import baseForTesting.Utils.baseUtils;

import java.util.concurrent.TimeUnit;

public class RegisterPagePoDouglas {
    WebDriver driver;
    WebDriverWait wait;
//    Actions act = new Actions(driver);
//    CompositeAction a = new CompositeAction();
//    Actions actionsReg = new Actions(driver);


    //constructor
    public RegisterPagePoDouglas(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    //open website page
    public void openWebsite(String hostname) {
        System.out.println("Open the next url: " + hostname);
        driver.get(hostname + "account");
    }

    //use page objects
    @FindBy(css = "#CybotCookiebotDialogBodyButtonDecline")
    WebElement declineCookie;

    @FindBy(css = "a[class='dgaccount-menu--link blocked--link']")
    WebElement registerButton;

    @FindBy(css = "label[for='salutation_mr']")
    WebElement radioButDl;

    @FindBy(css = "#register_personal_customer_type")
    WebElement selectClientType;

    @FindBy(css = "#firstname")
    WebElement firstName;

    @FindBy(css = "#lastname")
    WebElement lastName;

    @FindBy(css = "#register_personal_email")
    WebElement eMail;

    @FindBy(css = "#register_personal_password")
    WebElement password;

    @FindBy(css = "#phone")
    WebElement phone;

    @FindBy(css = "#street")
    WebElement streetAndNumber;

    @FindBy(css = "#zipcode")
    WebElement zipCode;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "label[for='register_billing_no_shippingAddress']")
    WebElement radioButtonAdresaLivrare;

    @FindBy(css = "button[class='register--submit btn is--primary is--large right is--inactive']")
    WebElement butonContinuare;

    public void registerPageEl(String firstNameInp, String lastNameInp, String eMailInp, String passwordInp, String phoneInp, String streetAndNumberInp, String zipCodeInp, String cityInp) {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        baseUtils.waitForPresenceOfOneElementGeneric(driver, 10, By.cssSelector ("#CybotCookiebotDialogBodyButtonDecline"));
        declineCookie.click();
        //Adding wait
//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//        actionsReg.moveToElement(driver.findElement(By.cssSelector(".account--display.nav--text"))).build().perform();
//        registerButton.click();
        radioButDl.click();

        Select chooseClientTpe = new Select(driver.findElement(By.cssSelector("#register_personal_customer_type")));
        chooseClientTpe.selectByValue("business");

        firstName.sendKeys(firstNameInp);
        lastName.sendKeys(lastNameInp);
        eMail.sendKeys(eMailInp);
        password.sendKeys(passwordInp);
        phone.sendKeys(phoneInp);
        streetAndNumber.sendKeys(streetAndNumberInp);
        zipCode.sendKeys(zipCodeInp);
        city.sendKeys(cityInp);

        Select chooseCountry = new Select(driver.findElement(By.cssSelector("#country")));
        chooseCountry.selectByValue("33");

        Select chooseJudet= new Select(driver.findElement(By.cssSelector("select[name='register[billing][country_state_38]']")));
        chooseJudet.selectByValue("71");

        butonContinuare.click();

    }
}
//    public void selectClientType(){
//        WebElement dropDown = driver.findElement(By.cssSelector("#register_personal_customer_type"));
//        dropDown.click();
//
//        Select choseOption = new Select(driver.findElement(By.id(".register--customertype.field--select.select-field.rd__form-field.rd__form-field--floating-label.input-short")));
//        choseOption.selectByValue("option3");
//    }

//    public void selectCountry() {
//        WebElement dropDown = driver.findElement(By.cssSelector("#register_personal_customer_type"));
//        dropDown.click();
//
//        Select choseOption = new Select(driver.findElement(By.id(".register--customertype.field--select.select-field.rd__form-field.rd__form-field--floating-label.input-short")));
//        choseOption.selectByValue("option3");
//    }

//    public void selectJudet() {
//        WebElement dropDown = driver.findElement(By.cssSelector("#register_personal_customer_type"));
//        dropDown.click();
//
//        Select choseOption = new Select(driver.findElement(By.id(".register--customertype.field--select.select-field.rd__form-field.rd__form-field--floating-label.input-short")));
//        choseOption.selectByValue("option3");
//    }
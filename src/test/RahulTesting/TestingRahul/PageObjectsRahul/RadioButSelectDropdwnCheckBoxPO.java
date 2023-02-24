package TestingRahul.PageObjectsRahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RadioButSelectDropdwnCheckBoxPO extends BasePageRahulPO {

    public RadioButSelectDropdwnCheckBoxPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[value='radio2']")
    WebElement radioB2;

    @FindBy(css = "#autocomplete")
    WebElement chooseCountry;
    public void chooseOneCountry() {
        chooseCountry.sendKeys("vene");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-menu-item")));

        List<WebElement> selectFromList = driver.findElements(By.cssSelector(".ui-menu-item")); //ui-menu-item #ui-id-1   {
//        System.out.println(selectFromList.size());

        for (WebElement countryName : selectFromList) {
            System.out.println(countryName.getText());
            if (countryName.getText().equals("Venezuela")) {
                countryName.click();
                break;
            }
        }
    }

    @FindBy(css = "#dropdown-class-example")
    WebElement dropDown;
    public void dropDownMeth() {
        dropDown.click();
        Select select = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
        select.selectByValue("option2");
    }

    @FindBy(css = "#checkBoxOption1")
    WebElement checkBox1;
    @FindBy(css = "#checkBoxOption2")
    WebElement checkBox2;
    @FindBy(css = "#checkBoxOption3")
    WebElement checkBox3;

    public void testPage(){
        radioB2.click();
        chooseOneCountry();
        dropDownMeth();
        checkBox1.click();
        checkBox2.click();
        checkBox3.click();
    }

}

package TestingRahulAdvanced.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import javax.swing.*;

public class BasePagePO {
    WebDriver driver;
    WebDriverWait wait;

    public BasePagePO(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @BeforeClass
    public void openWebsite(String hostname) {
        System.out.println("Open the next url: " + hostname);
        driver.get(hostname);
    }
}

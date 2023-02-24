package Selenium.AselRadiobAutocomDropDwnChkboxAlertTabsHover;

import Selenium.Util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Selenium.Util.BaseUITest2;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class testRahulAutomationPractice extends BaseUITest2 {
    String url = "https://rahulshettyacademy.com/AutomationPractice/";


    @BeforeClass(alwaysRun = true)
    public void runBefore() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void testRadioButton() {

        WebElement radioButon2 = driver.findElement(By.cssSelector("input[value='radio2']"));
        radioButon2.click();

        WebElement radioButon1 = driver.findElement(By.cssSelector("input[value='radio1']"));
        radioButon1.click();

//        if(radioButon1.isSelected()) {
//            System.out.println("on");
//        }
//        else {
//            System.out.println("off");
//        }

        for (int i = 0; i < 2; i++) {
            radioButon1.click();
            System.out.println(radioButon1.isSelected());
        }
    }

    @Test
    public void testAutocompleteInput() {

        WebElement inputBox = driver.findElement(By.cssSelector("#autocomplete"));
        inputBox.sendKeys("ro");

        List<WebElement> selectFromAutolist = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        System.out.println(selectFromAutolist.size());

        for(WebElement countryName : selectFromAutolist){
            System.out.println(countryName.getText());

            if(countryName.getText().equals("Romania")) {
                countryName.click();

                break;
            }
        }
//        driver.quit();
    }

    @Test
    public void testDropDown(){
        WebElement dropDown = driver.findElement(By.cssSelector("#dropdown-class-example"));
        dropDown.click();

        Select choseOption = new Select(driver.findElement(By.id("dropdown-class-example")));
        choseOption.selectByValue("option3");
    }

    @Test
    public void testCheckBox(){
        WebElement checkbox = driver.findElement(By.cssSelector("#checkBoxOption1"));
        checkbox.click();
        System.out.println(checkbox.isSelected());
    }

    @Test
    public void testSwitchNewWindow(){
        String mainHandle = driver.getWindowHandle();
        System.out.println("Main window: " + mainHandle + "\n");

        WebElement switchToNewButton = driver.findElement(By.cssSelector("#openwindow"));
        switchToNewButton.click();

        Set<String> allPages =  driver.getWindowHandles();
        System.out.println("Windows open after click: " + allPages.size() + "\n" );

        for(String windowHandle : allPages){
            if(mainHandle.equals(windowHandle)){
                System.out.println("Main win ID: " + windowHandle + "\n" +  "Main Url: " + driver.getCurrentUrl() + "\n" + " Main page title: " + driver.getTitle() +"\n");
            }
            else {
                driver.switchTo().window(windowHandle);
                System.out.println("Second win ID: " + windowHandle + "\n" + "Second Url: " + driver.getCurrentUrl() + "\n" + " Second page title: " + driver.getTitle());
            }
        }
    }

    @Test
    public void testNewTab(){
        String mainTabHandle = driver.getWindowHandle();
        System.out.println("Main window: " + mainTabHandle + "\n");

        WebElement newTabButton = driver.findElement(By.cssSelector("#opentab"));
        newTabButton.click();
        System.out.println("main tab: " + driver.getTitle() + "\n");

        Set<String> allPages = driver.getWindowHandles();
        Iterator<String> OneByOnePages = allPages.iterator();
        String mainTab = OneByOnePages.next();
        String secondTab = OneByOnePages.next();
        driver.switchTo().window(secondTab);
        System.out.println("second tab: " + driver.getTitle() + "\n");
        driver.switchTo().window(mainTab);
        System.out.println("second tab: " + driver.getTitle() + "\n");
    }

    @Test
    public void testAlert(){
        WebElement alertInputField = driver.findElement(By.cssSelector("#name"));
        alertInputField.sendKeys("Alex");
        WebElement alertButton  = driver.findElement(By.cssSelector("#alertbtn"));
        alertButton.click();

        driver.switchTo().alert().accept();

        WebElement confirmButton  = driver.findElement(By.cssSelector("#confirmbtn"));
        confirmButton.click();

        driver.switchTo().alert().dismiss();
    }

    @Test
    public void testActionsFrames(){
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).build().perform();
    }

    @Test
    public void testMouseHoverActionsScroll(){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#mousehover"))).build().perform();

    }


}

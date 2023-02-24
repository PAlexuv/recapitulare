package TestingRahul.PageObjectsRahul;

import BaseForTestingRahul.Utils.BaseMethodsUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

public class GetWHandleSwitchTabAlertHoverPO extends BasePageRahulPO {
    public GetWHandleSwitchTabAlertHoverPO(WebDriver driver) {
        super(driver);
    }

    //************ switchNewWindow ****************
    @FindBy(css = "#openwindow")
    WebElement newWindow;
    public void switchNewWindow(){
        System.out.println(driver.getTitle());
        newWindow.click();
        Set<String> pageId = driver.getWindowHandles();
        Iterator<String> iterator = pageId.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());
    }

    //************ switchNewTab ****************
    @FindBy(css = "#opentab")
    WebElement newTab;
    public void switchNewTab(){
        System.out.println(driver.getTitle());
        newTab.click();
        Set <String> pageIdTab = driver.getWindowHandles();
        Iterator<String> iteratorTab = pageIdTab.iterator();
        String parentIdTab = iteratorTab.next();
        String childIdTab = iteratorTab.next();
        driver.switchTo().window(childIdTab);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentIdTab);
        System.out.println(driver.getTitle());
    }

    //************ alertSection ****************
    @FindBy(css = "#name")
    WebElement alertField;
    @FindBy(css = "#alertbtn")
    WebElement alertButton;
    @FindBy(css = "#confirmbtn")
    WebElement confirmButton;
    public void alertSection(){
        actions.moveToElement(alertField).click().keyDown(Keys.SHIFT).sendKeys("ggggg").build().perform();
//        alertField.sendKeys("Alex alert");
        alertButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        alertField.sendKeys("Alex confirm");
        confirmButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    //************ HideShowSection ****************
    @FindBy(css = "#displayed-text")
    WebElement hideShowField;
    @FindBy(css = "#hide-textbox")
    WebElement hideButton;
    @FindBy(css = "#hide-textbox")
    WebElement showButton;
    public void HideShowSection(){
        hideShowField.click();
        actions.moveToElement(hideShowField).click().keyDown(Keys.SHIFT).sendKeys("alex").build().perform();
//        hideShowField.sendKeys("alex");
        System.out.println(hideShowField.getText());
        hideButton.click();
        showButton.click();
    }

    //************ scroolableTable ****************
    @FindBy (css = ".tableFixHead")
    WebElement tableFixedHead;
    @FindBy(css = "table[id='product'] thead")
    WebElement tableHead;
    @FindBy(xpath = "//td[normalize-space()='Smith']")
    WebElement scrollTableSmith;
    public void scroolableTable(){
        //scrolls to bottom of the page
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("scroll(0, 1010)");
// moves to scrollable table
        actions.moveToElement(tableFixedHead).build().perform();
        System.out.println(tableHead.getText());
//get the last name inside scrollable table
        System.out.println(scrollTableSmith.getText());
    }


//    ********************* mousehover outside the frame ***************
    @FindBy (css = "#mousehover" )
    WebElement mouseHoverButton;
    @FindBy(xpath = "//a[normalize-space()='Reload']")
    WebElement optionInsideHover;
    public void mouseHover(){
        driver.get(hostname);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("scroll(0, 500)");
        actions.moveToElement(mouseHoverButton).build().perform();
        System.out.println(optionInsideHover.getText());
        optionInsideHover.click();
    }

/*
    //************************ FRAME + Hover button inside Frame(More) *****************
    @FindBy(css = "#courses-iframe")
    WebElement iFrame;
//    @FindBy (css = "#showHeader")
//    WebElement frameHeader;
//    @FindBy(css = ".fa-user")
//    WebElement frameRegisterButton;

    @FindBy(css = ".header-upper [href='\\#']")
    WebElement frameHoverMoreButton;
    @FindBy(css = ".header-upper .dropdown-menu")
    WebElement DropdownItems;
    @FindBy(css = ".page-title .auto-container .inner-box h1")
    WebElement elementSelectedInHover;


    public void frame(String elementInsideHover) throws InterruptedException {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("scroll(0, 1000)");
        driver.switchTo().frame(iFrame);
//        System.out.println(frameHeader.getText());
//        frameRegisterButton.click();

        actions.moveToElement(frameHoverMoreButton).build().perform();
        System.out.println("Hover button 'more' has this inside: \n" + DropdownItems.getText());
        System.out.println();

        WebElement itemMenu = driver.findElement(By.linkText(elementInsideHover));
        System.out.println("Selected item from hover - keyboard input (frame()): " + itemMenu.getText());
        itemMenu.click();
        Thread.sleep(2000);
        JavascriptExecutor jsExecHover = (JavascriptExecutor) driver;
        jsExecHover.executeScript("scroll(0, 200)");
    }
    public boolean checkFrameHover(String selectedItem){
        System.out.println("Elements in hover selected - take from webelement: " + elementSelectedInHover.getText());

        if(elementSelectedInHover.getText().equals("Part time Jobs")){
            System.out.println("Element page accesed inside hover is - keyboard checkFrameHover(): " + selectedItem);
        }
        else if(elementSelectedInHover.getText().equals("About Us")){
            System.out.println("Element page accesed inside hover - keyboard checkFrameHover(): " + selectedItem);
        }
        else if(elementSelectedInHover.getText().equals("Contact")){
            System.out.println("Element page accesed inside hover - keyboard checkFrameHover(): " + selectedItem);
        }
        return elementSelectedInHover.getText().equals(selectedItem);
    }
*/

    //-***********************-- recap frame + hover inside frame --**********************
    @FindBy (css = "#courses-iframe")
    WebElement iFrame;
    @FindBy(css = "#salesEndHeader")
    WebElement frameHeader;
    @FindBy(css = ".header-upper [href='\\#']")
    WebElement moreButtonHover;
    @FindBy(css = ".header-upper .dropdown-menu")
    WebElement dropdownInsideHover;
    //next page after click hover element:
    @FindBy (css = ".page-title .auto-container .inner-box h1")
    WebElement openedPageAfterHover;

    public void frameActions(String selectedHoverElement){
    JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("scroll(0, 1000)");
        driver.switchTo().frame(iFrame);
        System.out.println("Frame header text, just to be sure we are inside the frame: \n" + frameHeader.getText());
        System.out.println();
//hover button"more"
        actions.moveToElement(moreButtonHover).build().perform();
        System.out.println("Hover button after moving over it, named: " + moreButtonHover.getText());
        System.out.println();
        System.out.println("Hover drop-down list inside button: \n" + dropdownInsideHover.getText());
        System.out.println();
//create webelement for keyboard(string type) input and search for element by linkText
        WebElement hoverItemChosen = driver.findElement(By.linkText(selectedHoverElement));
        System.out.println("Item input from keyboard - string: " + hoverItemChosen.getText());
        System.out.println();
        hoverItemChosen.click();
        BaseMethodsUtils.waitForPresenceOfOneElementGeneric(driver, 5, By.cssSelector(".page-title .auto-container .inner-box h1"));
        System.out.println("Opened page after click hover element has this text: " + openedPageAfterHover.getText());
        System.out.println();
    }
    public boolean checkHoverPageOpened(String openedPage){
            System.out.println("Opened page must have the same text as Upper one - as this is the text of the new page(unless equalsIgnoreCase): " + openedPage);
        return openedPageAfterHover.getText().equalsIgnoreCase(openedPage);
    }

    //-------------- test hover outside the frame: method scoalaIT --------------------
    @FindBy(css = "button#mousehover")
    WebElement mouseHoverIT;
    @FindBy(css = ".mouse-hover-content")
    WebElement hoverITcontent;
    @FindBy(css = ".blinkingText")
    WebElement nextPageElement;
    public void hoverIT(String inputElIT){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("scroll(0, 1000)");
        actions.moveToElement(mouseHoverIT).build().perform();
        System.out.println("Text on mouse hover is: " + mouseHoverIT.getText());
        System.out.println("Dropdown inside hover has: \n" + hoverITcontent.getText());
        WebElement selectOneElInsideHover = driver.findElement(By.linkText(inputElIT));
        System.out.println("Keyboard input: " + selectOneElInsideHover.getText());
        selectOneElInsideHover.click();
    }
    public boolean checkSelectedOptionIT(String chckSelEL){
        System.out.println(nextPageElement.getText());
        return nextPageElement.getText().equalsIgnoreCase(chckSelEL);
    }


    //************ OneMethodToRuleThemAll ****************
    public void testSecondRow() throws InterruptedException {
//        switchNewWindow();
//        switchNewTab();
//        alertSection();
//        HideShowSection();
//        scroolableTable();
//        mouseHover();
//        frame("About Us");
//        checkFrameHover("ABOUT US");
//        frameActions("About Us");
        hoverIT("Top");
        checkSelectedOptionIT("Free Access to InterviewQues/ResumeAssistance/Material");
    }

}

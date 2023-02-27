package AutomationIO.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class PoSandboxAIO extends BasePOPageAIO {

    protected Actions actions = new Actions(driver);
    protected WebDriverWait wait = new WebDriverWait(driver, 3);

    //Buttons Inside Sandbox Page to be clicked
    private By buttonFormField = By.xpath("//a[normalize-space()='Form Fields']");
    private By buttonTables = By.xpath("//a[normalize-space()='Tables']");
    private By buttonSearchBoxes = By.xpath("(//a[normalize-space()='Search Boxes'])[1]");
    private By buttonCalendars = By.xpath("//a[text()='Calendars']");
    private By buttonWindowOperations = By.xpath("//a[text()='Window Operations']");
    private By buttonGestures = By.xpath("//a[text()='Gestures']");
    private By buttonPopups = By.xpath("//a[normalize-space()='Popups']");
    private By buttonModal = By.xpath("//a[normalize-space()='Modals']");
    private By buttonHover = By.xpath("//a[normalize-space()='Hover']");

    //buttons and actions inside each opened page from sandbox parent page
    private By cookieAccept = By.id("cookie_action_close_header");
    private By inputField = By.xpath("(//input[@id='g1103-name'])[1]");
    private By dropdownButton = By.cssSelector("#g1103-doyouhaveanysiblings-button");
    private By dropDownSelect = By.cssSelector("#g1103-doyouhaveanysiblings");
    private By calendarYear = By.xpath("//span[@class='ui-datepicker-year']");
    private By calendarMonth = By.xpath("//span[@class='ui-datepicker-month']");
    private By calendarField = By.id("g1065-selectorenteradate");
    private By calendarArrow = By.xpath("//a[@title='Next']");
    private By searchField = By.id("wp-block-search__input-1");
    private By searchConfirmationButton = By.xpath("//button[contains(text(),'Search')]");
    private By noResultFound = By.xpath("//h4[text()='Nothing Found']");
    private By buttonNewWindow = By.xpath("//button[@onclick='newWindow()']");
    private By map = By.xpath("//canvas[@aria-label='Map']");
    private By alertPopUpButton = By.cssSelector("button[id='alert'] b");
    private By confirmPopUpButton = By.cssSelector("#confirm");
    private By confirmResultPopUp = By.cssSelector("#confirmResult");
    private By promptPopupButton = By.id("prompt");
    private By promptPopupResult = By.id("promptResult");
    private By buttonSimpleModal = By.id("simpleModal");
    private By titleSimpleModal = By.xpath("//div[normalize-space()='Simple Modal']");
    private By paragraphSimpleModal = By.xpath("//p[contains(text(),'Hi, I’m a simple modal.')]");
    private By hoverOverText = By.id("mouse_over");


    public void clickTablesButton() {
        click(buttonTables);
    }

    public void clickCalendarButton() {
        click(buttonCalendars);
    }

    public void clickSearchBoxesButton() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonSearchBoxes));
        click(buttonSearchBoxes);
    }

    public void clickWindowOperationsButton() {
        click(buttonWindowOperations);
    }

    public void clickGesturesButton() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonGestures));
        click(buttonGestures);
    }

    public void clickPopupsButton() {
        click(buttonPopups);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public PoSandboxAIO setInputFieldText(String myText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonFormField));
        click(buttonFormField);
        setText(inputField, myText);
        return this;
    }

    public String getInputFieldText() {
        return getTextByValue(inputField);
    }

    /**
     * select a checkbox
     *
     * @param value range 1 to 3
     */
    public PoSandboxAIO selectCheckBox(String value) {
        click(buttonFormField);
//not setting the BY up as the other private because we need to change the values of the element with a value that we enter
//By from up are always static, always the same
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Water']")));
        driver.findElement(By.xpath("//input[@value='" + value + "']")).click();
//return handle to the SandBox PAge and we use this
        return this;
    }
    public boolean checkboxSelectedIS(String value) {
        return driver.findElement(By.xpath("//input[@value='" + value + "']")).isSelected();
    }

    /**
     * Select Dropdown
     */
    public PoSandboxAIO selectDropdown(String option) throws InterruptedException {
        click(buttonFormField);
////        driver.findElement(dropdownButton).click();
//        click(cookieAccept);
//        click(dropdownButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownButton));
//        Thread.sleep(2000);
        Select dDown = new Select(driver.findElement(dropDownSelect));
        dDown.selectByValue(option);
        return this;
    }
    public String getDropdownText() {
//        click(buttonFormField);
        Select dDown = new Select(driver.findElement(dropDownSelect));
        return dDown.getFirstSelectedOption().getText();
    }

    /**
     * Selected Radio Button
     */
    public PoSandboxAIO selectRadioButton(String selectedRadioButton) {
        click(buttonFormField);
        driver.findElement(By.cssSelector("input[value='" + selectedRadioButton + "']")).click();
        return this;
    }
    public boolean selectedRadioButtonIS(String selectedRadioButton) {
        return driver.findElement(By.cssSelector("input[value='" + selectedRadioButton + "']")).isSelected();
    }

    /**
     * Item price from Table
     */
    public String findTablePrice(String item) {
        clickTablesButton();
        return driver.findElement(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
    }

    /**
     * testCalendar
     */
    public PoSandboxAIO selectDate(String month, String day, String year) {
        clickCalendarButton();
        click(calendarField);
        while (true) {
            String currentYear = getTextByText(calendarYear);
            String currentMonth = getTextByText(calendarMonth);
            if (currentYear.equals(year) && currentMonth.equals(month)) {
                break;
            }
            click(calendarArrow);
        }
        driver.findElement(By.xpath("//table//a[text()='" + day + "']")).click();
        return this;
    }

    public String getDate() {
        clickCalendarButton();
        click(calendarField);
        return getTextByValue(calendarField);
    }

    /**
     * search for article and go back to search box if no article found
     */
    public boolean search(String text) {
        clickSearchBoxesButton();
        setText(searchField, text);
        click(searchConfirmationButton);
        if (driver.findElements(noResultFound).size() > 0) {
            goBack();
            return false;
        }
        return true;
    }

    public void clickNewWindowButton() {
        clickWindowOperationsButton();
        click(buttonNewWindow);
    }

    public void switchToNewWindow() {
        clickNewWindowButton();
        //Get current window handle
        String currentWindow = getWindowHandle();
        //Get all window handles
        Set<String> handles = getWindowHandles();
        //Switch to new window
        Iterator<String> iter = handles.iterator();
        String newWindow = null;
        while (iter.hasNext()) {
            newWindow = iter.next();
            if (!currentWindow.equals(newWindow)) {
                driver.switchTo().window(newWindow);
            }
        }
    }

    public void dragMap(int x, int y) {
        clickGesturesButton();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(map));
        dragAndDropByOffset(map, x, y);
    }

    public void clickAlertPopup() {
        clickPopupsButton();
        click(alertPopUpButton);
    }

    public void clickConfirmPopup() {
        click(confirmPopUpButton);
    }

    public String getConfirmPopupSelection() {
        return getTextByText(confirmResultPopUp);
    }

    public void clickPromptPopup() {
        clickPopupsButton();
        click(promptPopupButton);
    }

    public void waitForPromptPopupResult(String expectedText) {
        waitForElementText(promptPopupResult, expectedText);
    }

    public String getConfirmPopupPrompt() {
        return getTextByText(promptPopupResult);
    }

    public PoSandboxAIO openModal() {
        click(buttonModal);
        click(buttonSimpleModal);
        getPageTitle();
        return this;
    }
    public String getModalTitle(){
        return getTextByText(titleSimpleModal);
    }
    public String getModalParagraph(){
        return getTextByText(paragraphSimpleModal);
    }

    public PoSandboxAIO openHover() {
        click(buttonHover);
        hoverOverElement(hoverOverText);
        return this;
//        am facut basePage Method deci nu se mai aplica acest cod, rulam codul din basePage codul de jos este aferent hoverOverElement
//        WebElement mouseHover = driver.findElement(hoverOverText);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(mouseHover);
    }
    public String hoverText(){
        return getTextByText(hoverOverText);
    }

//go to map using basepage methods and drag map
    public PoSandboxAIO scrollMapIntoVIew(int a, int b){
        click(cookieAccept);
        scrollElementIntoView(buttonGestures);
//        waitForElement(buttonGestures);
        click(buttonGestures);
        scrollElementIntoView(map);
        dragAndDropByOffset(map, a, b);
        return this;
    }

}
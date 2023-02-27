package AutomateIO;

import AutomationIO.PageObjects.PoNavigationBarAIO;
import AutomationIO.PageObjects.PoSandboxAIO;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class TestSandboxAIO extends BaseTestAIO{

   //now we can get rid of this line as it is extended from BaseTestAIO -  PoSandboxAIO sandbox = new PoSandboxAIO();

    //go to sandbox page
    @BeforeClass
    public void testNavigateToSandboxPage(){
        // no need to instantiate as we extended PoNavigationBarAIO navBar from BaseTestAIO
        navBarAIO.sandboxAIO();
    }

    @Test(description = "Verify the page title")
    public void testPageTitle() {
        String title = sandboxAIO.getPageTitle();
        System.out.println(title);
        assertEquals(title,"Automation Testing Practice Website | automateNow |");
    }

    @Test(description = "search box, enter text")
    public void testSearchBox(){
        String myText = "hello";
        //before it will do the beforeclass
//        sandboxAIO.clickformFieldButton(); no need we set it beforeclass up..
        sandboxAIO.setInputFieldText(myText);
        //verify that the text entered was properly entered
        String displayText = sandboxAIO.getInputFieldText();
        System.out.println(displayText);
        assertEquals(displayText, myText);
    }

    /**
     * VEZI CE ARE
     */
    @Test(description = "checkBoxes")
    public void testCheckBox(){
        sandboxAIO.selectCheckBox("Water");
        assertTrue(sandboxAIO.checkboxSelectedIS("Water"));
        assertFalse(sandboxAIO.checkboxSelectedIS("Milk"));
    }

    @Test(description = "Select from dropdown")
    public void testDropDown() throws InterruptedException {
        String myOption = "No";
        sandboxAIO.selectDropdown(myOption);
//        assertEquals(sandboxAIO.getDropdownText(), myOption);
    }
//LA FEL SUS

    @Test(description = "select radioButton")
    public void testRadioButton(){
        String radio = "Red";
        String radio2 = "Blue";
        sandboxAIO.selectRadioButton(radio);
        assertTrue(sandboxAIO.selectedRadioButtonIS(radio));
        goBack();
        sandboxAIO.selectRadioButton(radio2);
        assertTrue(sandboxAIO.selectedRadioButtonIS(radio2));
        assertFalse(sandboxAIO.selectedRadioButtonIS(radio));
    }

    @Test(description = "Find the price of an item in a table")
    public void testItemPrice(){
        String laptopPrice = sandboxAIO.findTablePrice("Laptop");
        Assert.assertEquals(laptopPrice, "$1200.00");
    }

    @Test(description = "Operate Calendar")
    public void testCalendar(){
        sandboxAIO.selectDate("April", "15", "2024");
        String date = sandboxAIO.getDate();
        assertEquals(date, "April 15, 2024" );
    }

    @Test(description = "Search for article and go back if no article was found")
    public void testSearchBlog(){
        boolean search;
        search = sandboxAIO.search("gibberish");
        assertFalse(search);
    }

    @Test(description = "Working with multiple open windows")
    public void testMultipleOpenWindows(){
        sandboxAIO.switchToNewWindow();
        String pageTitle = getPageTitle();
        assertTrue(pageTitle.contains("Google"));
    }
    @Test(description = "Closes a second open windows")
    public void testCloseSecondWindows(){
        sandboxAIO.switchToNewWindow();
        closeWindow();
        int numberOfOpenWindows = getNumberOfOpenWindows();
        assertEquals(numberOfOpenWindows, 1);
    }

    @Test(description = "Working with multiple tabs")
    public void testMultipleTabs(){
        openNewTab();
        sandboxAIO.switchToNewWindow();
        goToUrl("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjcnev40qb9AhUGSPEDHV7ICUAQPAgI");
        String pageTitle = getPageTitle();
        System.out.println("page title: " + pageTitle);
        assertEquals(pageTitle,"Google");
        closeWindow();
        System.out.println("page title: " + pageTitle);
        int numberOfOpenWindows = getNumberOfOpenWindows();
        assertEquals(numberOfOpenWindows, 2);
    }

    @Test(description = "Test click and Drag operation on a map")
    public void testClickAndDrag(){
        int x_coordinate = 100;
        int y_coordinate = 50;

        sandboxAIO.dragMap(x_coordinate, y_coordinate);
    }

    @Test(description = "Test popup windows")
    public void testPopUps() {
        sandboxAIO.clickAlertPopup();
        dismissPopUp();

        sandboxAIO.clickConfirmPopup();
        acceptPopUp();
        String confirmSelection = sandboxAIO.getConfirmPopupSelection();
        Assert.assertEquals(confirmSelection, "OK it is!");
        System.out.println(confirmSelection);
    }

    @Test(description = "Test popup windows")
    public void testPromptPopup(){
        sandboxAIO.clickPromptPopup();
        String name = "name";
        setPopupText(name);
        acceptPopUp();
        sandboxAIO.waitForPromptPopupResult(String.format("Nice to meet you, %s!", name));
        String confirmPrompt = sandboxAIO.getConfirmPopupPrompt();
        Assert.assertEquals(confirmPrompt, ("Nice to meet you, "+name+"!"));
        System.out.println(confirmPrompt);
    }

    @Test(description = "Test a Javascript modal")
    public void testModal(){
        sandboxAIO.openModal();
        String titleSimpleModal = sandboxAIO.getModalTitle();
        Assert.assertEquals(titleSimpleModal, "Simple Modal");
        String paragraphSimpleModal = sandboxAIO.getModalParagraph();
        Assert.assertEquals(paragraphSimpleModal, "Hi, I’m a simple modal.");
    }

    @Test(description = "Test mouse over")
    public void testHovering(){
    sandboxAIO.openHover();
    String moseHoverText = sandboxAIO.hoverText();
        System.out.println(moseHoverText);
    Assert.assertEquals(moseHoverText, "You did it!");
    }

    @Test(description = "Test scrolling an element into view")
    public void testScrollElementIntoView() {
    sandboxAIO.scrollMapIntoVIew(100, 50);
    }

    @Test(description = "Test scrolling a webpage")
    public void testScrollPage(){
        sandboxAIO.scrollPage(0, 500);
    }

}

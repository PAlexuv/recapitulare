package PrisacaBarnova.PageObjects;

import org.openqa.selenium.By;

public class PoNavBarPB extends PoBasePagePB{
    By clickStupinaButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Stupina']");

    public PoStupinaPB clickStupina(){
        driver.findElement(clickStupinaButton).click();
        return new PoStupinaPB();
    }
}

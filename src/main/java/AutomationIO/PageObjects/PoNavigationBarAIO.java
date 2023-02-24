package AutomationIO.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PoNavigationBarAIO extends BasePOPageAIO {
    private By sandBoxButton = By.cssSelector("span[data-hover='Sandbox']");
    private By trainingButton = By.cssSelector("span[data-hover='Training']");
    private By reviewsButton = By.cssSelector("span[data-hover='Reviews']");

    public PoSandboxAIO sandboxAIO(){
        driver.findElement(sandBoxButton).click();
        System.out.println("Sandbox page opened");
        return new PoSandboxAIO();
    }

    public POTrainingAIO trainingAIO(){
        driver.findElement(trainingButton).click();
        System.out.println("Training page opened");
        return new POTrainingAIO();
    }

    public PoReviewsAIO reviewsAIO(){
        hoverOverElement(reviewsButton);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewsButton)).click();
        return new PoReviewsAIO();
    }

}

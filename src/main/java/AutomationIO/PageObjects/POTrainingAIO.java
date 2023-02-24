package AutomationIO.PageObjects;

import org.openqa.selenium.By;

public class POTrainingAIO extends BasePOPageAIO {
    private By firstDownText = By.cssSelector("a[href='https://www.bugraptors.com/blog/tech-talks-with-marco-a-cruz']");
    private By secondDownText = By.cssSelector("a[href='https://testomat.io/blog/singleton-design-pattern-how-to-use-it-in-test-automation/']");

    public String getTrainingTitle(){
        return driver.getTitle();
    }

    public String getFirstTexFromContributions(){
    return getTextByText(firstDownText);
    }

    public String getSecondTextContribution(){
        return getTextByText(secondDownText);
    }

}

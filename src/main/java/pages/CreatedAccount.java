package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class CreatedAccount extends BasePage {
    private By createdMessage= By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    public CreatedAccount(WebDriver driver) {
        super(driver);
    }
    public String createdMessageText() throws Exception {
       return BrowserActions.waitAndGetElementText(createdMessage,driver);
    }

}

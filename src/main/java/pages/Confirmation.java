package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class Confirmation extends BasePage {
    private  By messageBar=By.xpath("//*[@id=\"maincontent\"]/div[1]");
    public Confirmation(WebDriver driver) {
        super(driver);
    }
    public String getMessageBarText() throws Exception {
        Thread.sleep(10000);
        String Title= BrowserActions.waitAndGetElementText(messageBar,driver);
        return Title;
    }


}

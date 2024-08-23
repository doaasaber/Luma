package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class PlaceOrder extends BasePage {
    private  By checkBox= By.id("billing-address-same-as-shipping-checkmo");
    private  By placeOrderButton=By.xpath("//button[@class='action primary checkout']");
    public PlaceOrder(WebDriver driver) {
        super(driver);
    }
    public Confirmation placeOrder() throws Exception {
        boolean check= BrowserActions.waitAndCheckElement(checkBox,driver);
        if (!check){
            BrowserActions.waitAndClickOnWebElement(checkBox,driver);
        }
        BrowserActions.waitAndClickOnWebElement(placeOrderButton,driver);
        return new Confirmation(driver);
    }
}

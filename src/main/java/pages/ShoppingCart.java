package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class ShoppingCart extends BasePage{
    private  By proceedToCheckoutButton= By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button");
    private  By updateShoppingCartButton=By.xpath("//button[@title='Update Shopping Cart']");
    public ShoppingCart(WebDriver driver) {
        super(driver);
    }
    public ShippingData clickOnProceedToCheckout() throws Exception {
        BrowserActions.scrollIntoView(updateShoppingCartButton,driver);
        BrowserActions.waitAndClickOnWebElement(proceedToCheckoutButton,driver);
        return new ShippingData(driver);

    }
}

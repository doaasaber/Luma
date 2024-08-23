package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class ComparsionProductList extends BasePage {
    private  By addToCartButton=By.xpath("//button[@class='action tocart primary']");
    private  By messageBar=By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div");
    private  By shoppingCartButton=By.linkText("shopping cart");
    public ComparsionProductList(WebDriver driver) {
        super(driver);
    }

    public Product clickOnAddtoCartButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(addToCartButton,driver);
        return new Product(driver);
    }
    public String getMessageBarText() throws Exception {
        String Title= BrowserActions.waitAndGetElementText(messageBar,driver);
        return Title;
    }

//    public ShoppingCart clickOnShoppingCartButton() throws Exception {
//        BrowserActions.waitAndClickOnWebElement(ShoppingCartButton,driver);
//        return new ShoppingCart(driver);}


}

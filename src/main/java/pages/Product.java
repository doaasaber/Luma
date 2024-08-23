package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class Product extends BasePage {
    private  By addToCartButton=By.id("product-addtocart-button");
    private  By productTitle=By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1/span");
    private  By productSize=By.xpath("//*[starts-with(@id, 'option-label-size-143-item')][1]");
    private  By productColor=By.xpath("//*[starts-with(@id, 'option-label-color-93-item')][1]");
    private  By addToCompareButton=By.xpath("//a[@class='action tocompare']");
    private   By messageBar=By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div");
    private  By comparisonList=By.linkText("comparison list");
    private  By shoppingCart=By.linkText("shopping cart");
    private  By shoppingCartButton=By.linkText("shopping cart");

    public Product(WebDriver driver) {
        super(driver);
    }
    public String getProductTitle() throws Exception {
        String Title= BrowserActions.waitAndGetElementText(productTitle,driver);
        return Title;
    }


    public void selectSize() throws Exception {
        BrowserActions.scrollIntoView(productSize,driver);
        BrowserActions.waitAndClickOnWebElement(productSize,driver);

    }
    public void selectColor() throws Exception {
        BrowserActions.waitAndClickOnWebElement(productColor,driver);

    }
    public void clickAddToCompare() throws Exception {
        BrowserActions.scrollIntoView(addToCompareButton,driver);
        BrowserActions.waitAndClickOnWebElement(addToCompareButton,driver);

    }
    public String getMessageBarText() throws Exception {
        String Title= BrowserActions.waitAndGetElementText(messageBar,driver);
        return Title;
    }

    public ComparsionProductList clickOnComparisonList() throws Exception {
        BrowserActions.waitAndClickOnWebElement(comparisonList,driver);
        return new ComparsionProductList(driver);

    }
    public ShoppingCart clickOnShoppingCart() throws Exception {
        BrowserActions.waitAndClickOnWebElement(shoppingCart,driver);
        return new ShoppingCart(driver);
    }
    public void clickAddToCartButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(addToCartButton,driver);
    }
    public ShoppingCart clickOnShoppingCartButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(shoppingCartButton,driver);
        return new ShoppingCart(driver);}
}

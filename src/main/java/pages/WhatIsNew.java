package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class WhatIsNew extends BasePage {

    private  By firstProduct=By.xpath("//ol/li[1]//img");
    private  By addToCartButton=By.xpath("//button[@title='Add to Cart']");
    private  By firstProductTitle=By.xpath("//ol/li[1]//strong/a");


    public WhatIsNew(WebDriver driver) {
        super(driver);

    }

    public Product clickOnProduct() throws Exception {
        BrowserActions.waitAndClickOnWebElement(firstProduct, driver);
        return new Product(driver);
    }


}

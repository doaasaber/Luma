package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class ShippingData extends BasePage {
    private  By email=By.id("customer-email");
    private  By firstName= By.xpath("//input[@name='firstname']");
    private  By lastName=By.xpath("//input[@name='lastname']");
    private  By address=By.xpath("//input[@name='street[0]']");
    private  By city=By.xpath("//input[@name='city']");
    private  By state=By.xpath("//select[@name='region_id']");
    private  By postalCode=By.xpath("//input[@name='postcode']");
    private  By phoneNumber=By.xpath("//input[@name='telephone']");
    private  By shippingMethod=By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input");
    private  By nextButton=By.xpath("//button[@class='button action continue primary']");

    public ShippingData(WebDriver driver) {
        super(driver);
    }
    public void fillShippingData(String emailAddress,String fName,String lName , String addressName,String cityName,String stateName,String postalCodeNumber,String phoneNumberr) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(emailAddress,email,driver);
        BrowserActions.scrollIntoView(firstName,driver);
        BrowserActions.waitAndEnterTextInWebElement(fName,firstName,driver);
        BrowserActions.waitAndEnterTextInWebElement(lName,lastName,driver);
        BrowserActions.waitAndEnterTextInWebElement(addressName,address,driver);
        BrowserActions.waitAndEnterTextInWebElement(cityName,city,driver);
        BrowserActions.waitAndSelectElement(stateName,state,driver);
        BrowserActions.scrollIntoView(postalCode,driver);
        BrowserActions.waitAndEnterTextInWebElement(postalCodeNumber,postalCode,driver);
        BrowserActions.waitAndEnterTextInWebElement(phoneNumberr,phoneNumber,driver);
        BrowserActions.waitAndClickOnWebElement(shippingMethod,driver);

    }

    public PlaceOrder clickOnNextButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(nextButton,driver);
        return new PlaceOrder(driver);
    }
}

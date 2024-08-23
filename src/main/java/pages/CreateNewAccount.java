package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class CreateNewAccount extends BasePage {

    private  By firstName= By.xpath("//*[@id=\"firstname\"]");
    private  By lastName=By.xpath("//*[@id=\"lastname\"]");
    private  By email=By.xpath("//*[@id=\"email_address\"]");
    private  By password=By.xpath("//*[@id=\"password\"]");
    private  By confirmPassword=By.xpath("//*[@id=\"password-confirmation\"]");
    private  By createButton=By.xpath("//button[@title='Create an Account']");

    public CreateNewAccount(WebDriver driver) {
        super(driver);
    }

    public void fillData(String fname,String lname,String emailaddress,String pass,String confirmedpass) throws Exception {
     BrowserActions.waitAndEnterTextInWebElement(fname,firstName,driver);
     BrowserActions.waitAndEnterTextInWebElement(lname,lastName,driver);
     BrowserActions.waitAndEnterTextInWebElement(emailaddress,email,driver);
     BrowserActions.waitAndEnterTextInWebElement(pass,password,driver);
     BrowserActions.waitAndEnterTextInWebElement(confirmedpass,confirmPassword,driver);

    }

    public CreatedAccount clickOnCreateButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(createButton,driver);
        return new CreatedAccount(driver);

    }
}

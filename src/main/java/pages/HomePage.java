package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private  By createAccount= By.linkText("Create an Account");
    private  By cart=By.xpath("/html/body/div[2]/header/div[2]");
    private  By WhatIsNew=By.xpath("//*[@id=\"ui-id-3\"]");

    public HomePage(WebDriver driver) throws Exception {
        super(driver);

    }

    public CreateNewAccount createNewAccount(WebDriver driver){
        driver.findElement(createAccount).click();
        return new CreateNewAccount(driver);
    }

    public WhatIsNew clickOnWhatIsNew(WebDriver driver){
        driver.findElement(WhatIsNew).click();
        return new WhatIsNew(driver);
    }
}
